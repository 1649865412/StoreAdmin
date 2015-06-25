<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<app:pageHeading entityName="${culturalInformation.culturalInformationName}" entityHeadingKey="culturalInformationDetail.heading" />

<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoSave(this);" />
	<%--
	<cartmatic:cartmaticBtn btnType="saveAndNext" onclick="return fnDoSaveAndNext(this);" />
	--%>
    <c:if test="${culturalInformation.culturalInformationId!=null}">
		<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoDelete(this);" />
	</c:if>
	<cartmatic:cartmaticBtn btnType="cancel" onclick="return fnDoCancelForm(this);" />
</content>


<app:showBindErrors bindPath="culturalInformation.*" />

<form:form method="post" cssClass="mainForm" id="culturalInformation" commandName="culturalInformation"
			action="${ctxPath}/culturalinformation/culturalInformation.html" onsubmit="return validateCulturalInformation(this);">
		<input type="hidden" name="culturalInformationId" value="${culturalInformation.culturalInformationId}"/> 
		<table class="table-content" cellSpacing="0" cellPadding="0" width="100%" border="0">
		<app:input property="title" />
 		<app:input property="commentNumber" />
 		
 	<!-- 	<app:input property="releaseTime" /> -->
 		<tr>
			<td class="FieldLabel">
				发布时间：
			</td>
			<td>
			<input name="releaseTime" id="releaseTime" type="text" readonly="true" value="<fmt:formatDate value="${culturalInformation.releaseTime}" pattern="yyyy-MM-dd" />" />
				<app:ui_datePicker outPut="releaseTime" />
			</td>
		</tr>
 		<app:input property="readNumber" />
 		<app:input property="writer" />
 	<tr>
 		<td class="FieldLabel">类型</td>
 		<td><select name="type" id="type" style="width:150px" >
			<option value="0" <c:if test="${culturalInformation.type ==0}">selected="selected" </c:if>>秀场</option>
			<option value="1" <c:if test="${culturalInformation.type ==1}">selected="selected" </c:if>>访谈</option>
			<option value="2" <c:if test="${culturalInformation.type ==2}">selected="selected" </c:if>>行业动态</option>
			<option value="3" <c:if test="${culturalInformation.type ==3}">selected="selected" </c:if>>线下主题活动</option>
		</select>
		</td>
	</tr>
  	<tr>
			<td class="FieldLabel">
				LOGO:
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${culturalInformation.logoImg}" mediaType="other" id="logoImage" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="logoImageBtnPlaceHolderId"></span>
					<input type="hidden" id="logo" name="logoImg" value="${culturalInformation.logoImg}" />
					<br/>
					(<fmt:message key="brand.logo.desc" />)
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('logoImage').src='${ctxPath}/images/default/00.jpg';$j('#logo').val('');" />
				</div>
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				大图一：
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${culturalInformation.imgOne}" mediaType="other" id="picImage" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="picImageBtnPlaceHolderId"></span>
					<input type="hidden" id="pic" name="imgOne" value="${culturalInformation.imgOne}" />
					<br/>
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('picImage').src='${ctxPath}/images/default/00.jpg';$j('#pic').val('');" />
				</div>
			</td>
	    </tr>
	    <tr>
			<td class="FieldLabel">
				大图二:
			</td>
			<td>
				<div style="float: left;">
					<cartmatic:img url="${culturalInformation.imgTwo}" mediaType="other" id="pic2Image" height="100" width="100"></cartmatic:img>
				</div>
				<div style="float: left; margin: 20px;">
					<span id="pic2ImageBtnPlaceHolderId"></span>
					<input type="hidden" id="pic2" name="imgTwo" value="${culturalInformation.imgTwo}" />
					<br/>
					<cartmatic:iconBtn icon="cross" extraCss="negative" text="清空图片" onclick="$('pic2Image').src='${ctxPath}/images/default/00.jpg';$j('#pic2').val('');" />
				</div>
			</td>
	    </tr>
	    <app:input property="metaKeywork" />
 		<app:input property="brandId" />
 		<app:input property="sortOrder" />
 		<app:formText label="common.message.createTime" value="${culturalInformation.createTime}" />
 		
  	<!--	<app:input property="videoAddress" />-->
 		<app:input property="backOne" />
    <!-- 	<app:input property="backTwo" /> -->
    
      <tr>
			<td class="FieldLabel">
			</td>
			<td>
			   编辑发布文章如果有视屏，支持rm,rmv,flash,mov,swf,wmv格式
			</td>
	 </tr>
 	    <app:input property="textIntroduction" />
		<app:ui_htmlEditor textareaIds="textIntroduction"/>
  	</table>
</form:form>


<cartmatic:swf_upload btnPlaceHolderId="logoImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg" fileInputId="logo" previewImg="logoImage" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="picImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg" fileInputId="pic" previewImg="picImage" ></cartmatic:swf_upload>
<cartmatic:swf_upload btnPlaceHolderId="pic2ImageBtnPlaceHolderId" uploadCategory="other" uploadFileTypes="*.jpg" fileInputId="pic2" previewImg="pic2Image" ></cartmatic:swf_upload>


<v:javascript formName="culturalInformation" staticJavascript="false" />
<script type="text/javascript">
    document.forms["culturalInformation"].elements["title"].focus();
</script>
