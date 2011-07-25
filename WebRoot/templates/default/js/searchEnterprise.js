function genSearch(div_id,param1,paraVa1,param2,paraVa2,param3,paraVa3) 
{
	//alert( 'div='+div_id+'&changeType='+paraVa1+'&province='+ paraVa2+'&eparchy_codeS='+ paraVa3);
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(div_id,
			'/inc/include/enterprise.jsp?div='+div_id+'&param1='+paraVa1+'&param2='+ paraVa2+'&param3='+ paraVa3,{
				method : 'get',
				evalScripts : true
			});
}
