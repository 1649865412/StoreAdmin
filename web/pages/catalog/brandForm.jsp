<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cultural" tagdir="/WEB-INF/tags/cultural"%>

<app:pageHeading entityName="${brand.brandName}" entityHeadingKey="brandDetail.heading" />
<content tag="buttons">
<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoSave(this,'brandName');" />
<c:if test="${brand.brandId!=null}">
	<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoDelete(this,'brandName');" />
</c:if>
<cartmatic:cartmaticBtn btnType="cancel" onclick="return fnDoCancelForm(this);" />
</content>
<app:showBindErrors bindPath="brand.*" />
<form id="brand" class="mainForm" action="${ctxPath}/catalog/brand.html" method="post" onsubmit="return validateBrand(this);">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-content">
		<tr>
			<th colspan="2">
				<fmt:message key="brandDetail.heading" /><input type="hidden" name="brandId" value="${brand.brandId}" /> 
			</th>
		</tr>
		<tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="brand.brandName" />
			</td>
			<td>
				<input class="Field400" type="text" name="brandName" id="brandName" value="<c:out value="${brand.brandName}"/>" />
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="brand.designer" />
			</td>
			<td>
				<input class="Field400" type="text" name="designer" id="designer" value="<c:out value="${brand.designer}"/>" />
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="brand.brandCode" />
			</td>
			<td>
				<input class="Field400" type="text" name="brandCode" id="brandCode" value="${brand.brandCode}" />
			</td>
	    </tr>
	    
	    
	   <tr>
			<td class="FieldLabel">
				设计师首字母：
			</td>
			<td>
				<input class="Field400" type="text" name="initials" id="initials" value="${brand.initials}" />
			</td>
	   </tr>
	     
	   <tr>
			<td class="FieldLabel">
				访谈资讯(支持多选，前台只展示前一个):
			</td>
			<td>
			    <input id="b1" type="button" class="admin-btn" value="访谈资讯" onclick="multiSupplierSelector_show('kkk_DIV')"/>
			    <input id="b2" type="button" class="admin-btn" value="重置" onclick="culReset()"/>
	            <cultural:culturalSelector title="推荐资讯选择"   id="multiSupplierSelector"  autoClose="true" ondblclick="fnTestSelectMultiProductSku"  multiSelect="true"></cultural:culturalSelector>
	            <span id="arrayproductName"></span>
	            <input type="hidden" id="arrayproductId" name="recommendArrayId"
					value="" />
			</td>
	    </tr>
	    
	    
	    <tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="brand.website" />
			</td>
			<td>
				<input class="Field400" type="text" name="website" id="website" value="${brand.website}" />
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="brand.countryCode" />
			</td>
			<td>
				<input class="Field400" type="text" name="countryCode" id="countryCode" value="${brand.countryCode}" />
				<span><a href="http://en.wikipedia.org/wiki/ISO_3166-1" target="_blank">参考2位国家代码</a>，大写英文</span>
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="brand.story" />
			</td>
			<td>
				<textarea id="story" name="story" rows="4" cols="80" class="Field400">${brand.story}</textarea>
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="brand.sortOrder" />
			</td>
			<td>
				<input class="Field400" type="text" name="sortOrder" id="sortOrder" value="${empty brand.sortOrder ? 10 : brand.sortOrder}" /> 
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				设计师logo图：
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${brand.icon}" mediaType="other" id="iconImage" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="iconImageBtnPlaceHolderId"></span>
					<input type="hidden" id="icon" name="icon" value="${brand.icon}" />
					<br/>
					(<fmt:message key="brand.icon.desc" />)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('iconImage').src='${ctxPath}/images/default/00.jpg';$j('#icon').val('');" />
				</div>
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				品牌logo图
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${brand.logo}" mediaType="other" id="logoImage" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="logoImageBtnPlaceHolderId"></span>
					<input type="hidden" id="logo" name="logo" value="${brand.logo}" />
					<br/>
					(<fmt:message key="brand.logo.desc" />)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('logoImage').src='${ctxPath}/images/default/00.jpg';$j('#logo').val('');" />
				</div>
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				页面品牌故事旁边logo图
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${brand.pic}" mediaType="other" id="picImage" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="picImageBtnPlaceHolderId"></span>
					<input type="hidden" id="pic" name="pic" value="${brand.pic}" />
					<br/>
					(<fmt:message key="brand.pic.desc" />)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('picImage').src='${ctxPath}/images/default/00.jpg';$j('#pic').val('');" />
				</div>
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="brand.pic2" />
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${brand.pic2}" mediaType="other" id="pic2Image" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="pic2ImageBtnPlaceHolderId"></span>
					<input type="hidden" id="pic2" name="pic2" value="${brand.pic2}" />
					<br/>
					(<fmt:message key="brand.pic2.desc" />)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('pic2Image').src='${ctxPath}/images/default/00.jpg';$j('#pic2').val('');" />
				</div>
			</td>
	    </tr>
	</table>
</form>
<cartmatic:swf_upload btnPlaceHolderId="iconImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg" fileInputId="icon" previewImg="iconImage" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="logoImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg" fileInputId="logo" previewImg="logoImage" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="picImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg" fileInputId="pic" previewImg="picImage" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="pic2ImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg" fileInputId="pic2" previewImg="pic2Image" ></cartmatic:swf_upload>
<v:javascript formName="brand" staticJavascript="false" />
<script type="text/javascript">
    document.forms["brand"].elements["brandName"].focus();
</script>


<script type="text/javascript" defer="defer">

function culReset(){
	$j("#arrayproductId").val("");
	$j("#arrayproductName").html("");
}


function getMonthShow(){
	//alert("good");
	var type = $j("#type").val();
	//alert("type:"+type);
	if(type==4){
		  $j("#monthdiv").show();
		}else{
			//上处提交后，程序须判断是不是类型为月刊才决定是否做保存
			$j("#monthdiv").hide();
		}
}


function senData(arrayproductId, arrayproductName) {
	 arrayproductIdvalue=$j("#arrayproductId").val();
	 arrayproductNamevalue=$j("#arrayproductName").html();
	 
	 if(arrayproductIdvalue==""){
		 arrayproductIdvalue="";
		 }else{
			 arrayproductIdvalue+=",";
			 }
	 if(arrayproductNamevalue==""){
		 arrayproductNamevalue="";
		 }else{
			 arrayproductNamevalue+=",";
			 }
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
		data += "culturalInformationId:" + productSku.culturalInformationId + "\n";
		data += "title:" + productSku.title+ "\n";
		data += "writer:" + productSku.writer + "\n";
		arrayproductId[i] = productSku.culturalInformationId;
		arrayproductName[i] = productSku.title;
	}
    alert(arrayproductId.join());
	alert(arrayproductName.join());
	senData(arrayproductId.join(), arrayproductName.join());
}

</script>
