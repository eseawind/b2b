
	function Search()
	{ 
		var keywd=document.getElementById("keyword").value;
     var tradeType=document.getElementById("tradeTypecode").value;
		if(keywd!=null&&keywd!=""&&keywd!="������������ҵĹؼ���"){
		window.open("/search/searchrst.html?"+keywd+","+tradeType);
	  }else{
		 alert("������ؼ���!");
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