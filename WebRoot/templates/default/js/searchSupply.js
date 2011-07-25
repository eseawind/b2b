function genSearch(div_id,param1,paraVa1,param2,paraVa2,param3,paraVa3,param4,paraVa4,param5,paraVa5) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(div_id,
			'/inc/include/supply.jsp?div='+div_id+'&param1='+paraVa1+'&param2='+ paraVa2+'&param3='+ paraVa3+'&param4='+ paraVa4+'&param5='+ paraVa5+'&param6='+paraVa6,{
				method : 'get',
				evalScripts : true
			});
}

function genNewSearch(div_id,paraVa1,paraVa2,paraVa3,paraVa4,paraVa5) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(div_id,
			'/inc/include/supplyNew.jsp?div='+div_id+'&param1='+paraVa1+'&param2='+ paraVa2+'&param3='+ paraVa3+'&param4='+ paraVa4+'&param5='+ '0',{
				method : 'get',
				evalScripts : true
			});
}