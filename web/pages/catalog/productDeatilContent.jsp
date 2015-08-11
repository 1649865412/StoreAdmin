<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="cartmatic" tagdir="/WEB-INF/tags/cartmatic"%>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="table-content">
	<tr>
		<th>
			产品详情页详细描述下单提示语
		</th>
	</tr>
	<tr>
		<td>
			<textarea id="productInfoationDescription" rows="4" cols="80"
				style="width: 99.5%" name="productInfoationDescription">${product.productDescription.productInfoationDescription}999999</textarea>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="table-content">
	<tr>
		<th>
			产品详情页尺码对照表
		</th>
	</tr>
	<tr>
		<td>
			<textarea id="productSizeDescription" rows="4" cols="80"
				style="width: 99.5%" name="productSizeDescription">${product.productDescription.productSizeDescription}</textarea>
		</td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="table-content">
	<tr>
		<th>
			产品详情页售后物流说明
		</th>
	</tr>
	<tr>
		<td>
			<textarea id="customerServiceDescription" rows="4" cols="80"
				style="width: 99.5%" name="customerServiceDescription">${product.productDescription.customerServiceDescription}</textarea>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="table-content">
	<tr>
		<th>
			产品详情页二维码说明
		</th>
	</tr>
	<tr>
		<td>
			<textarea id="qrCodeDescription" rows="4" cols="80"
				style="width: 99.5%" name="qrCodeDescription">${product.productDescription.qrCodeDescription}</textarea>
		</td>
	</tr>
</table>

<app:ui_htmlEditor textareaIds="qrCodeDescription" />