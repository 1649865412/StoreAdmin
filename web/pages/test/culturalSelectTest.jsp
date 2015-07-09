<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/catalog"%>
<%@ taglib prefix="supplier" tagdir="/WEB-INF/tags/supplier"%>
<%@ taglib prefix="cultural" tagdir="/WEB-INF/tags/cultural"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Testing page</title>
	</head>
	<body>
		<!--  产品大图  -->
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="table-content">
			<tr>
				<th colspan="2">
					<fmt:message key="productDetail.moreImage" />
				</th>
			</tr>
			<tr>
				<td width="50%">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						align="center" class="no-border">
						<tr>
							<td width="15%" align="center">
								<span id="productMediaImageBtnPlaceHolderId_d">按钮</span>
							</td>
							<td>
								图片描述：图片限定2M内，jpg格式，主体突出。
							        （<a href="#" onclick=removeAllProductImg('productMoreImages_d');>移除所有产品大图</a>）
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<div id="productMoreImages_d">
					</div>
				</td>
			</tr>
		</table>
		
		<!-- 上传大图 -->
		<cartmatic:swf_upload
			btnPlaceHolderId="productMediaImageBtnPlaceHolderId_d"
			uploadCategory="productMedia"
			uploadFileTypes="*.jpg; *.jpeg; *.png; *.gif"
			onComplete="fnUploadMoreImage_d_Handler" objId="1110" previewSize="v"
			isMultiFiles="true" button_text="上传月刊" fileImageSize="v"
			fileSizeLimit="5MB"></cartmatic:swf_upload>
		<script type="text/javascript"
			src="<c:url value="/scripts/cartmatic/catelog/culturalForm.js"/>"></script>
	</body>
</html>