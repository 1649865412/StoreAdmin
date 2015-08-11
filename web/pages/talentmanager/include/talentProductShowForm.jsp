<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="talentSelector" tagdir="/WEB-INF/tags/talentshow"%>


<form:form method="post" cssClass="mainForm" id="talentShow" commandName="talentShow"
			action="" onsubmit="return validateTalentShow(this);">
		<input type="hidden" name="talentShowId" value="${talentShow.talentShowId}"/> 
		<table class="table-content" cellSpacing="0" cellPadding="0" width="100%" border="0">
	<tr>
			<td class="FieldLabel">
				达人秀:
			</td>
			<td>
				<input id="b1" type="button" class="admin-btn" value="达人秀"
					onclick="multiSupplierSelector_show('kkk_DIV')" />
					
				<input id="b2" type="button" class="admin-btn" value="清空"
					onclick="culReset()" />

				<talentSelector:talentSelector title="达人秀选择"
					id="multiSupplierSelector" autoClose="true"
					ondblclick="fnTestSelectMultiProductSku" multiSelect="true"></talentSelector:talentSelector>
					<br>
				新已选达人秀：
				<span id="arrayproductName"> </span>
				<br>
				原来已选达人秀：
				<span id="arrayproductNameOld">
				<c:choose>
				<c:when test="${fn:length(productTalenshowList)<=1}">
					<c:forEach
						items="${productTalenshowList}" var="productTalenshow">
                      	${productTalenshow.talentShow.content}
				    </c:forEach>
				</c:when>
				<c:otherwise>
				    <c:forEach
						items="${productTalenshowList}" var="productTalenshow">
                      	${productTalenshow.talentShow.content},
				    </c:forEach>
				</c:otherwise>
				</c:choose>
				
</span>
				<input type="hidden" id="arrayproductId" name="recommendArrayId"
					value="" />
			</td>
		</tr>
  	</table>
  	
  	
  <display:table name="${productTalenshowList}" cellspacing="0" cellpadding="0" uid="talentShowItem"
			class="table-list" export="false" requestURI="">
			<display:column sortable="false" 
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="talentShow.talentShowName">
				${talentShowItem.talentShow.content}
			</display:column>
			<display:column sortable="false"  title="图片"
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" titleKey="talentShow.img">
				<cartmatic:img isUrlOnly="false" url="${talentShowItem.talentShow.img}" mediaType="other" id="img" height="100" width="100"></cartmatic:img>
			</display:column>
			<display:column sortable="false"  
				decorator="com.cartmatic.estore.core.decorator.TblColumnDecorator" title="操作">
				 <a href="${ctxPath}/talentmanager/talentShow.html?doAction=delete&productTalenShowId=${talentShowItem.productTalenShowId}">删除</a>
			</display:column>
	</display:table>
</form:form>



<script type="text/javascript" defer="defer">

function culReset(){
	$j("#arrayproductId").val("");
	$j("#arrayproductName").html("");
}

function senData(arrayproductId, arrayproductName) {
	 culReset();
	 arrayproductIdvalue=$j("#arrayproductId").val();
	 arrayproductNamevalue=$j("#arrayproductName").html();
	$j("#arrayproductId").val(arrayproductIdvalue+arrayproductId);
	$j("#arrayproductName").html(arrayproductNamevalue+arrayproductName);
}

function fnTestSelectMultiProductSku(productSkuList) {
	//alert("fnTestSelectMultiProductSku")
	var data = "";
	var arrayproductId = new Array();
	var arrayproductName = new Array();
	for ( var i = 0; i < productSkuList.length; i++) {
		var productSku = productSkuList[i];
		arrayproductId[i] = productSku.talentShowId;
		arrayproductName[i] = productSku.content;
	}
	senData(arrayproductId.join(), arrayproductName.join());
}
</script>


<v:javascript formName="talentShow" staticJavascript="false" />
<script type="text/javascript">
    document.forms["talentShow"].elements["creatTime"].focus();
</script>
