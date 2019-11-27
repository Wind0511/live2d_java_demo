package com.wind.live2dDemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

public class FileUtils {
	public static <T> T readJsonFromClassPath(String path, Type type) throws IOException {
		if (!path.startsWith("/static/")) {
			path = "/static/" + path;
		}
		ClassPathResource resource = new ClassPathResource(path);
		if (resource.exists()) {
			return JSON.parseObject(resource.getInputStream(), StandardCharsets.UTF_8, type,
					// 自动关闭流
					Feature.AutoCloseSource,
					// 允许注释
					Feature.AllowComment,
					// 允许单引号
					Feature.AllowSingleQuotes,
					// 使用 Big decimal
					Feature.UseBigDecimal);
		} else {
			throw new IOException();
		}
	}

	public static boolean exists(String path) {
		if (!path.startsWith("/static/")) {
			path = "/static/" + path;
		}
		ClassPathResource resource = new ClassPathResource(path);
		return resource.exists();
	}

	
	public static String[] getFileName(String path) {
		File file = new File(path);
		String[] filename = file.list();
		return filename;
	}

}
