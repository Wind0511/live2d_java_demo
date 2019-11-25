package com.wind.live2dDemo.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public class ModelList {

	/**
	 * 
	 * @Description:获取模型列表
	 * @return
	 * @author: chenhaoyu
	 * @throws IOException
	 * @time:Mar 23, 2019 10:36:41 AM
	 */
	public static JSONObject getList() throws IOException {
		return FileUtils.readJsonFromClassPath("model_list.json", JSONObject.class);
	}

	/**
	 * 
	 * @Description:获取模组名称
	 * @param id
	 * @return
	 * @throws IOException
	 * @author: chenhaoyu
	 * @time:Mar 23, 2019 12:04:30 PM
	 */
	public static Object idToName(int id) throws IOException {
		JSONObject modelListJson = getList();
		JSONArray models = modelListJson.getJSONArray("models");
		int realId = (id % models.size()) == 0 ? models.size() : (id % models.size());
		return models.get(realId - 1);
	}

}
