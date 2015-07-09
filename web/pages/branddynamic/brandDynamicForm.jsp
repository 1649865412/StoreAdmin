<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<app:pageHeading entityName="${brandDynamic.brandDynamicName}" entityHeadingKey="brandDynamicDetail.heading" />
<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoSave(this);" />
	<%--
	<cartmatic:cartmaticBtn btnType="saveAndNext" onclick="return fnDoSaveAndNext(this);" />
	--%>
    <c:if test="${brandDynamic.brandDynamicId!=null}">
		<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoDelete(this);" />
	</c:if>
	<cartmatic:cartmaticBtn btnType="cancel" onclick="return fnDoCancelForm(this);" />
</content>
<app:showBindErrors bindPath="brandDynamic.*" />
	<form:form method="post" cssClass="mainForm" id="brandDynamic" commandName="brandDynamic"
			action="${ctxPath}/branddynamic/brandDynamic.html" onsubmit="return validateBrandDynamic(this);">
		<input type="hidden" name="brandDynamicId" value="${brandDynamic.brandDynamicId}"/> 
		<table class="table-content" cellSpacing="0" cellPadding="0" width="100%" border="0">
		<app:input property="img" />
 		<app:input property="character" />
 		<app:input property="resource" />
 		<app:input property="website" />
 		<app:input property="dateTime" />
 		<app:formText label="common.message.createTime" value="${brandDynamic.createTime}" />
   	</table>
</form:form>

<v:javascript formName="brandDynamic" staticJavascript="false" />
<script type="text/javascript">
    document.forms["brandDynamic"].elements["img"].focus();
</script>
