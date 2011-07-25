function setTopName(){
	
	var strurl = window.location.href; // id为dis0,1,2,...10分别是首页,供应,求购,...爱问,栏目
	setClassName(9);
	if(strurl.indexOf('supply')>0){
		var j = 8;
		setClassName(j);
	}
	if(strurl.indexOf('credit')>0){
		var j = 7;
		setClassName(j);
	}
	if(strurl.indexOf('stock')>0){
		var j = 6;
		setClassName(j);
	}
	if(strurl.indexOf('active')>0){
		var j = 5;
		setClassName(j);
	}
	if(strurl.indexOf('techo')>0){
		var j = 4;
		setClassName(j);
	}
	if(strurl.indexOf('product')>0){
		var j = 3;
		setClassName(j);
	}
	if(strurl.indexOf('resume')>0){
		var j = 2;
		setClassName(j);
	}
	if(strurl.indexOf('leavel')>0){
		var j = 1;
		setClassName(j);
	}
	 
	
	function setClassName(j)
	{
		for(var i =1;i<10;i++)
		{
			if(i==j)
			{
				document.getElementById('dis'+i).className='new-dh';	
			}
			else
			{
				document.getElementById('dis'+i).className='';	
			}
		}
	}	
	
	
	
}