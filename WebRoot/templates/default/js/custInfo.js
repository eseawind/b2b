function getCritiqueDivS(div_id) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(div_id,
			'/inc/include/genInfo.jsp?div='+div_id, {
				method : 'get',
				evalScripts : true
			});
}