package com.cartmatic.extend.sqlhelp.util;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.util.JSONUtils;

import com.mysql.jdbc.ResultSet;


/**
 *  用于项目执行原生态sql，由  ResultSet rs结果集转换成BeanList
 *  <code>SqlHelp.java</code>
 *  <p> 杨荣忠
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-7-15 下午04:22:10	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class SqlHelp
{

	/**功能:
	 * <p>作者 杨荣忠 2015-7-15 下午04:21:46
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 功能:ResultSet转json数组
	 * <p>作者 杨荣忠 2015-7-15 下午04:23:42
	 * @param rs
	 * @return
	 */
    public static final JSONArray ResultSetToJsonArray(ResultSet rs) {
        JSONObject element = null;
        JSONArray ja = new JSONArray();
        ResultSetMetaData rsmd = null;
        String columnName, columnValue = null;
        try {
            rsmd = rs.getMetaData();
            while (rs.next()) {
                element = new JSONObject();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    columnName = rsmd.getColumnName(i + 1);
                    columnValue = rs.getString(columnName);
                    element.put(columnName, columnValue);
                }
                ja.add(element);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ja;
    }
    
	/**
	 * * 封装将jsonArray对象转换为java集合对象 
	 * 
	 * @param <T> *
	 * @param clazz *
	 * @param jsons *
	 * @return
	 */
	@SuppressWarnings("all")
	public static <T> List<T> getJavaCollection(T clazz, JSONArray jsonArray) {
		List<T> objs = null;
		//JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(jsons);
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd HH:mm:ss"}) );
		if (jsonArray != null) {
			objs = new ArrayList<T>();
			List list = (List) JSONSerializer.toJava(jsonArray);
			for (Object o : list) {
				JSONObject jsonObject = JSONObject.fromObject(o);
				T obj = (T) JSONObject.toBean(jsonObject, clazz.getClass());
				objs.add(obj);
			}
		}
		return objs;
	}
	
	/**
	 * * 封装将jsonArray对象转换为java集合对象 
	 * 
	 * @param <T> *
	 * @param clazz *
	 * @param jsons *
	 * @return
	 */
	@SuppressWarnings("all")
	public
	static <T> List<T> getJavaCollection(T clazz, List list) {
		List<T> objs = null;
		//JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(jsons);
		JSONArray jsonArray = JSONArray.fromObject(list);  
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd HH:mm:ss"}) );
		if (jsonArray != null) {
			objs = new ArrayList<T>();
			List resutl = (List) JSONSerializer.toJava(jsonArray);
			for (Object o : resutl) {
				JSONObject jsonObject = JSONObject.fromObject(o);
				T obj = null;
			    obj = (T) JSONObject.toBean(jsonObject, clazz.getClass());
				objs.add(obj);
			}
		}
		return objs;
	}
 }
