<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>
<c:if test="${param.multiSelect}">
已选择的文化资讯：


<span id="selectedSupplier_multiSupplierSelector">

</span>


<div><a onclick="fnRemoveAll${param.id}();">移除所有已选择</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="fnConfirmSelectedSupplier${param.id}();">确认</a></div>
</c:if>
<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center" style="font-size: 12px;">
	<tr>
		<td valign="top" width="25%">
			<div class="content" id="supplierSelectorSearch_${param.id}">
				<div class="title">
					标题查询
				</div>
				<input name="COL@s.title@String@LIKE" type="text" style="width: 200px" />
				<div class="blank10"></div>
				<div class="title">
					作者查询
				</div>
				<input name="COL@s.writer@String@LIKE" type="text" style="width: 200px" />
				<div class="blank10"></div>
				<div class="title">
					类型
				</div>
		<select name="COL@s.type@Integer@EQL" id="type" style="width:150px"  onchange="getMonthShow()">
		    <option value="" >所有</option>
			<option value="0" <c:if test="${param['COL@s.type@Integer@EQL'] ==0}">selected="selected" </c:if>>秀场</option>
			<option value="1" <c:if test="${param['COL@s.type@Integer@EQL']  ==1}">selected="selected" </c:if>>访谈</option>
			<option value="2" <c:if test="${param['COL@s.type@Integer@EQL']  ==2}">selected="selected" </c:if>>行业动态</option>
			<option value="3" <c:if test="${param['COL@s.type@Integer@EQL']  ==3}">selected="selected" </c:if>>线下主题活动</option>
			<option value="4" <c:if test="${param['COL@s.type@Integer@EQL']  ==4}">selected="selected" </c:if>>月刊</option>
		</select>
				<div class="blank10"></div>
				<input type="button" id="SearchButton" name="SearchButton" onclick="fn${param.id}GetData();" value="<fmt:message key="button.search"/>" class="btn-search"/>
				<div class="blank10"></div>
				需选择的请搜索后在右侧列表双击相应标题或作者！
				<input type="hidden" name="multiSelect" id="multiSelect" value="${param.multiSelect}">
				<input type="hidden" name="id" value="${param.id}">
			</div>
		</td>
		<td valign="top">
			<div id="supplierSelectorDataList_${param.id}">
				<%--@ include file="include/supplierSelectorDataList.jsp"--%>
			</div>
		</td>
	</tr>
</table>