<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cultural" tagdir="/WEB-INF/tags/cultural"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/catalog"%>
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
				设计师首字母(前端首字母排序查询,只限大写字母查询)：
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
			    <input id="b2" type="button" class="admin-btn" value="清空" onclick="Reset(1)"/>
	            <cultural:culturalSelector title="访谈资讯选择"   id="multiSupplierSelector"  autoClose="true" ondblclick="fnTestSelectMultiCulSku"  multiSelect="true"></cultural:culturalSelector>
	                                      新已选访谈资讯： <span id="arrayculName"></span>
	            <br>
			          原来已选访谈资讯：
				<span id="arrayculNameOld"> <c:forEach
						items="${reCulturalInformationList}" var="reCulturalInformation">
                      	${reCulturalInformation.title},
				    </c:forEach> </span>
	            <input type="hidden" id="arrayculId" name="culturalRecommendId"
					value="${brand.culturalRecommendId}" />
			</td>
	    </tr>
	  <tr>
			<td class="FieldLabel">
				<span>推荐产品选择(支持多选，前台只展示前六个)： </span>
			</td>
			<td>
					<input type="button" value="产品推荐" id="b5" />
					<input id="b2" type="button" class="admin-btn" value="清空" onclick="Reset(2)"/>
					<product:productSkuSelector id="multiSelect_productSkuSelector"
						showSelectorBtnId="b5" title="产品选择"
						ondblclick="fnTestSelectMultiProductSku" showProductKinds="1,2"
						multiSelect="true"></product:productSkuSelector>
					   新已选推荐产品：<span id="arrayproductName"></span>
					   <br>
					    原来已选推荐产品：
				<span id="arrayproductNameOld"> <c:forEach
						items="${reProductList}" var="reproduct">
                      	${reproduct.productName},
				    </c:forEach> </span>
				<input type="hidden" id="arrayproductId" name="productRecommendId"
					value="${brand.productRecommendId}" />
			</td>
		</tr>
		
		<tr id="monthdiv">
			<td class="FieldLabel">
				<span id="productMediaImageBtnPlaceHolderId_d">按钮（<a href="#" onclick=removeAllProductImg('productMoreImages_d');>移除所有产品大图</a>）</span>
				<!-- 上传大图 -->
				<cartmatic:swf_upload
					btnPlaceHolderId="productMediaImageBtnPlaceHolderId_d"
					uploadCategory="productMedia"
					uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif"
					onComplete="fnUploadMoreImage_d_Handler" objId="1110" previewSize="v"
					isMultiFiles="true" button_text="上传动态资讯" fileImageSize="v"
					fileSizeLimit="5MB"></cartmatic:swf_upload>
				<script type="text/javascript"
					src="<c:url value="/scripts/cartmatic/catelog/brandlForm.js"/>"></script>
			</td>
			<td id="addImg">
				<div id="productMoreImages_d">
			<c:forEach items="${brandDynamicList}"
						var="productMoreImage">
						<div class="product-media"
							id="productMedia_div_
								${productMoreImage.brandDynamicId}">
							<table width="100%" border="0" cellspacing="0" cellpadding="0"
								align="center" class="no-border">
								<tr>
									<td class="list" width="10%" align="left">
										<cartmatic:img url="${productMoreImage.img}"
											mediaType="productMedia" size="v" width="60" height="60"
											id="productMedia_img_${productMoreImage.brandDynamicId}"></cartmatic:img>
										内容：
										<input id=" " readonly="readonly"  name="" type="text"  style="width:400px;" value="${productMoreImage.content}"/>
										来源：
										<input id=" " readonly="readonly"  name="" type="text" style="width:400px;" value="${productMoreImage.resource}"/>
										网址：
										<input id=" " readonly="readonly"  name="" type="text" style="width:400px;" value="${productMoreImage.website}"/>
										来源时间：
										<input id=" " readonly="readonly"  name="" type="text" style="width:400px;" value="${productMoreImage.resourceTime}"/>
									</td>
									<td class="list">
										&nbsp;&nbsp;
										<input name="remove_empty_item" type="image"
											src="${ctxPath}/images/icon/icon_del.gif"
											onclick="fnRemoveUploadMedia(${productMoreImage.brandDynamicId},this);return false;"
											title="<fmt:message key="productDetail.moreImage.removeThisImage" />" />
									</td>
								</tr>
							</table>
						</div>
					</c:forEach>
				</div>
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
	  <!--    才版旧的页面
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
	    </tr> -->
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
//type=1是获取访谈的，type=2是获取推荐产品的

//选择器表单值重置
function Reset(type){
   if(type==1){
	    $j("#arrayculId").val("");
		$j("#arrayculName").html("");
	   }	
   else if(type==2){
	    $j("#arrayproductId").val("");
		$j("#arrayproductName").html("");
	   }
}


//选择器值设置表单准备提交
function senData(arrayproductId, arrayproductName,type) {
	//alert("senData:"+type+":"+arrayproductId+":"+arrayproductName);
	Reset(type);
	if(type==1){
		 arrayproductIdvalue=$j("#arrayculId").val();
		 arrayproductNamevalue=$j("#arrayculName").html();
		}
	else if(type==2){
		 arrayproductIdvalue=$j("#arrayproductId").val();
		 arrayproductNamevalue=$j("#arrayproductName").html();
		}
	
	/* if(arrayproductIdvalue=="")
		 {
		 arrayproductIdvalue="";
		 }else{
			 arrayproductIdvalue+=",";
			 }
	 if(arrayproductNamevalue=="")
		 {
		 arrayproductNamevalue="";
		 }else{
			 arrayproductNamevalue+=",";
			 }*/
	 if(type==1){
		 $j("#arrayculId").val(arrayproductIdvalue+arrayproductId);
			$j("#arrayculName").html(arrayproductNamevalue+arrayproductName);
		}
	else if(type==2){
		$j("#arrayproductId").val(arrayproductIdvalue+arrayproductId);
		$j("#arrayproductName").html(arrayproductNamevalue+arrayproductName);
		}
}

//选择器值函数回调（文化）
function fnTestSelectMultiCulSku(productSkuList) {
	//alert("fnTestSelectMultiProductSku")
	var data = "";
	var arrayproductId = new Array();
	var arrayproductName = new Array();
	for ( var i = 0; i < productSkuList.length; i++) {
		var productSku = productSkuList[i];
		arrayproductId[i] = productSku.culturalInformationId;
		arrayproductName[i] = productSku.title;
	}
	senData(arrayproductId.join(), arrayproductName.join(),1);
}

//选择器值函数回调（产品）
function fnTestSelectMultiProductSku(productSkuList) {
//	alert("选择器值函数回调（产品）")
	var data = "";
	var arrayproductId = new Array();
	var arrayproductName = new Array();
	//alert("productSkuList:"+productSkuList);
	for ( var i = 0; i < productSkuList.length; i++) {
		var productSku = productSkuList[i];
		arrayproductId[i] = productSku.product.productId;
		arrayproductName[i] = productSku.product.productName;
	}
	senData(arrayproductId.join(), arrayproductName.join(),2);
}
</script>
