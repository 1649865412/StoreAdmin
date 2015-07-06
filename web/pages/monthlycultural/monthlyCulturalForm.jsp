<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<app:pageHeading entityName="${monthlyCultural.monthlyCulturalName}" entityHeadingKey="monthlyCulturalDetail.heading" />
<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoSave(this);" />
	<%--
	<cartmatic:cartmaticBtn btnType="saveAndNext" onclick="return fnDoSaveAndNext(this);" />
	--%>
    <c:if test="${monthlyCultural.monthlyCulturalId!=null}">
		<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoDelete(this);" />
	</c:if>
	<cartmatic:cartmaticBtn btnType="cancel" onclick="return fnDoCancelForm(this);" />
</content>
<app:showBindErrors bindPath="monthlyCultural.*" />
	<form:form method="post" cssClass="mainForm" id="monthlyCultural" commandName="monthlyCultural"
			action="${ctxPath}/monthlycultural/monthlyCultural.html" onsubmit="return validateMonthlyCultural(this);">
		<input type="hidden" name="monthlyCulturalId" value="${monthlyCultural.monthlyCulturalId}"/> 
		<table class="table-content" cellSpacing="0" cellPadding="0" width="100%" border="0">
		<app:input property="img" />
 		<app:formText label="common.message.createTime" value="${monthlyCultural.createTime}" />
  		<app:input property="culturalInformationId" />
  	</table>
</form:form>

<v:javascript formName="monthlyCultural" staticJavascript="false" />
<script type="text/javascript">
    document.forms["monthlyCultural"].elements["img"].focus();
</script>
