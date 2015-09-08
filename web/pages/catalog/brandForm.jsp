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
				设计师首字母(只限大写字母查询)：
			</td>
			<br>
			<td>
				<input class="Field400" type="text" name="initials" id="initials" value="${brand.initials}" />
			</td>
	   </tr>
	     <tr>
			<td class="FieldLabel">
				设计师语录：
			</td>
			<td>
				<input class="Field400" type="text" name="quotation" id="quotation" value="${brand.quotation}" />
			</td>
	   </tr>
	 <tr>
			<td class="FieldLabel">
				访谈资讯:
			</td>
			<td>
			    <input id="b1" type="button" class="admin-btn" value="访谈资讯" onclick="multiSupplierSelector_show('kkk_DIV')"/>
			    <input id="b2" type="button" class="admin-btn" value="清空" onclick="Reset(1)"/>
	            <cultural:culturalSelector multiSelect= "false" title="访谈资讯选择"   id="multiSupplierSelector"  autoClose="true" ondblclick="fnTestSelectMultiCulSku"  ></cultural:culturalSelector>
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
				<span>推荐产品选择(支持多选，前台只展示前八个)： </span>
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
					isMultiFiles="true" button_text="上传动态资讯(图片尺寸：422*422)" fileImageSize="v"
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
											<br>
										内容：
										${productMoreImage.content}
										<br>
										来源：
										${productMoreImage.resource}
										<br>
										网址：
										${productMoreImage.website}
										<br>
										来源时间：
										${productMoreImage.resourceTime}
										<br>
										来源着色标志：
										<c:if test="${productMoreImage.colorType==0}">默认黑色</c:if>
										<c:if test="${productMoreImage.colorType==1}">红色（新浪微博）</c:if>
										<c:if test="${productMoreImage.colorType==2}">浅蓝（Twitter）</c:if>
										<c:if test="${productMoreImage.colorType==3}">棕色（Instagram）</c:if>
										<c:if test="${productMoreImage.colorType==4}">宝蓝（Facebook）</c:if>
										<c:if test="${productMoreImage.colorType==5}">灰蓝色（Lofter）</c:if>
										<c:if test="${productMoreImage.colorType==6}">浅绿色（微信）</c:if>
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
					(建议尺寸：425*425)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('logoImage').src='${ctxPath}/images/default/00.jpg';$j('#logo').val('');" />
				</div>
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
					(建议尺寸：425*425)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('iconImage').src='${ctxPath}/images/default/00.jpg';$j('#icon').val('');" />
				</div>
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				滚动图第一張
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${brand.pic2}" mediaType="other" id="pic2Image" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="pic2ImageBtnPlaceHolderId"></span>
					<input type="hidden" id="pic2" name="pic2" value="${brand.pic2}" />
					<br/>
					(建议尺寸：1420*385)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('pic2Image').src='${ctxPath}/images/default/00.jpg';$j('#pic2').val('');" />
				</div>
			</td>
	    </tr> 
	       <tr>
			<td class="FieldLabel">
				滚动图第二張
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${brand.pic3}" mediaType="other" id="pic3Image" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="pic3ImageBtnPlaceHolderId"></span>
					<input type="hidden" id="pic3" name="pic3" value="${brand.pic3}" />
					<br/>
					(建议尺寸：1420*385)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('pic3Image').src='${ctxPath}/images/default/00.jpg';$j('#pic3').val('');" />
				</div>
			</td>
	    </tr> 
	       <tr>
			<td class="FieldLabel">
				滚动图第三張
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${brand.pic4}" mediaType="other" id="pic4Image" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="pic4ImageBtnPlaceHolderId"></span>
					<input type="hidden" id="pic4" name="pic4" value="${brand.pic4}" />
					<br/>
					(建议尺寸：1420*385)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('pic4Image').src='${ctxPath}/images/default/00.jpg';$j('#pic4').val('');" />
				</div>
			</td>
	    </tr> 
	       <tr>
			<td class="FieldLabel">
				滚动图第四張
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${brand.pic5}" mediaType="other" id="pic5Image" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="pic5ImageBtnPlaceHolderId"></span>
					<input type="hidden" id="pic5" name="pic5" value="${brand.pic5}" />
					<br/>
					(建议尺寸：1420*385)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('pic5Image').src='${ctxPath}/images/default/00.jpg';$j('#pic5').val('');" />
				</div>
			</td>
	    </tr> 
	       <tr>
			<td class="FieldLabel">
				滚动图第五張
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${brand.pic6}" mediaType="other" id="pic6Image" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="pic6ImageBtnPlaceHolderId"></span>
					<input type="hidden" id="pic6" name="pic6" value="${brand.pic6}" />
					<br/>
					(建议尺寸：1420*385)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('pic6Image').src='${ctxPath}/images/default/00.jpg';$j('#pic6').val('');" />
				</div>
			</td>
	    </tr> 
	        <tr>
			<td class="FieldLabel">
				页面设计师访谈补充图:
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${brand.pic}" mediaType="other" id="picImage" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="picImageBtnPlaceHolderId"></span>
					<input type="hidden" id="pic" name="pic" value="${brand.pic}" />
					<br/>
					(建议尺寸：1420*385)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('picImage').src='${ctxPath}/images/default/00.jpg';$j('#pic').val('');" />
				</div>
			</td>
	    </tr>
	</table>
</form>

<cartmatic:swf_upload btnPlaceHolderId="iconImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif" fileInputId="icon" previewImg="iconImage" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="logoImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif" fileInputId="logo" previewImg="logoImage" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="picImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif" fileInputId="pic" previewImg="picImage" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="pic2ImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif" fileInputId="pic2" previewImg="pic2Image" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="pic3ImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif" fileInputId="pic3" previewImg="pic3Image" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="pic4ImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif" fileInputId="pic4" previewImg="pic4Image" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="pic5ImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif" fileInputId="pic5" previewImg="pic5Image" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="pic6ImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif" fileInputId="pic6" previewImg="pic6Image" ></cartmatic:swf_upload>
	
	
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
function fnTestSelectMultiCulSku( productSku) {
	var arrayproductId ="";
	var arrayproductName = "";
	arrayproductId = productSku.culturalInformationId;
	arrayproductName = productSku.title;
	senData(arrayproductId, arrayproductName,1);
}

//选择器值函数回调（产品）
function fnTestSelectMultiProductSku(productSkuList) {
//	alert("选择器值函数回调（产品）")
	var data = "";
	var arrayproductId = new Array();
	var arrayproductName = new Array();
//	alert("productSkuList:"+productSkuList);
	for ( var i = 0; i < productSkuList.length; i++) {
		var productSku = productSkuList[i];
		arrayproductId[i] = productSku.product.productId;
		arrayproductName[i] = productSku.product.productName;
	}
	senData(arrayproductId.join(), arrayproductName.join(),2);
}
</script>

