package com.yxw.ssm.controller.converter;

import org.springframework.core.convert.converter.Converter;

public class CustomStringConverter implements Converter<String, String> {

	@Override
	public String convert(String source) {
		try {
			source = source.trim();
			if(source.equals("")){
				source = null;
			}
			return source;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
