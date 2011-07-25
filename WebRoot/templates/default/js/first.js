function submtreq(){
	 if(document.getElementById("cust_id").value=='')
	 {
	 	alert('请先登陆!');
	 	 return false;
	 	}
		var srv5=document.getElementById("title").value;
		if(srv5==""||srv5=="请输入您问题/查找的关键字")
		{
			alert("请输入问题或搜索内容！");
			return false;
		}
		Productclass.getInfoId(function (val){
			document.getElementById("rsrv_str3").value=srv5;
			document.getElementById("info_id").value=val;
			document.getElementById("sale_id").value=val;
			document.findreq.submit();
			});
		}
		function searchanser(val)
		{
			if(document.getElementById("cust_id").value=='')
	    	{
			   alert('请先登陆!');
			   return false;
			}
			var srv5
			if('searchOne'==val)
			{
				srv5=document.getElementById("title").value;
			}
			else
			{
				srv5=document.getElementById("textfield").value;
			}
			if( srv5 == "" || srv5 == "请输入您问题/查找的关键字" )
			{
				alert("请输入问题或搜索内容！");
				return false;
			}
     		window.open("/inc/include/content.html?serch="+srv5);
		}

	 	function openNew(val)
		{
				window.open("/inc/include/content.html?id="+val);
		}
		
		
		function openAnswer(val)
		{
			
		 		window.open("/inc/include/content.html?detail="+val);
		}
		
		
		function openMore(val)
		{
	     	if("question"==val)
	     	{
	     		window.open("/inc/include/content.html?question=6145246578");
	     	}
			else if("answers"==val)
	     	{
	     	 	window.open("/inc/include/content.html?answers=6145246578");
	     	}
		 }