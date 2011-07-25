function setTopName(){
	
	var strurl = window.location.href; // id为dis0,1,2,...10分别是首页,供应,求购,...爱问,栏目
	setClassName(0);
	if(strurl.indexOf('/default/supply')>0){
		var j = 12;
		setClassName(j);
	}
	if(strurl.indexOf('/default/stock')>0 || strurl.indexOf('inc/imgLink\.jsp')>0){
		var j = 11;
		setClassName(j);
	}
	if(strurl.indexOf('/default/product')>0){
		var j = 10;
		setClassName(j);
	}
	if(strurl.indexOf('/default/enterprise')>0){
		var j = 9;
		setClassName(j);
	}
	if(strurl.indexOf('/default/price')>0){
		var j = 1;
		setClassName(j);
	}
	if(strurl.indexOf('/default/news')>0){
		var j = 5;
		setClassName(j);
	}
	if(strurl.indexOf('/default/myzh')>0){
		var j = 6;
		setClassName(j);
	}
	if(strurl.indexOf('/default/twoHand')>0){
		var j = 3;
		setClassName(j);
	}
	if(strurl.indexOf('/default/job')>0){
		var j = 3;
		setClassName(j);
	}
	if(strurl.indexOf('/default/aiwen')>0){
		var j = 4;
		setClassName(j);
	}
	if(strurl.indexOf('/default/book')>0){
		var j = 2;
		setClassName(j);
	}
	if(strurl.indexOf('/default/pingCe')>0){
		var j = 7;
		setClassName(j);
	}
  if(strurl.indexOf('/default/changyeJiaMeng')>0){
		var j = 8;
		setClassName(j);
	}
	function setClassName(j){
		for(var i =0;i<=12;i++){
			if(i==j){
				document.getElementById('dis'+i).className='nav_menu_bg';	
			}else{
				document.getElementById('dis'+i).className='';	
			}
		}
	}	
	
}