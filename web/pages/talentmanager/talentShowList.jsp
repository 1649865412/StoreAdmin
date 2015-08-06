<%@ include file="/common/taglibs.jsp"%>
<app:pageHeading pageHeadingKey="talentShowList.heading" />

<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="create" inputType="button" onclick="return fnDoAdd(this);" />
	<!--<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoMultiSave(this);" />-->
	<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoMultiDelete(this);" />
</content>
<app:ui_leftMenu>
	<div class="sidebar-left">
	    <form method="post" action="${ctxPath}/talentmanager/talentShow.html">
			<app:ui_tabs tabsId="left_menu_tabs"/>
		    <div class="tab" id="left_menu_tabs">
			    <ul>
					<li><a href="#listSelectContent"><fmt:message key="yourposition.search"/></a></li>
				</ul>
				<div class="content" id="listSelectContent">
					<search:searchBox>
						<search:filter />
						<search:input attrPath="s.talentShowName" attrNameKey="talentShow.talentShowName" datatype="String"
							operator="LIKE" classes="form-inputbox" />
						<search:orderby showOrderDirection="true">
							<option value="talentShowId">
								<fmt:message key="search.order.by.default" />
							</option>
						</search:orderby>
					</search:searchBox>
				</div>
			</div>
		</form>
	</div>
</app:ui_leftMenu>
<form class="mainForm" name="talentShowListForm" method="post" action="${ctxPath}/talentmanager/talentShow.html">
	<!--listing box start-->
	<!--editURLPath is used in TblDecorator-->
	<c:set var="editURLPath" value="/talentmanager/talentShow.html?doAction=edit&from=list" scope="page" />
		<c:set var="checkAll"><input type="checkbox" name="allbox" onclick="checkAll(this.form)" class="checkbox"/></c:set>
		<display:table name="${talentShowList}" cellspacing="0" cellpadding="0" uid="talentShowItem"
			class="table-list" export="false" requestURI="">
			<display:column style="width: 3%" title="${checkAll}" media="html">
				<input type="checkbox" name="multiIds" value="${talentShowItem.talentShowId}" class="checkbox" title="${talentShowItem.talentShowName}"/>
			</display:column>
			<display:column sortable="false" url="${editURLPath}" paramId="talentShowId" paramProperty="talentShowId"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="talentShow.talentShowName">
				${talentShowItem.talentShowName}
			</display:column>
		    <display:column property="creatTime" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="talentShow.creatTime"/>
		    <display:column property="content" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="talentShow.content"/>
		    <display:column property="releaseTime" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="talentShow.releaseTime"/>
		    <display:column property="sort" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="talentShow.sort"/><%--
		    <display:column property="img" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="talentShow.img"/>
		--%></display:table>
		<%@include file="/common/pagingOnlyNew.jsp"%>
</form>
<script type="text/javascript">
highlightTableRows("talentShowItem");
</script>