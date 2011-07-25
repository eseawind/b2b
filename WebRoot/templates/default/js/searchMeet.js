function genSearch(div_id,param1,paraVa1,param2,paraVa2) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(div_id,
			'/inc/include/meeting.jsp?div='+div_id+'&param1='+paraVa1+'&param2='+ paraVa2,{
				method : 'get',
				evalScripts : true
			});
}