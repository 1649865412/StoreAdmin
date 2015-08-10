<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>
<c:if test="${param.multiSelect}">
已选择的达人：


<span id="selectedSupplier_multiSupplierSelector">

</span>


<div><a onclick="fnRemoveAll${param.id}();">移除所有已选择</a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="fnConfirmSelectedSupplier${param.id}();">确认</a></div>
</c:if>
<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center" style="font-size: 12px;">
	<tr>
		<td valign="top" width="25%">
			<div class="content" id="supplierSelectorSearch_${param.id}">
				<div class="title">
				内容
				</div>
				<input name="COL@s.content@String@LIKE" type="text" style="width: 200px" />
				<div class="blank10"></div>
				<div class="title">发布时间</div>
				<div>
				从
				<input name="COL@s.releaseTime@Date_Begin@GTE" id="releaseTimeGTE" type="text" readonly="true" value=""/>
				<app:ui_datePicker outPut="releaseTimeGTE" />
				<br/>
				到
				<input name="COL@s.releaseTime@Date_End@LTE" id="releaseTimeLTE" type="text" readonly="true" value=""/>
				<app:ui_datePicker outPut="releaseTimeLTE" />
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