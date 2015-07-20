package com.cartmatic.extend.sqlhelp.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;


public class SQLHelper {

	private String sql;
	private static final Pattern paramPattern = Pattern.compile("");

	public SQLHelper(String sql) {
		this.sql = sql;
	}
/*
 * 
 * */
	public String parepareSQLtext(Map<String, Object> param) throws Exception {
		String[] ParamExps = StringUtils.substringsBetween(sql, "{", "}");
		String result = sql;
		if(ParamExps==null){
			return sql;
		}
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		for (String paramExp : ParamExps) {
			paramMap.put("{" + paramExp + "}", StringUtils.substringBetween(paramExp, "#"));
		}
		for (String key : paramMap.keySet()) {
			String propertyName = (String)paramMap.get(key);
			if (param.containsKey(propertyName)) {
				Object value=param.get(propertyName);
				if(value == null){
					continue;
				}
				String valueString = StringUtils.replace(key, "{", "");
				valueString = StringUtils.replace(valueString, "?","");
				valueString = StringUtils.replace(valueString, "@","");
				valueString = StringUtils.replace(valueString, "#" + propertyName + "#",  value+"");
				valueString = StringUtils.replace(valueString, "}", "");
				paramMap.put(key, valueString);
			} else {
				paramMap.put(key, null);
			}
		}
		for (String key : paramMap.keySet()) {
			Object value = paramMap.get(key); 
			if (value != null) {
				result = StringUtils.replace(result, key, value.toString());
			} else {
				result = StringUtils.replace(result, key, "");
			}
		}
		
		return result;
	}
	
	
	public String parepareSQL(Map<String, String> param) throws Exception {
		String[] ParamExps = StringUtils.substringsBetween(sql, "{", "}");
		String result = sql;
		if(ParamExps==null){
			return sql;
		}
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		for (String paramExp : ParamExps) {
			paramMap.put("{" + paramExp + "}", StringUtils.substringBetween(paramExp, "#"));
		}
		for (String key : paramMap.keySet()) {
			String propertyName = (String)paramMap.get(key);
			if (param.containsKey(propertyName) && StringUtils.isNotEmpty(param.get(propertyName))) {
				Object value=param.get(propertyName);
				String valueString = StringUtils.replace(key, "{", "");
				valueString = StringUtils.replace(valueString, "?","");
				valueString = StringUtils.replace(valueString, "@","");
				if(value instanceof Object[]){
					Object[] array=(Object[])value;
					String arrayValue="";
					for (Object object : array) {
						if(object instanceof Number){
							arrayValue+=((Number)object).toString()+",";
						}else{
							arrayValue+= "'"+object+"'"+",";
						}
					}
					if(arrayValue.endsWith(",")){
						arrayValue=arrayValue.substring(0, arrayValue.length()-1);
					}
					valueString = StringUtils.replace(valueString, "#" + propertyName + "#",arrayValue);
				}else{
					if(value instanceof Number){
						valueString = StringUtils.replace(valueString, "#" + propertyName + "#", ((Number)value).toString());
					}else{
						valueString = StringUtils.replace(valueString, "#" + propertyName + "#", "'"+value+"'");
					}
				}
				
				valueString = StringUtils.replace(valueString, "}", "");
				paramMap.put(key, valueString);
			} else {
				paramMap.put(key, null);
			}
		}
		
		for (String key : paramMap.keySet()) {
			Object value = paramMap.get(key);
			if (value != null) {
				result = StringUtils.replace(result, key, value.toString());
			} else {
				result = StringUtils.replace(result, key, "");
			}
		}
		return result;
	}

	
	
}
