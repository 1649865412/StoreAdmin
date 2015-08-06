<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<app:pageHeading entityName="${talentShow.talentShowName}" entityHeadingKey="talentShowDetail.heading" />
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
		<app:input property="creatTime" />
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
		</tr>
		
 		<tr>
			<td class="FieldLabel">
				上传图片:
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

<v:javascript formName="talentShow" staticJavascript="false" />
<script type="text/javascript">
    document.forms["talentShow"].elements["creatTime"].focus();
</script>
