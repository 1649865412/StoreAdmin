<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<app:pageHeading entityName="${talentShow.talentShowName}" entityHeadingKey="talentShowList.heading" />
<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoSave(this);" />
	<%--
	<cartmatic:cartmaticBtn btnType="saveAndNext" onclick="return fnDoSaveAndNext(this);" />
	--%>
    <c:if test="${talentShow.talentShowId!=null}">
		<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoDelete(this);" />
	</c:if>
	<cartmatic:cartmaticBtn btnType="cancel" onclick="return fnDoCancelForm(this);" />
</content>
<app:showBindErrors bindPath="talentShow.*" />
	<form:form method="post" cssClass="mainForm" id="talentShow" commandName="talentShow"
			action="${ctxPath}/talentmanager/talentShow.html" onsubmit="return validateTalentShow(this);">
		<input type="hidden" name="talentShowId" value="${talentShow.talentShowId}"/> 
		<table class="table-content" cellSpacing="0" cellPadding="0" width="100%" border="0">
 		<app:input property="content" />
 		<app:input property="sort" />
 		<tr>
			<td class="FieldLabel">
				发布时间：
			</td>
			<td>
				<input name="releaseTime" id="releaseTime" type="text"
					readonly="true"
					value="<fmt:formatDate value="${talentShow.releaseTime}" pattern="yyyy-MM-dd" />" />
				<app:ui_datePicker outPut="releaseTime" />
			</td>
		</tr><%--
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
				新已选达人秀：
				<span id="arrayproductName"> </span>
				<br>
				原来已选达人秀：
				<span id="arrayproductNameOld"> <c:forEach
						items="${reCulturalInformationList}" var="reCulturalInformation">
                      	${reCulturalInformation.title},
				    </c:forEach> </span>
				<input type="hidden" id="arrayproductId" name="recommendArrayId"
					value="${talentShow.recommendArrayId}" />
			</td>
		</tr>
		
 		--%><tr>
			<td class="FieldLabel">
				上传图片(建议尺寸：400*650):
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${talentShow.img}"
						mediaType="other" id="logoImage" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="logoImageBtnPlaceHolderId"></span>
					<input type="hidden" id="logo" name="img"
						value="${talentShow.img}" />
					<br /><%--
					(
					<fmt:message key="brand.logo.desc" />
					)
					--%><cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片"
						onclick="$('logoImage').src='${ctxPath}/images/default/00.jpg';$j('#logo').val('');" />
				</div>
				<cartmatic:swf_upload btnPlaceHolderId="logoImageBtnPlaceHolderId"
					uploadCategory="other" uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif" fileInputId="logo"
					previewImg="logoImage"></cartmatic:swf_upload>
			</td>
		</tr>
  	</table>
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
