var marqueeContenta=new Array();//��������
				InfoList.getInfoListMarqueen('8627826821',function(dataa){
						for(var j=0;j<dataa.length;j++){ 
               marqueeContenta[j] = dataa[j]; 
						} 
					}
				)
				
				var marqueeIntervala=new Array();  //����һЩ���ö���Ҫ�����õ��ı���
				var marqueeIda=0;
				var marqueeDelaya=1000;
				var marqueeHeighta=28;
				//���������Ƕ���һЩҪʹ�õ��ĺ���
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