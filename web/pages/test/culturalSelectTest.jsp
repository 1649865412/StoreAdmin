<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/catalog"%>
<%@ taglib prefix="supplier" tagdir="/WEB-INF/tags/supplier"%>
<%@ taglib prefix="cultural" tagdir="/WEB-INF/tags/cultural"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Testing page</title>
		<%@ include file="/decorators/include/styles.jspf"%>
		<%@ include file="/decorators/include/javascripts.jspf"%>
	</head>
	<body>
	<script type="text/javascript">
	function fnTestSelectSupplier(supplier){
		log(supplier);
	}
	function fnTestMultiSelectSupplier(supplierList){
		log(supplierList);
	}
</script>
	<input id="b1" type="button" class="admin-btn" value="文化资讯" onclick="multiSupplierSelector_show('kkk_DIV')"/>
	<cultural:culturalSelector id="multiSupplierSelector" ondblclick="fnTestMultiSelectSupplier" autoClose="false" multiSelect="true"></cultural:culturalSelector>
	
	<%@ include file="/decorators/include/uiResource.jspf"%>
	</body>
</html>