			var marqueeContent=new Array();//��������
			InfoList.getInfoListMarqueenByStockSupply(function(data){
					for(var i=0;i<data.length;i++){ 
             marqueeContent[i] = data[i]; 
					} 
				}
			)
			
			var marqueeInterval=new Array();  //����һЩ���ö���Ҫ�����õ��ı���
			var marqueeId=0;
			var marqueeDelay=1000;
			var marqueeHeight=28;
			//���������Ƕ���һЩҪʹ�õ��ĺ���
			function initMarquee() {
			 var str=marqueeContent[0];
			 document.write('<div id=marqueeBox style="overflow:hidden;height:'+marqueeHeight+'px" onmouseover="clearInterval(marqueeInterval[0])" onmouseout="marqueeInterval[0]=setInterval(\'startMarquee()\',marqueeDelay)"><div>'+str+'</div></div>');
			 marqueeId++;
			 marqueeInterval[0]=setInterval("startMarquee()",marqueeDelay);
			 }
			function startMarquee() {
			 var str=marqueeContent[marqueeId];
			  marqueeId++;
			 if(marqueeId>=marqueeContent.length) marqueeId=0;
			 if(marqueeBox.childNodes.length==1) {
			  var nextLine=document.createElement('DIV');
			  nextLine.innerHTML=str;
			  marqueeBox.appendChild(nextLine);
			  }
			 else {
			  marqueeBox.childNodes[0].innerHTML=str;
			  marqueeBox.appendChild(marqueeBox.childNodes[0]);
			  marqueeBox.scrollTop=0;
			  }
			 clearInterval(marqueeInterval[1]);
			 marqueeInterval[1]=setInterval("scrollMarquee()",20);
			 }
			function scrollMarquee() {
			 marqueeBox.scrollTop++;
			 if(marqueeBox.scrollTop%marqueeHeight==(marqueeHeight-1)){
			  clearInterval(marqueeInterval[1]);
			  }
			 }
			