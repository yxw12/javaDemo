package com.yxw.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Converter<S,T>
 *     S:source 需要转换的源的类型
 *     T：target 需要转换的目标类型
 * Created by Yan on 2018/8/4.
 */
public class DateConverter implements Converter<String,Date>{
    @Override
    public Date convert(String source) {
        // 把字符串转换为日期类型
        try {
            Date date = new SimpleDateFormat("yyy-MM-dd HH:mm:ss").parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 如果转换异常则返回空
        return null;
    }
}
