<%@ include file="/common/taglibs.jsp"%>
<app:pageHeading pageHeadingKey="monthlyCulturalList.heading" />

<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="create" inputType="button" onclick="return fnDoAdd(this);" />
	<!--<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoMultiSave(this);" />-->
	<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoMultiDelete(this);" />
	<cartmatic:cartmaticBtn btnType="cancel" inputType="button" onclick="return fnDoUpToParent(this);" />
</content>
<app:ui_leftMenu>
	<div class="sidebar-left">
	    <form method="post" action="${ctxPath}/monthlycultural/monthlyCultural.html">
			<app:ui_tabs tabsId="left_menu_tabs"/>
		    <div class="tab" id="left_menu_tabs">
			    <ul>
					<li><a href="#listSelectContent"><fmt:message key="yourposition.search"/></a></li>
				</ul>
				<div class="content" id="listSelectContent">
					<search:searchBox>
						<search:filter />
						<search:input attrPath="s.monthlyCulturalName" attrNameKey="monthlyCultural.monthlyCulturalName" datatype="String"
							operator="LIKE" classes="form-inputbox" />
						<search:orderby showOrderDirection="true">
							<option value="monthlyCulturalId">
								<fmt:message key="search.order.by.default" />
							</option>
						</search:orderby>
					</search:searchBox>
				</div>
			</div>
		</form>
	</div>
</app:ui_leftMenu>
<form class="mainForm" name="monthlyCulturalListForm" method="post" action="${ctxPath}/monthlycultural/monthlyCultural.html">
	<!--listing box start-->
	<!--editURLPath is used in TblDecorator-->
	<c:set var="editURLPath" value="/monthlycultural/monthlyCultural.html?doAction=edit&from=list" scope="page" />
		<c:set var="checkAll"><input type="checkbox" name="allbox" onclick="checkAll(this.form)" class="checkbox"/></c:set>
		<display:table name="${monthlyCulturalList}" cellspacing="0" cellpadding="0" uid="monthlyCulturalItem"
			class="table-list" export="false" requestURI="">
			<display:column style="width: 3%" title="${checkAll}" media="html">
				<input type="checkbox" name="multiIds" value="${monthlyCulturalItem.monthlyCulturalId}" class="checkbox" title="${monthlyCulturalItem.monthlyCulturalName}"/>
			</display:column>
			<display:column sortable="false" url="${editURLPath}" paramId="monthlyCulturalId" paramProperty="monthlyCulturalId"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="monthlyCultural.monthlyCulturalName">
				${monthlyCulturalItem.monthlyCulturalName}
			</display:column>
		    <display:column property="img" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="monthlyCultural.img"/>
		    <display:column property="createTime" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="monthlyCultural.createTime"/>
		    <display:column property="culturalInformationId" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="monthlyCultural.culturalInformationId"/>
		</display:table>
		<%@include file="/common/pagingOnlyNew.jsp"%>
</form>
<script type="text/javascript">
highlightTableRows("monthlyCulturalItem");
</script>