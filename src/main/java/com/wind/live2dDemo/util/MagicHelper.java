package com.wind.live2dDemo.util;

import java.util.HashMap;
import java.util.Map;

public class MagicHelper {
	public static final String ID = "id";
	public static final String TID = "tid";

	public static Map<String, Integer> getIdMap(String origin) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put(ID, 1);
		result.put(TID, 1);
		try {
			String[] ids = origin.split("-");
			int id = Integer.valueOf(ids[0]);
			if (id > 0) {
				result.put(ID, id);
			}
			int tid = Integer.valueOf(ids[1]);
			if (tid > 0) {
				result.put(TID, tid);
			}
			return result;
		} catch (Exception e) {
//			e.printStackTrace();
			return result;
		}
	}

}
