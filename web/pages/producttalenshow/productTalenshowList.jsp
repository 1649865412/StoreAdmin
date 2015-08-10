<%@ include file="/common/taglibs.jsp"%>
<app:pageHeading pageHeadingKey="productTalenshowList.heading" />

<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="create" inputType="button" onclick="return fnDoAdd(this);" />
	<!--<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoMultiSave(this);" />-->
	<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoMultiDelete(this);" />
	<cartmatic:cartmaticBtn btnType="cancel" inputType="button" onclick="return fnDoUpToParent(this);" />
</content>
<app:ui_leftMenu>
	<div class="sidebar-left">
	    <form method="post" action="${ctxPath}/producttalenshow/productTalenshow.html">
			<app:ui_tabs tabsId="left_menu_tabs"/>
		    <div class="tab" id="left_menu_tabs">
			    <ul>
					<li><a href="#listSelectContent"><fmt:message key="yourposition.search"/></a></li>
				</ul>
				<div class="content" id="listSelectContent">
					<search:searchBox>
						<search:filter />
						<search:input attrPath="s.productTalenshowName" attrNameKey="productTalenshow.productTalenshowName" datatype="String"
							operator="LIKE" classes="form-inputbox" />
						<search:orderby showOrderDirection="true">
							<option value="productTalenshowId">
								<fmt:message key="search.order.by.default" />
							</option>
						</search:orderby>
					</search:searchBox>
				</div>
			</div>
		</form>
	</div>
</app:ui_leftMenu>
<form class="mainForm" name="productTalenshowListForm" method="post" action="${ctxPath}/producttalenshow/productTalenshow.html">
	<!--listing box start-->
	<!--editURLPath is used in TblDecorator-->
	<c:set var="editURLPath" value="/producttalenshow/productTalenshow.html?doAction=edit&from=list" scope="page" />
		<c:set var="checkAll"><input type="checkbox" name="allbox" onclick="checkAll(this.form)" class="checkbox"/></c:set>
		<display:table name="${productTalenshowList}" cellspacing="0" cellpadding="0" uid="productTalenshowItem"
			class="table-list" export="false" requestURI="">
			<display:column style="width: 3%" title="${checkAll}" media="html">
				<input type="checkbox" name="multiIds" value="${productTalenshowItem.productTalenshowId}" class="checkbox" title="${productTalenshowItem.productTalenshowName}"/>
			</display:column>
			<display:column sortable="false" url="${editURLPath}" paramId="productTalenshowId" paramProperty="productTalenShowId"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="productTalenshow.productTalenshowName">
				${productTalenshowItem.productTalenshowName}
			</display:column>
		    <display:column property="productId" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="productTalenshow.productId"/>
		    <display:column property="talenShowId" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="productTalenshow.talenShowId"/>
		    <display:column property="sorted" sortable="false" headerClass="data-table-title"
        		decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="productTalenshow.sorted"/>
		</display:table>
		<%@include file="/common/pagingOnlyNew.jsp"%>
</form>
<script type="text/javascript">
highlightTableRows("productTalenshowItem");
</script>