<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>
<%@ include file="/decorators/include/styles.jspf"%>
<%@ include file="/decorators/include/javascripts.jspf"%>
<app:pageHeading pageHeadingKey="culturalInformationList.heading" />
<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="create" inputType="button" onclick="return fnDoAdd(this);" />
	<!--<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoMultiSave(this);" />-->
	<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoMultiDelete(this);" />
	<!--<cartmatic:cartmaticBtn btnType="cancel" inputType="button" onclick="return fnDoUpToParent(this);" />-->
</content>
<app:ui_leftMenu>
	<div class="sidebar-left">
	    <form method="post" action="${ctxPath}/culturalinformation/culturalInformation.html">
			<app:ui_tabs tabsId="left_menu_tabs"/>
		    <div class="tab" id="left_menu_tabs">
			    <ul>
					<li><a href="#listSelectContent"><fmt:message key="yourposition.search"/></a></li>
				</ul>
				<div class="content" id="listSelectContent">
					<search:searchBox>
						<search:input attrPath="s.title" attrNameKey="culturalInformation.title" datatype="String"
							operator="LIKE" classes="form-inputbox" />
						<search:input attrPath="s.writer" attrNameKey="culturalInformation.writer" datatype="String"
							operator="LIKE" classes="form-inputbox" />
						<search:input attrPath="s.releaseTime" attrNameKey="culturalInformation.releaseTime" datatype="String"
							operator="LIKE" classes="form-inputbox" />
							
				<div class="title">类型</div>
					<div>
						<select name="COL@s.type@Integer@EQ" id="type" style="width:150px" >
							<option value="">所有</option>
							<option value="0" <c:if test="${param['COL@s.type@Integer@EQ'] ==0}">selected="selected" </c:if>>时尚前沿</option>
							<option value="1" <c:if test="${param['COL@s.type@Integer@EQ'] ==1}">selected="selected" </c:if>>思维对话
</option>
							<option value="2" <c:if test="${param['COL@s.type@Integer@EQ'] ==2}">selected="selected" </c:if>>品牌播报</option>
							<option value="3" <c:if test="${param['COL@s.type@Integer@EQ'] ==3}">selected="selected" </c:if>>聚焦四方</option>
							<option value="4" <c:if test="${param['COL@s.type@Integer@EQ'] ==4}">selected="selected" </c:if>>四方志</option>
						</select>
					</div>
						<!-- （0：发布）（1：取消） -->
				<div class="title">发布状态</div>
					<div>
						<select name="COL@s.state@Integer@EQ" id="state" style="width:150px" >
							<option value="">所有</option>
							<option value="0" <c:if test="${param['COL@s.state@Integer@EQ'] ==0}">selected="selected" </c:if>>正常</option>
							<option value="1" <c:if test="${param['COL@s.state@Integer@EQ'] ==1}">selected="selected" </c:if>>取消</option>
						</select>
					</div>
				<div class="title">发布时间</div>
					<div>
						从
						<input name="COL@s.releaseTime@Date_Begin@GTE" id="releaseTimeGTE" type="text" readonly="true" value=""/>
						<app:ui_datePicker outPut="releaseTimeGTE" />
						<br/>
						到
						<input name="COL@s.releaseTime@Date_End@LTE" id="releaseTimeLTE" type="text" readonly="true" value=""/>
						<app:ui_datePicker outPut="releaseTimeLTE" />
				</div>	
					</search:searchBox>
			  </div>
			</div>
		</form>
	</div>
</app:ui_leftMenu>
<form class="mainForm" name="culturalInformationListForm" method="post" action="${ctxPath}/culturalinformation/culturalInformation.html">
	<!--listing box start-->
	<!--editURLPath is used in TblDecorator-->
	<c:set var="editURLPath" value="/culturalinformation/culturalInformation.html?doAction=edit&from=list" scope="page" />
		<c:set var="checkAll"><input type="checkbox" name="allbox" onclick="checkAll(this.form)" class="checkbox"/></c:set>
		
		<display:table name="${culturalInformationList}" cellspacing="0" cellpadding="0" uid="culturalInformationItem"
			class="table-list" export="false" requestURI="">
			
			<display:column style="width: 3%" title="${checkAll}" media="html">
				<input type="checkbox" name="multiIds" value="${culturalInformationItem.culturalInformationId}" class="checkbox" title="${culturalInformationItem.culturalInformationName}"/>
			</display:column>
			
			
			<display:column sortable="false" url="${editURLPath}" paramId="culturalInformationId" paramProperty="culturalInformationId" title="图片"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="culturalInformation.culturalInformationName">
				<cartmatic:img isUrlOnly="false" url="${culturalInformationItem.logoImg}" mediaType="other" id="logoImage" height="100" width="100"></cartmatic:img>
			</display:column>
			
			<display:column sortable="false" url="${editURLPath}" paramId="culturalInformationId" paramProperty="culturalInformationId" title="标题"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="culturalInformation.culturalInformationName">
				${culturalInformationItem.culturalInformationName}
			</display:column>
        		
        	<display:column property="writer" sortable="false" headerClass="data-table-title"  title="作者"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="culturalInformation.writer"/><%--
        		
		    <display:column property="commentNumber" sortable="true" headerClass="data-table-title"  title="评论数"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="culturalInformation.commentNumber"/>
        		
		    --%><display:column property="readNumber" sortable="true" headerClass="data-table-title"  title="阅读数"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="culturalInformation.readNumber"/>
        		
		    <display:column property="releaseTime" sortable="true" headerClass="data-table-title"  title="发布时间"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="culturalInformation.releaseTime"/>
        		
		  	<display:column sortable="false" title="类型"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="culturalInformation.type">
				<c:choose >
				  <c:when test="${culturalInformationItem.type==0}">时尚前沿</c:when>
				  <c:when test="${culturalInformationItem.type==1}">思维对话</c:when>
				  <c:when test="${culturalInformationItem.type==2}">品牌播报</c:when>
				  <c:when test="${culturalInformationItem.type==3}">聚焦四方</c:when>
				  <c:when test="${culturalInformationItem.type==4}">四方志</c:when>
				  <c:otherwise>   
   					 ${param.username} is employee.  
  				</c:otherwise> 
				</c:choose>
			</display:column>
									
			<display:column property="metaKeywork" sortable="true" headerClass="data-table-title"  title="搜索关键词"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="culturalInformation.metaKeywork"/><%--
        		
		    <display:column property="sortOrder" sortable="true" headerClass="data-table-title"  title="排序(越大越前)"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="culturalInformation.sortOrder"/>
        		
		 	 --%><display:column sortable="true" title="发布状态"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="culturalInformation.state">
				<c:choose >
				  <c:when test="${culturalInformationItem.state==0}">正常</c:when>
				  <c:when test="${culturalInformationItem.state==1}">取消</c:when>
				</c:choose>
			</display:column>
			
		</display:table>
		<%@include file="/common/pagingOnlyNew.jsp"%>
</form>
<script type="text/javascript">
highlightTableRows("culturalInformationItem");
</script>