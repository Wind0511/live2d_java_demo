package com.wind.live2dDemo.util;

import com.alibaba.fastjson.JSONArray;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class ModelTextures {

	
	private static Map<String, JSONArray> cache = new HashMap<String, JSONArray>();

	
	public static JSONArray getTextures(String modelName, int id) {
		JSONArray list = getList(modelName);
		if (list.isEmpty()) {
			return new JSONArray();
		}
		Object obj = list.get(id - 1);
		if (obj instanceof JSONArray) {
			return (JSONArray) obj;
		} else {
			return new JSONArray().fluentAdd(obj);
		}

	}

	
	public static JSONArray getList(String modelName) {
		if (cache.containsKey(modelName)) {
			return cache.get(modelName);
		} else {
			JSONArray textures = getTextures(modelName);
			cache.put(modelName, textures);
			return textures;
		}
	}

	
	private static JSONArray getTextures(String modelName) {
		if (FileUtils.exists("/model/" + modelName + "/textures_order.json")) {
			try {
				List<String> texture_00 = getOrderedFileName(modelName, "texture_00");
				List<String> texture_01 = getOrderedFileName(modelName, "texture_01");
				List<String> texture_02 = getOrderedFileName(modelName, "texture_02");
				List<String> texture_03 = getOrderedFileName(modelName, "texture_03");

				JSONArray result = new JSONArray();
				for (int i = 0; i < texture_00.size(); i++) {
					for (int j = 0; j < texture_01.size(); j++) {
						for (int k = 0; k < texture_03.size(); k++) {
							JSONArray temp = new JSONArray();
							temp.add(texture_00.get(i));
							temp.add(texture_01.get(j));
							temp.add(texture_02.get(j));
							temp.add(texture_03.get(k));
							result.add(temp);
						}
					}
				}
				return result;
			} catch (Exception e) {
				return new JSONArray();
			}
		} else {
			try {
				return getAllTextureFileName(modelName);
			} catch (FileNotFoundException e) {
				return new JSONArray();
			}
		}
	}

	
	private static List<String> getOrderedFileName(String modelname, String foldername) throws FileNotFoundException {
		String serverpath = ResourceUtils.getURL("classpath:static").getPath();
		String[] namesTemp = FileUtils.getFileName(serverpath + "/model/" + modelname + "/" + foldername);
		List<String> list = Arrays.asList(namesTemp).stream().sorted(String::compareTo).collect(Collectors.toList());

		List<String> resultList = new ArrayList<String>();
		for (String name : list) {
			resultList.add("../model/" + modelname + "/" + foldername + "/" + name);
		}
		return resultList;
	}

	
	private static JSONArray getAllTextureFileName(String modelname) throws FileNotFoundException {
		String serverpath = ResourceUtils.getURL("classpath:static").getPath();
		String[] namesTemp = FileUtils.getFileName(serverpath + "/model/" + modelname);
		String texturefolder = "";
		for (String name : namesTemp) {
			if (name.startsWith("textures")) {
				texturefolder = name;
			}
		}
		String[] names = FileUtils.getFileName(serverpath + "/model/" + modelname + "/" + texturefolder);
		List<String> list = Arrays.asList(names).stream().sorted(String::compareTo).collect(Collectors.toList());
		JSONArray jsonArray = new JSONArray();
		for (String name : list) {
			jsonArray.add("../model/" + modelname + "/" + texturefolder + "/" + name);
		}
		return jsonArray;
	}

}
