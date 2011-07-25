function getCritiqueDiv(div_id,info_id) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(div_id,
			'/inc/include/genInfo.jsp?div='+div_id+'&info_id='+info_id+'&data=' + data, {
				method : 'get',
				evalScripts : true
			});
}