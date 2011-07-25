function getCritiqueDiv(div_id,para1,para2,para3,para4) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(div_id,
			'/inc/include/genJobInfo.jsp?div='+div_id+'&para1='+para1+'&para2='+para2+'&para3='+para3+'&iStart='+para4+'&data=' + data, {
				method : 'get',
				evalScripts : true
			});
}