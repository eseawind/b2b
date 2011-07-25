function getCritiqueDiv(div_id,info_id,iStart) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(div_id,
			'/inc/include/genInfo.jsp?div='+div_id+'&info_id='+info_id+'&iStart='+iStart+'&data=' + data, {
				method : 'get',
				evalScripts : true
			});
}