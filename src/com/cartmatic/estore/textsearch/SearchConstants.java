package com.cartmatic.estore.textsearch;


/**
 *  建索引操作与索引类型
 *  <code>SearchConstants.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-16 上午10:39:14	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class SearchConstants
{
	
    public static String CORE_NAME_PRODUCT = "product";
    public static String CORE_NAME_CONTENT = "content";
    public static String CORE_NAME_CULTURAL = "culturalInformation";
    public static String CORE_NAME_SALESORDER = "salesorder";
    public static String CORE_NAME_ADMIN = "admin";
    
    
    /***
     * 重建索引的类型.
     */
    public static enum UPDATE_TYPE { REBUILD_ALL, DEL, UPDATE}
}
