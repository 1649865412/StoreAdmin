<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="content" tagdir="/WEB-INF/tags/content"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/catalog"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<app:pageHeading entityName="${advertisement.advertisementName}" entityHeadingKey="advertisementDetail.heading" />
<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="save" onclick="return fnValidationBeforeSubmit(this);" />
    <c:if test="${advertisement.advertisementId!=null}">
		<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoDelete(this,'advertisementName');" />
	</c:if>
	<cartmatic:cartmaticBtn btnType="cancel" onclick="return fnDoCancelForm(this);" />
</content>
<app:showBindErrors bindPath="advertisement.*" />
	<form:form method="post" cssClass="mainForm" id="advertisement" commandName="advertisement"
			action="${ctxPath}/content/advertisement.html" onsubmit="return validateAdvertisement(this);">
		<form:hidden path="version" />
		<input type="hidden" name="advertisementId" value="${advertisement.advertisementId}"/> 
		<table class="table-content" cellSpacing="0" cellPadding="0" width="100%" border="0">
 		<app:input property="advertisementName" />
 		<app:input property="sortOrder" />
 		<tr style="display:none">
			<td class="FieldLabel">
				<StoreAdmin:label key="advertisement.contentType" />
			</td>
			<td>
				<content:adType viewType="1" defaultValue="${advertisement.contentType}" areaName="contentType" />
			</td>
		</tr>
		<tr>
			<td class="FieldLabel">
				是否要在图片上显示文字
			</td>
			<td>
				要<input type="radio" value="1" name="showContext" <c:if test="${advertisement.showContext==1}" >checked</c:if>>
				&nbsp;&nbsp;&nbsp; 
				不要<input type="radio" value="2" name="showContext" <c:if test="${advertisement.showContext==2}" >checked</c:if>>
			</td>
		</tr>
			<tr>
			<td class="FieldLabel">
				图片上文字主标题
			</td>
			<td>
				<input type="text" value="${advertisement.contextTitle}" name="contextTitle">
			</td>
		</tr>
			<tr>
			<td class="FieldLabel">
				图片上文字副标题(非必填选项)
			</td>
			<td>
				<input type="text" value="${advertisement.contextSubTitle}" name="contextSubTitle">
			</td>
		</tr>
		<tr>
			<td class="FieldLabel">
				图片上文字内容
			</td>
			<td>
				<textarea rows="6" cols="61" name="cotext">${advertisement.cotext}</textarea>
			</td>
		</tr>
		<tr>
			<td class="FieldLabel">
				图片上文字颜色
			</td>
			<td>
				<select  name="contextBackColor" >
				   <option value="1" <c:if test="${advertisement.contextBackColor==1}" >selected</c:if>
				   >黑色</option>
				   <option value="2" <c:if test="${advertisement.contextBackColor==2}" >selected</c:if> 
				   >白色</option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="advertisement.url" />
			</td>
			<td>
				<spring:bind path="advertisement.url">
					<div style="float: left;">
						<input class="Field400" type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
					</div>
					<div style="padding-top: 2px; float: left;">
						<span id="url_btnPlaceHolderId"></span>
						<span class="fieldError"><c:out value="${status.errorMessage}" /> </span>
					</div>
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td class="FieldLabel">
				上传视屏格式（mp4）
			</td>
			<td>
				<spring:bind path="advertisement.mediaPathMpFour">
					<div style="float: left;">
						<input class="Field400" type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
					</div>
					<div style="padding-top: 2px; float: left;">
						<span id="url_btnPlaceHolderId"></span>
						<span class="fieldError"><c:out value="${status.errorMessage}" /> </span>
					</div>
				</spring:bind>
			</td>
		</tr>
		
		
		<tr>
			<td class="FieldLabel">
			       上传视屏格式（Ogv）
			</td>
			<td>
				<spring:bind path="advertisement.mediaPathOgv">
					<div style="float: left;">
						<input class="Field400" type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
					</div>
					<div style="padding-top: 2px; float: left;">
						<span id="url_btnPlaceHolderId"></span>
						<span class="fieldError"><c:out value="${status.errorMessage}" /> </span>
					</div>
				</spring:bind>
			</td>
		</tr>
		
		<tr>
			<td class="FieldLabel">
				 上传视屏格式（Webm）
			</td>
			<td>
				<spring:bind path="advertisement.mediaPathMpWebm">
					<div style="float: left;">
						<input class="Field400" type="text" name="<c:out value="${status.expression}"/>" id="<c:out value="${status.expression}"/>" value="<c:out value="${status.value}"/>" />
					</div>
					<div style="padding-top: 2px; float: left;">
						<span id="url_btnPlaceHolderId"></span>
						<span class="fieldError"><c:out value="${status.errorMessage}" /> </span>
					</div>
				</spring:bind>
			</td>
		</tr>
				
				
 		<app:input property="redirectUrl" />
		<tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="advertisement.positions" />
			</td>
			<td>
				<c:forEach var="item" items="${positions}">
					<input name="adPositionTypeId" type="radio" onclick="validateEventHandler();" value="${item.adPositionTypeId}"
					 <c:if test="${advertisement.adPositionType.adPositionTypeId==item.adPositionTypeId}"> checked</c:if> validConf="required" />
					 ${item.positionName}&nbsp;(<fmt:message key="adPositionType.store" />:${item.store.name}&nbsp;<fmt:message key="advertisement.size" />:${item.width}px*${item.height}px)<br />
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="advertisement.displayTo" />
			</td>
			<td>
				<select name="categoryIds" id="categoryIds" multiple="multiple" size="5" class="Field400">
					<c:forEach var="pAdvertisement" items="${advertisement.productAdvertisements}">
						<option value="${pAdvertisement.categoryId}" selected="true">
							${pAdvertisement.categoryPathName}
						</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<cartmatic:iconBtn icon="magnifier" id="btnAddCat" textKey="button.selectAdditionalCategory" />
				<cartmatic:iconBtn icon="cross" extraCss="negative" id="btnRemoveCat" onclick="removeAdditionalCategory('categoryIds')" textKey="button.removeAdditionalCategory" />
				<product:categorySelector id="CategorySelector" showSelectorBtnId="btnAddCat" ondblclick="fnAddCategoryHandler" canSelectRoot="false"></product:categorySelector>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="FieldLabel">
				<StoreAdmin:label key="advertisement.isincludeall" />&nbsp;&nbsp;
				<spring:bind path="advertisement.isInclude">
					<input title="<fmt:message key='advertisement.isincludeall.notice'/>" type="checkbox" id="<c:out value="${status.expression}"/>" name="<c:out value="${status.expression}"/>" <c:if test="${status.value eq 1 }">checked="checked" </c:if> value="1" />
					<span class="fieldError"><c:out value="${status.errorMessage}" /></span>
				</spring:bind>
			</td>
		</tr>
		<tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="advertisement.startPublishTime" />
			</td>
			<td>
				<spring:bind path="advertisement.startPublishTime">
					<input class="Field400" type="text" id="startPublishTime" name="startPublishTime" value="${status.value}" />
				</spring:bind>
				<app:ui_datePicker outPut="startPublishTime" />
			</td>
		</tr>
		<tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="advertisement.endPublishTime" />
			</td>
			<td>
				<spring:bind path="advertisement.endPublishTime">
					<input class="Field400" type="text" id="endPublishTime" name="endPublishTime" value="${status.value}" />
				</spring:bind>
				<app:ui_datePicker outPut="endPublishTime" />
			</td>
		</tr>
		<tr>
			<td class="FieldLabel">
				<StoreAdmin:label key="advertisement.advertisementDetail" />
			</td>
			<td>

				<spring:bind path="advertisement.advertisementDetail">
					<textarea rows="6" cols="61" name="${status.expression}" id="${status.expression}">${status.value}</textarea>
					<span class="fieldError"><c:out value="${status.errorMessage}" /> </span>
				</spring:bind>
			</td>
		</tr>
		<c:if test="${!empty advertisement.advertisementId}">
			<tr>

				<td class="FieldLabel">
					<StoreAdmin:label key="advertisement.createTime" />
				</td>
				<td>
					<spring:bind path="advertisement.createTime">
						<span><c:out value="${status.value}" /> </span>
					</spring:bind>
				</td>
			</tr>
			<tr>
				<td class="FieldLabel">
					<StoreAdmin:label key="advertisement.updateTime" />
				</td>
				<td>
					<spring:bind path="advertisement.updateTime">
						<span><c:out value="${status.value}" /> </span>
					</spring:bind>
				</td>
			</tr>
		</c:if>
  	</table>
</form:form>

	
<cartmatic:swf_upload btnPlaceHolderId="url_btnPlaceHolderId" fileInputId="url" uploadFileTypes="*.jpg;*.gif;" uploadCategory="a_and_d" button_text="上传图片"></cartmatic:swf_upload>
<cartmatic:swf_upload fileSizeLimit="10MB"  btnPlaceHolderId="url_btnPlaceHolderId" fileInputId="mediaPathMpFour" uploadFileTypes="*.mp4" uploadCategory="a_and_d" button_text="视屏(.mp4格式)"></cartmatic:swf_upload>
<cartmatic:swf_upload fileSizeLimit="10MB"  btnPlaceHolderId="url_btnPlaceHolderId" fileInputId="mediaPathOgv" uploadFileTypes="*.ogv" uploadCategory="a_and_d" button_text="视屏(.ogv格式)"></cartmatic:swf_upload>
<cartmatic:swf_upload fileSizeLimit="10MB"  btnPlaceHolderId="url_btnPlaceHolderId" fileInputId="mediaPathMpWebm" uploadFileTypes="*.webm" uploadCategory="a_and_d" button_text="视屏(.webm格式)"></cartmatic:swf_upload>


<v:javascript formName="advertisement" staticJavascript="false" />
<script type="text/javascript">
    function fnAddCategoryHandler(category){
    	var options = $("categoryIds").options;
    	var option = new Option(category.name, category.id, false, true);
    	options.add(option);
    }
   	var oldRedirectUrl=""; 
   	 var currentSize = new Array(parseInt("${advertisement.adPositionType.width}"),parseInt("${advertisement.adPositionType.height}"));
   	 
   	function fnValidationBeforeSubmit(btn){
   		if(!validateForm(document.getElementById("advertisement") )){
   			alert(__vaMsg.notPass);
   			return;
   		}
   		var valid = true;
   		var width=$j("#width").val();
   		var height=$j("#height").val();
   		if(!currentSize){
   			alert("<fmt:message key="advertisement.message.need.position"/>");
   	    	valid = false;
   	   	}
   	 	if(width==currentSize[0] && height==currentSize[1]){
   	 		valid = true;
   	 	}else{
   	 		if(confirm("<fmt:message key="advertisement.sizeNote1"/>:"+currentSize[0]+"*"+currentSize[1]+"\n"+"<fmt:message key="advertisement.sizeNote2"/>")){
   				valid = true;
   	 		}else{
   	 			width.focus();
   		 		valid = false;
   	 		}
   	 	}
   	 	$j("#categoryIds").children().attr("selected",true); 
   	 	if (valid){
   	 		fnDoSave(btn,'advertisementName');
   	   	}
   	 } 
   	function removeAdditionalCategory(elId){
   	    $j("#"+ elId +" option:selected").each( function(){$j(this).remove();} ); 	      
   	}
</script>
