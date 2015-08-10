<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<app:pageHeading entityName="${productTalenshow.productTalenshowName}" entityHeadingKey="productTalenshowDetail.heading" />
<content tag="buttons">
	<cartmatic:cartmaticBtn btnType="save" onclick="return fnDoSave(this);" />
	<%--
	<cartmatic:cartmaticBtn btnType="saveAndNext" onclick="return fnDoSaveAndNext(this);" />
	--%>
    <c:if test="${productTalenshow.productTalenShowId!=null}">
		<cartmatic:cartmaticBtn btnType="delete" onclick="return fnDoDelete(this);" />
	</c:if>
	<cartmatic:cartmaticBtn btnType="cancel" onclick="return fnDoCancelForm(this);" />
</content>
<app:showBindErrors bindPath="productTalenshow.*" />
	<form:form method="post" cssClass="mainForm" id="productTalenshow" commandName="productTalenshow"
			action="${ctxPath}/producttalenshow/productTalenshow.html" onsubmit="return validateProductTalenshow(this);">
		<input type="hidden" name="productTalenShowId" value="${productTalenshow.productTalenShowId}"/> 
		<table class="table-content" cellSpacing="0" cellPadding="0" width="100%" border="0">
		<app:input property="productId" />
 		<app:input property="talenShowId" />
 		<app:input property="sorted" />
  	</table>
</form:form>

<v:javascript formName="productTalenshow" staticJavascript="false" />
<script type="text/javascript">
    document.forms["productTalenshow"].elements["productId"].focus();
</script>
