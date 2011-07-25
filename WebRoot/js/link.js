self.onError = null;
currentX = currentY = 0; 
whichIt = null; 
lastScrollX = 0; lastScrollY = 0;
NS = (document.layers) ? 1 : 0;
IE = (document.all) ? 1: 0;
function heartBeat(objectid) {

 if(IE) { diffY = document.body.scrollTop; diffX = document.body.scrollLeft; }
 if(NS) { diffY = self.pageYOffset; diffX = self.pageXOffset; }
 if(diffY != lastScrollY) {
  percent = .1 * (diffY - lastScrollY);
  if(percent > 0) percent = Math.ceil(percent);
  else percent = Math.floor(percent);
  if(IE) {
   objectid = objectid.split(";"); 
   for (i = 0; i < objectid.length; i++) eval("document.all."+objectid[i]).style.pixelTop += percent;
  } 
  if(NS) {
   objectid = objectid.split(";"); 
   for (i = 0; i < objectid.length; i++) eval("document."+objectid[i]).top += percent; 
  } 
  lastScrollY = lastScrollY + percent;
 }
 if(diffX != lastScrollX) {
  percent = .1 * (diffX - lastScrollX);
  if(percent > 0) percent = Math.ceil(percent);
  else percent = Math.floor(percent);
  if(IE) {
   objectid = objectid.split(";"); 
   for (i = 0; i < objectid.length; i++) eval("document.all."+objectid[i]).style.pixelLeft += percent;
  } 
  if(NS) {
   objectid = objectid.split(";"); 
   for (i = 0; i < objectid.length; i++) eval("document."+objectid[i]).right += percent; 
  } 
  lastScrollX = lastScrollX + percent;
 }  
}
if(NS || IE) action = window.setInterval("heartBeat('floater')", 1);










/* 
放在首页头部
<script language="JavaScript" src="link.js"></script>

<DIV id=floater style=Z-INDEX:100;VISIBILITY:visible;WIDTH:22px;POSITION:absolute;TOP:228px;right:1px;>
<div style="width:auto; float:left"><a href="#"><img src="images/right_01.gif" border="0"></a></DIV>
<div style="width:auto; float:left"><a href="#"><img src="images/right_02.gif" border="0"></a></DIV>
<div style="width:auto; float:left"><a href="#"><img src="images/right_03.gif" border="0"></a></DIV>
<div style="width:auto; float:left"><a href="#"><img src="images/right_04.gif" border="0"></a></DIV>
</DIV>
*/