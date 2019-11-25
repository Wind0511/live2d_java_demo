package com.wind.live2dDemo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class SpecialController {

	

	@RequestMapping("/special")
	@ResponseBody
	public JSONArray times(Integer n) {

		if (n == null || n < 0) {
			n = 5;
		}

		JSONArray result = new JSONArray();

		for (int i = 1; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			red().stream().forEach(red -> sb.append(red + " "));
			JSONObject child = new JSONObject();
			child.put("blue", bule());
			child.put("red", sb.toString());
			result.add(child);
		}
		return result;
	}

	private List<Integer> red() {
		Random random = new Random();
		List<Integer> pool = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= 33; i++) {
			pool.add(i);
		}
		for (int i = 1; i <= 6; i++) {
			int flag = random.nextInt(pool.size());
			int redtemp = pool.get(flag);
			result.add(redtemp);
			pool.remove(flag);
		}
		return result.stream().sorted(Integer::compareTo).collect(Collectors.toList());
	}

	private Integer bule() {
		Random random = new Random();
		return (random.nextInt(16) + 1);
	}

}
