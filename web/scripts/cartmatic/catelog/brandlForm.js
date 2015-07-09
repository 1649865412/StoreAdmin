var orientedTabs = null;
$j(document).ready(function(){
	$j("#productMoreImages").sortable();
	$j("#productMoreImages_d").sortable();
	$j("#productAccessories").sortable();
});



/**
 * 保存产品所有数据的回调
 * @param {Object} data
 */
function fnSaveProductHandler(result){
  //  alert("goodbye")
}


/**
 * 添加触发
 * @param file
 * @return
 */
function fnUploadMoreImage_d_Handler(file){
//	alert("fnUploadMoreImage_d_Handler");
//	alert("file:"+file);
	showUploadProudctMedia_d('productMoreImages_d',0,file);
}


function showUploadProudctMedia_d(divId,uploadInputMediaType,file){
	//alert("showUploadProudctMedia_d");
	var id = "1" + new Date().getTime().toString().substr(6);
	var inputUploadHtml = "";
	var productMedia_img = "media_noPhoto.gif";
	var productDetail_media_url_desc = "";
	inputUploadHtml += '<div class="product-media" id="productMedia_div_' + id + '">';
	inputUploadHtml += '<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" class="no-border">';
	inputUploadHtml += '<tr>';
	inputUploadHtml += '<td class="list" width="15%" align="center"><input type="hidden" id="-' + id + '" name="productMediaIds" value="-' + id + '""><input type="hidden" name="productMediaTypes" value="' + uploadInputMediaType + '">';
	if (uploadInputMediaType == 0) {
		inputUploadHtml += '<img id="productMedia_img_' + id + '" src="' + __mediaPath +file.previewUrl+'" width="60" height="60" />';
	} else {
		inputUploadHtml += '<img id="productMedia_img_' + id + '" src="' + __ctxPath + '/images/accessorie_hight_light.gif" width="60" height="60" />';
	}
	inputUploadHtml += '<input type="hidden" id="productMedia_deleteds_' + id + '" name="productMedia_deleteds" value="0">';
	inputUploadHtml += '</td><td class="list" width="24%">';
	inputUploadHtml += '<input id="productMedia_url_' + id + '" name="imgArray" type="text" style="width:400px;" value="'+file.url+'"/></span>';
	inputUploadHtml += '<br />';
	inputUploadHtml += '文字描述';
	inputUploadHtml += '<br />';
	inputUploadHtml += '<input id="productMedia_desc_' + id + '" name="characterArray" type="text" style="width:400px;"/>';
	inputUploadHtml += '来源';
	inputUploadHtml += '<br />';
	inputUploadHtml += '<input id="productMedia_desc_' + id + '" name="resourceArray" type="text" style="width:400px;"/>';
	inputUploadHtml += '网址';
	inputUploadHtml += '<br />';
	inputUploadHtml += '<input id="productMedia_desc_' + id + '" name="websiteArray" type="text" style="width:400px;"/>';
	inputUploadHtml += '时间';
	inputUploadHtml += '<br />';
	inputUploadHtml += '<input id="productMedia_desc_' + id + '" name="dateTimeArray" type="text" style="width:400px;"/>';
	inputUploadHtml += '</td><td class="list">';
	inputUploadHtml += '&nbsp;&nbsp;<input name="remove_empty_item" type="image" src="' + __ctxPath + '/images/icon/icon_del.gif" onclick="fnRemoveUploadMedia('+ id+',this);return false;" title="' + __FMT.productDetail_moreImage_removeThisImage + '"/>';
	inputUploadHtml += '</td>';
	inputUploadHtml += '</tr>';
	inputUploadHtml += '</table>';
	inputUploadHtml += '</div>';
	$j("#" + divId).append(inputUploadHtml);
	fnInitValidProductMedia();
}



/**
 * 删除产品媒体的某上传Input
 * @param {Object} id 需删除的上传Input所在的DIV
 * @param {Object} parentDivId 上传控制所在的Form的ID
 */
function fnRemoveUploadMedia(id,obj){
	  var r=confirm("此操作不可恢复！")
	  if (r==true)
	    {
			var $this = $j(obj);
			$this.parents(".product-media").remove();
			monthlyCulturalIdDelete(id,obj);
	    }
	  else
	    {
	    
	    }
}

/**
 * 删除所有
 * @param id
 * @return
 */
function removeAllProductImg(id){
	//alert("removeAllProductImg");
	$j("#" + id).html("");
}


function monthlyCulturalIdDelete(id,obj) {
	 //alert("monthlyCulturalIdDelete");
	// alert(__ctxPath + "/culturalinformation/culturalInformation.html?doAction=deleteMonthly");
	$j.post(__ctxPath + "/culturalinformation/culturalInformation.html?doAction=deleteMonthly", {
		monthlyCulturalId : id
	}, function(result) {
		// alert("result:"+result.status);
			if (result.status == 1) {
				//alert("删除成功");
			} else {
				//alert("删除失败");
			}
		}, "json");
}

//动态进入后台删 除月刊数据
/*
function monthlyCulturalIdDelete(id,obj) {
	alert("monthlyCulturalIdDelete");
	$.post(__ctxPath + "/monthlycultural/monthlyCultural.html?doAction=deleteMonthly"), {
		monthlyCulturalId : id
	}, function(result) {
		     alert("result:"+result.status);
			if (result.status == 1) {
				$j('#productMedia_div_' + id).remove();
				var $this = $j(obj);
				$this.parents(".product-media").remove();
			} else {
				alert("删除失败！");
			}
		}, "json");
}*/

