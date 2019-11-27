package com.wind.live2dDemo.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public class ModelList {

	
	public static JSONObject getList() throws IOException {
		return FileUtils.readJsonFromClassPath("model_list.json", JSONObject.class);
	}

	
	public static Object idToName(int id) throws IOException {
		JSONObject modelListJson = getList();
		JSONArray models = modelListJson.getJSONArray("models");
		int realId = (id % models.size()) == 0 ? models.size() : (id % models.size());
		return models.get(realId - 1);
	}

}
