function getLogo(div_id) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(div_id,
			'/templates/default/jsp/getLogo.jsp?data=' + data, {
				method : 'get',
				evalScripts : true
			});
}