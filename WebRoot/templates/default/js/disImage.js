
	//弹出方法  
	function showMessageBox(content,pos)  
	{  
		 closeWindow(); 
		 var posx,posy; 
		 if (pos.pageX || pos.pageY) 
		 {
		    posx = pos.pageX;
		    posy = pos.pageY;
		 }
		 else if (pos.clientX || pos.clientY) 
		 {
			  posx = pos.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
			  posy = pos.clientY + document.body.scrollTop + document.documentElement.scrollTop;
		 }  
		 posx = posx;
		 posy = posy;
		 var mesW=document.createElement("div");  
		 mesW.id="mesWindow";  
		 mesW.className="mesWindow";  
		 mesW.innerHTML="<div class='mesWindowTop'><table width='100%' height='100%' cellpadding='0' cellspacing='0'><tr><td style='width:100px;' align=right><img src=/images/error.png onclick=closeWindow() style=cursor:hand; alt='关闭窗口'/></td></tr></table></div><div style=background-color:white; id='mesWindowContent'>"+content+"</div>";  
		  
		 var styleStr="left:"+posx+"px;top:"+posy+"px;position:absolute;width:50px;";  
		 mesW.style.cssText=styleStr;	
		 document.body.appendChild(mesW);  
	}  

	 

	//关闭窗口  
	function closeWindow()  
	{   
	 		if(document.getElementById('mesWindow')!=null)  
	 		{  
	 				document.getElementById('mesWindow').parentNode.removeChild(document.getElementById('mesWindow'));  
	 		}   
	}  
  function hideM()  
	{   
		 if(document.getElementById('mesWindow')!=null)  
		 {  
	 				document.getElementById('mesWindow').parentNode.removeChild(document.getElementById('mesWindow'));  
	 	 }   
	}  
	function testMessageBox(ev,messContent)  
	{    
	 		showMessageBox(messContent,ev); 
	} 