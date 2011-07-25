								marqueesHeight=30;
									stopscroll=false;
									with(marquees){
									  style.width=0;
									  style.height=marqueesHeight;
									  style.overflowX="visible";
									  style.overflowY="hidden";
									  noWrap=true;
									  onmouseover=new Function("stopscroll=true");
									  onmouseout=new Function("stopscroll=false");
									}
									document.write('<div id="templayer" style="position:absolute;z-index:1;visibility:hidden"></div>');
									
									preTop=0; currentTop=0; 
									
									function init(){
										welcome('welcome');
									    loginOrLogoout('logoinOrOut');
									 	setAdervtise(0);
									  	getStockImage('img-1',0);
										getStockImage('img-2',1);
										getStockContent('stock-7');
										sendLeave( 'leaveWords' );
									  templayer.innerHTML="";
									  while(templayer.offsetHeight<marqueesHeight){
									    templayer.innerHTML+=marquees.innerHTML;
									  }
									  marquees.innerHTML=templayer.innerHTML+templayer.innerHTML;
									  setInterval("scrollUp()",50);
									  
									  templayers.innerHTML="";
										while(templayers.offsetHeight<marqueesHeight){
										  templayers.innerHTML+=marqueess.innerHTML;
										}
										marqueess.innerHTML=templayers.innerHTML+templayers.innerHTML;
										setInterval("scrollUps()",50);
									}
									document.body.onload=init;
									function scrollUp(){
									  if(stopscroll==true) return;
									  preTop=marquees.scrollTop;
									  marquees.scrollTop+=1;
									  if(preTop==marquees.scrollTop){
									    marquees.scrollTop=templayer.offsetHeight-marqueesHeight;
									    marquees.scrollTop+=1;
									  }
									}