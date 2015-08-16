<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<app:pageHeading entityName="${via.viaName}" entityHeadingKey="viaDetail.heading" />
<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoSave(this);" />
	<%--
	<cartmatic:cartmaticBtn btnType="saveAndNext" onclick="return fnDoSaveAndNext(this);" />
	--%>
    <c:if test="${via.viaId!=null}">
		<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoDelete(this);" />
	</c:if>
	<cartmatic:cartmaticBtn btnType="cancel" onclick="return fnDoCancelForm(this);" />
</content>
<app:showBindErrors bindPath="via.*" />
	<form:form method="post" cssClass="mainForm" id="via" commandName="via"
			action="${ctxPath}/viashow/via.html" onsubmit="return validateVia(this);">
		<input type="hidden" name="viaId" value="${via.viaId}"/> 
		<table class="table-content" cellSpacing="0" cellPadding="0" width="100%" border="0">
		<app:input property="name" />
 		<app:input property="company" />
 		<app:input property="email" />
 		<app:input property="bark" />
  	</table>
</form:form>

<v:javascript formName="via" staticJavascript="false" />
<script type="text/javascript">
    document.forms["via"].elements["name"].focus();
</script>
