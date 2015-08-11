   
    <div id="talenShow" style="display:none;min-height: 520px;">
   	   <jsp:include flush="true" page="/talentmanager/talentShow.html">
		            <jsp:param name="doAction" value="productAddTalent" />
		            <jsp:param name="productId" value="${product.productId}" />
		</jsp:include>
</div>					


