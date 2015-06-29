package com.cartmatic.estore.common.model.system;

import com.cartmatic.estore.common.model.system.base.AppEventTbl;


/**
 *  搜索solr每次更新索引，或者插入新的索引的时候，事件生成一个对象，记录此表
 *  <code>AppEvent.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-29 上午11:27:44	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class AppEvent extends AppEventTbl {

  	/**
	 * Default Empty Constructor for class AppEvent
	 */
	public AppEvent () {
		super();
	}
	
	/**
	 * Default Key Fields Constructor for class AppEvent
	 */
	public AppEvent (
		 Integer in_appEventId
		) {
		super (
		  in_appEventId
		);
	}

}
