var marqueeContenta=new Array();//滚动新闻
				InfoList.getInfoListMarqueen('8627826821',function(dataa){
						for(var j=0;j<dataa.length;j++){ 
               marqueeContenta[j] = dataa[j]; 
						} 
					}
				)
				
				var marqueeIntervala=new Array();  //定义一些常用而且要经常用到的变量
				var marqueeIda=0;
				var marqueeDelaya=1000;
				var marqueeHeighta=28;
				//接下来的是定义一些要使用到的函数
				function initMarqueeRight() {
				 var straa=marqueeContenta[0];
				 document.write('<div id=marqueeBoxa style="overflow:hidden;height:'+marqueeHeighta+'px" onmouseover="clearInterval(marqueeIntervala[0])" onmouseout="marqueeIntervala[0]=setInterval(\'startMarqueeaa()\',marqueeDelaya)"><div>'+straa+'</div></div>');
				 marqueeIda++;
				 marqueeIntervala[0]=setInterval("startMarqueeaa()",marqueeDelaya);
				 }
				function startMarqueeaa() {
				 var straa=marqueeContenta[marqueeIda];
				  marqueeIda++;
				 if(marqueeIda>=marqueeContenta.length) marqueeIda=0;
				 if(marqueeBoxa.childNodes.length==1) {
				  var nextLineaa=document.createElement('DIV');
				  nextLineaa.innerHTML=straa;
				  marqueeBoxa.appendChild(nextLineaa);
				  }
				 else {
				  marqueeBoxa.childNodes[0].innerHTML=straa;
				  marqueeBoxa.appendChild(marqueeBoxa.childNodes[0]);
				  marqueeBoxa.scrollTop=0;
				  }
				 clearInterval(marqueeIntervala[1]);
				 marqueeIntervala[1]=setInterval("scrollMarqueeaa()",20);
				 }
				function scrollMarqueeaa() {
				 marqueeBoxa.scrollTop++;
				 if(marqueeBoxa.scrollTop%marqueeHeighta==(marqueeHeighta-1)){
				  clearInterval(marqueeIntervala[1]);
				  }
				}