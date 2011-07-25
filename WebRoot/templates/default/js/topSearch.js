
	function Search()
	{ 
		var keywd=document.getElementById("keyword").value;
     var tradeType=document.getElementById("tradeTypecode").value;
		if(keywd!=null&&keywd!=""&&keywd!="请输入您想查找的关键字"){
		window.open("/search/searchrst.html?"+keywd+","+tradeType);
	  }else{
		 alert("请输入关键字!");
		return;
		}				
	}
		
	function SearchNew(keyword,ch_id){
		var keyw = decodeURI(keyword);
		window.open("/search/searchrst.html?"+keyw+","+ch_id);			
	}
	
  function tradeType(val){
		document.getElementById("tradeTypecode").value=val;
	}