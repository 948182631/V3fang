package com.fang.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class PropertiesUtil {

	protected static final Logger logger = Logger
			.getLogger(PropertiesUtil.class);

	/**
	 * 读取配置文件
	 * 
	 */
	private static final HashMap<Object,Object> propsMap = new HashMap<Object,Object>(5);
	public static final String defaultConfig = "weixinconfig.properties";
	private Properties props;
	private String propsFile;

	private PropertiesUtil(String fileName) {

		props = null;
		propsFile = null;
		if (isEmpty(fileName, true))
			propsFile = defaultConfig;
		else
			propsFile = fileName;
		if (props == null) {
			props = new Properties();
		}
		try {
			props.load(PropertiesUtil.class.getClassLoader()
					.getResourceAsStream(propsFile));
		} catch (IOException e) {
			logger.error("解析" + propsFile + "文件出错:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static synchronized PropertiesUtil getInstance() {
		PropertiesUtil propsUtil = (PropertiesUtil) propsMap.get(defaultConfig);
		if (propsUtil == null) {
			propsUtil = new PropertiesUtil(defaultConfig);
			propsMap.put(defaultConfig, propsUtil);
		}
		return propsUtil;
	}

	public String getProperty(String cfgName) {
		return props.getProperty(cfgName);
	}

	public static boolean isEmpty(String s, boolean trimmed) {
		if (trimmed)
			return s == null || "".equals(s.trim());
		return s == null || "".equals(s);
	}

	public static void main(String[] args) {
		String s = PropertiesUtil.getInstance().getProperty("uploadFileMaxSize");
		System.out.println(s);
	}
	
}
