function getAnswerInfo(div_id) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(div_id,
			'/templates/default/jsp/getAnswerInfo.jsp?div_id='+div_id+'&data='+data, {
				method : 'get',
				evalScripts : true
			});
}