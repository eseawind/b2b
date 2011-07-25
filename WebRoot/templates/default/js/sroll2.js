		marqueesHeight=40;
		stopscroll=false;
		with(marqueess){
		  style.width=260;
		  style.height=marqueesHeight;
		  style.overflowX="visible";
		  style.overflowY="hidden";
		  noWrap=true;
		  onmouseover=new Function("stopscroll=true");
		  onmouseout=new Function("stopscroll=false");
		}
		document.write('<div id="templayers" style="position:absolute;z-index:1;visibility:hidden"></div>');
		
		preTop=0; currentTop=0; 
		document.body.onload=init;
		function scrollUps(){
		  if(stopscroll==true) return;
		  preTop=marqueess.scrollTop;
		  marqueess.scrollTop+=1;
		  if(preTop==marqueess.scrollTop){
		    marqueess.scrollTop=templayers.offsetHeight-marqueesHeight;
		    marqueess.scrollTop+=1;
		  }
		}