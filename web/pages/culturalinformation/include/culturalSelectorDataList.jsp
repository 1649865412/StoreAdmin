<%@ include file="/common/taglibs.jsp"%>
<!-- ========== 列表内容开始 ========= -->
<display:table name="${supplierList}" cellspacing="0" cellpadding="0" uid="supplierItem" class="table-list" export="false" requestURI="">
	<c:if test="${param.multiSelect}">
	<display:column style="width: 1%"  media="html">
		<input type="checkbox" name="multiIds" id="sel_ch_${param.id}_${supplierItem.culturalInformationId}" value="${supplierItem.culturalInformationId}" class="checkbox" title="${supplierItem.title}" onclick="fuSelectSupplier${param.id}(${supplierItem.culturalInformationId},this)"/>
	</display:column>
	</c:if>                                       
	<display:column sortable="false" decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" title="标题">
		<a href="javascript:void%200" ondblclick='fuSelectSupplier${param.id}(${supplierItem.culturalInformationId})'>${supplierItem.title}</a>
	</display:column>
	
	<display:column sortable="false" decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" title="作者">
		${supplierItem.writer}
	</display:column>
	
		<display:column sortable="false" title="类型"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" >
				<c:choose >
				  <c:when test="${supplierItem.type==0}">时尚前沿</c:when>
				  <c:when test="${supplierItem.type==1}">思维对话</c:when>
				  <c:when test="${supplierItem.type==2}">品牌播报</c:when>
				  <c:when test="${supplierItem.type==3}">聚焦四方</c:when>
				  <c:when test="${supplierItem.type==4}">四方志</c:when>
				  <c:otherwise>   
   					 ${param.username} is employee.  
  				</c:otherwise> 
				</c:choose>
			</display:column>
	
	 <display:column sortable="true" title="发布状态"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" >
				<c:choose >
				  <c:when test="${supplierItem.state==0}">正常</c:when>
				  <c:when test="${supplierItem.state==1}">取消</c:when>
				</c:choose>
			</display:column>
</display:table>

<input type="hidden" name="multiSelect" value="${param.multiSelect}">
<input type="hidden" name="id" value="${param.id}">

<div style="display:none">
	<c:forEach items="${supplierList}" var="supplierItem">
	<span id="jsonDataList_${param.id}_${supplierItem.culturalInformationId}">${supplierItem.jsonObject}</span>
	</c:forEach>
</div>
<!-- ========== 列表内容结束 ========= -->
<div class="blank10"></div>
<c:if test="${not empty supplierList}">
	<!-- ========== 分页开始 ========= -->
	<div class="box-paging">
		<%@include file="/common/pagingOnlyNew.jsp"%>
	</div>
	<!-- ========== 分页结束 ========= -->
</c:if>