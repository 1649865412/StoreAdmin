<%@ include file="/common/taglibs.jsp"%>
<app:pageHeading pageHeadingKey="viaList.heading" />

<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="create" inputType="button" onclick="return fnDoAdd(this);" />
	<!--<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoMultiSave(this);" />-->
	<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoMultiDelete(this);" />
</content>
<app:ui_leftMenu>
	<div class="sidebar-left">
	    <form method="post" action="${ctxPath}/viashow/via.html">
			<app:ui_tabs tabsId="left_menu_tabs"/>
		    <div class="tab" id="left_menu_tabs">
			    <ul>
					<li><a href="#listSelectContent"><fmt:message key="yourposition.search"/></a></li>
				</ul>
				<div class="content" id="listSelectContent">
					<search:searchBox>
						<search:filter />
						<search:input attrPath="s.name" attrNameKey="via.name" datatype="String"
							operator="LIKE" classes="form-inputbox" />
							
						<search:input attrPath="s.email" attrNameKey="via.email" datatype="String"
							operator="LIKE" classes="form-inputbox" />
							
						<search:orderby showOrderDirection="true">
							<option value="viaId">
								<fmt:message key="search.order.by.default" />
							</option>
						</search:orderby>
					</search:searchBox>
				</div>
			</div>
		</form>
	</div>
</app:ui_leftMenu>
<form class="mainForm" name="viaListForm" method="post" action="${ctxPath}/viashow/via.html">
	<!--listing box start-->
	<!--editURLPath is used in TblDecorator-->
	<c:set var="editURLPath" value="/viashow/via.html?doAction=edit&from=list" scope="page" />
		<c:set var="checkAll"><input type="checkbox" name="allbox" onclick="checkAll(this.form)" class="checkbox"/></c:set>
		<display:table name="${viaList}" cellspacing="0" cellpadding="0" uid="viaItem"
			class="table-list" export="false" requestURI="">
			<display:column style="width: 3%" title="${checkAll}" media="html">
				<input type="checkbox" name="multiIds" value="${viaItem.viaId}" class="checkbox" title="${viaItem.viaName}"/>
			</display:column>
			<display:column sortable="false" url="${editURLPath}" paramId="viaId" paramProperty="viaId"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" title="姓名">
				${viaItem.viaName}
			</display:column>
		    <display:column property="email" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="via.email"/>
		    <display:column property="phone" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="via.phone"/>
		    <display:column property="company" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="via.company"/>
		    <display:column property="bark" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="via.bark"/>
		</display:table>
		<%@include file="/common/pagingOnlyNew.jsp"%>
</form>
<script type="text/javascript">
highlightTableRows("viaItem");
</script>