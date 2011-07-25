/**
* @author:aliued-wd zhujunbiaojb
*/
Namespace = new Object();
Namespace.register = function(namespace){
var nsArray = namespace.split('.');
var sEval = "";
var sNS = "";
for (var i = 0; i < nsArray.length; i++){
if (i != 0) sNS += ".";
sNS += nsArray[i];
sEval += "if (typeof(" + sNS + ") == 'undefined') " + sNS + " = new Object();"
}
if (sEval != "") eval(sEval);
}
$ = function(el){
return document.getElementById(el);
}
function aliclick(u, param) {
d = new Date();
if(document.images) {
(new Image()).src="http://page.china.alibaba.com/stat/stat.html" + param + "&time=" + d.getTime();
}
return true;
}
//此处用于翻页状态图片的显示转换
function changeAutoButtom(){
if(document.getElementById("isAutoPlay").value == "noplay"){
document.getElementById("isAutoPlay").value = "rdplay";
}
}
function changeAutoImg(){
if(document.getElementById("autoImg").src == "http://img.china.alibaba.com/images/cn/home/rdplay.gif"){
document.getElementById("isAutoPlay").value = "startplay";
}
if(document.getElementById("autoImg").src == "http://img.china.alibaba.com/images/cn/home/startplay.gif"){
document.getElementById("isAutoPlay").value = "rdplay";
}
if(document.getElementById("autoImg").src == "http://img.china.alibaba.com/images/cn/home/noplay.gif"){
document.getElementById("isAutoPlay").value = "rdplay";
}
}
function setCookieAlitalkpopup()
{
if ( getCookieAlitalkpopup("alitalkpromote") == null )
{
var expires = new Date();
expires.setTime(expires.getTime() + 4*60*60*1000);
var the_cookie = "alitalkpromote=viewed;path=/;domain=.alibaba.com;expires=" + expires.toGMTString();
document.cookie = the_cookie;
}
}
function getCookieAlitalkpopup(cookieName) {
var cookieString = document.cookie;
var start = cookieString.indexOf(cookieName + '=');
if (start == -1)
return null;
start += cookieName.length + 1;
var end = cookieString.indexOf(';', start);
if (end == -1) return unescape(cookieString.substring(start));
return unescape(cookieString.substring(start, end));
}
function newCheckAlitalkInstalled()
{
var obj;
try{
obj = new ActiveXObject("AlitalkSetup.Install");
}
catch(e){
}
if (null!=obj){
return true;
} else {
return false;
}
}
function checkAlitalkpopup()
{
if (newCheckAlitalkInstalled())
{
setCookieAlitalkpopup() ;
return false;
}
if ( getCookieAlitalkpopup("alitalkpromote") != null )
{
return false;
}
return true;
}
function newCheckAlitoolbarInstalled()
{
var obj;
try{
obj = new ActiveXObject("YAliALive.Live");
}
catch(e){
}
if (null!=obj){
return true;
} else {
return false;
}
}
function checkAlitoolbarpopup()
{
if (newCheckAlitoolbarInstalled())
{
return false;
}
return true;
}
function addListener(el,eventType,fn){
if(el.addEventListener){
el.addEventListener(eventType,fn,false);
}else if(el.attachEvent){
el.attachEvent("on" + eventType,fn);
}else{
el["on"+eventType] = fn;
}
}
//<![CDATA[
window.onerror=function(){return true;}
function validstr(str) // 验证用户名
{ var s,i,j; s=" +=|'#&<>%*`^/\\\";,."; str1=str.value.toString();
if (str.value.length <1){alert("昵称不能为空！");str.focus(); return false;}
for (i=0; i<str1.length; i++)
{	for(j=0;j<s.length;j++)
{if (str1.charAt(i) == s.charAt(j))
{	alert("名字中不能包含特殊字符: +=|'#&<>%*`^/\\\";,.空格.");
str.focus(); return false;
}}}return true;
}
function OnLogin(n) // 登录聊天室
{
if(!validstr(login.user))return ;
login.submit() ;
}
//右侧内容切换
function show_it(n){
var n;
if(n == 0){
//alert(n);
document.getElementById("right_1").style.display = "";
document.getElementById("right_2").style.display = "";
document.getElementById("right_3").style.display = "";
document.getElementById("right_4").style.display = "";
document.getElementById("right_1b").style.display = "none";
document.getElementById("right_2b").style.display = "none";
document.getElementById("right_3b").style.display = "none";
}else{
//alert(n);
document.getElementById("right_1").style.display = "none";
document.getElementById("right_2").style.display = "none";
document.getElementById("right_3").style.display = "none";
document.getElementById("right_4").style.display = "none";
document.getElementById("right_1b").style.display = "";
document.getElementById("right_2b").style.display = "";
document.getElementById("right_3b").style.display = "";
}
}
function olImg() { //v3.0
var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
var i,j=d.MM_p.length,a=olImg.arguments; for(i=0; i<a.length; i++)
if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
function show_div(div_id,obj){
var  t_id = document.getElementById(div_id);
var  t_num = document.getElementById(obj);
if (t_id.style.display == ""){
t_id.style.display = "none";
t_num.style.background = "url('http://img.china.alibaba.com/images/cn/home/070215/left_menu_title_down.gif') no-repeat 5px 0px";
}else{
t_id.style.display = "";
t_num.style.background = "url('http://img.china.alibaba.com/images/cn/home/070215/left_menu_title_up.gif') no-repeat 5px 0px";
}
}
function MM_swapImgRestore() { //v3.0
var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
function MM_findObj(n, d) { //v4.01
var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
if(!x && d.getElementById) x=d.getElementById(n); return x;
}
function MM_showHideLayers() { //v6.0
var i,p,v,obj,args=MM_showHideLayers.arguments;
for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
obj.visibility=v; }
}
function MM_swapImage() { //v3.0
var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
function slideLine(ul, delay, speed, lh) {
var slideBox = (typeof ul == 'string')?document.getElementById(ul):ul;
var delay = delay||1000, speed=speed||60, lh = lh||60;
var tid = null, pause = false;
var start = function() {
tid=setInterval(slide, speed);
}
var slide = function() {
if (pause) return;
slideBox.scrollTop += 2;
if (slideBox.scrollTop % lh == 0) {
clearInterval(tid);
slideBox.appendChild(slideBox.getElementsByTagName('li')[0]);
slideBox.scrollTop = 0;
setTimeout(start, delay);
}
}
slideBox.onmouseover=function(){pause=true;}
slideBox.onmouseout=function(){pause=false;}
setTimeout(start, delay);
}
function show_menu(obj_s,obj){
var  s_id = document.getElementById(obj_s);
var  sc_id = document.getElementById(obj);
s_id.style.display = "";
sc_id.className = "ahv";
}
function hide_menu(obj_h,obj){
var  h_id = document.getElementById(obj_h);
var  hc_id = document.getElementById(obj);
h_id.style.display = "none";
hc_id.className = "alk";
}
function closeNotice(){
try{
document.getElementById('alinotice').style.display='none';
if(moveBox){
if(document.getElementById('alitalk_chk_show').style.marginTop == "0px"||document.getElementById('alitoolbar_chk_show').style.marginTop == "0px"){
moveBox=null;
moveBox = new MoveBox(document.getElementById('menu_list'));
initMoveBox(moveBox,true)
}else if(document.getElementById('alitalk_chk_show').style.marginTop == "-45px"&&document.getElementById('alitoolbar_chk_show').style.marginTop == "-45px"){
moveBox=null;
moveBox = new MoveBox(document.getElementById('menu_list'));
initMoveBox(moveBox,true);
}
}else{
moveBox = new MoveBox(document.getElementById('menu_list'));
initMoveBox(moveBox,true)
}
}catch(e){
}
}
function clickTime()
{
var thistime = new Date();
var years = thistime.getYear();
var days = thistime.getDay();
var hours = thistime.getHours();
var minutes = thistime.getMinutes();
var seconds = thistime.getSeconds();
var lastDate = new Date(thistime.getYear(), thistime.getMonth(), thistime.getDate(),hours,5*parseInt(minutes/5));
if(hours>17||hours<9){
document.getElementById("mainbody").parentNode.className="row11";
if(hours>=18){
document.getElementById("mainbody").innerHTML = "下次更新时间是明日9:00";
}else{
document.getElementById("mainbody").innerHTML = "下次更新时间是今日9:00";
}
document.getElementById("lastTime").innerHTML="上次更新时间18:00";
}else{
document.getElementById("mainbody").parentNode.className="row1";
minutes = 4 - minutes % 5;
seconds = 59 - seconds;
var smin = lastDate.getMinutes();
if(smin<10)smin="0"+smin;
document.getElementById("lastTime").innerHTML="上次更新时间"+(lastDate.getHours())+":"+smin;
if(minutes == 0 && seconds == 0){
//window.location.reload();
document.getElementById('timeIframe').src='http://page.china.alibaba.com/paimai/searchhomepage.html?iframe_delete=true';
}else{
if(minutes<10)minutes="0"+minutes;
if(seconds<10)seconds="0"+seconds;
thistime = minutes + ":" + seconds;
document.getElementById("mainbody").innerHTML = thistime;
}
}
setTimeout("clickTime()",1000);
}
//]]>
function checkforms(idName) {
var keywords = document.getElementById(idName).value;
if ((keywords == "") || (keywords == "输入关键字") || (keywords == "请输入产品名称！")) {
alert("请输入关键字！");
document.getElementById(idName).focus();
return false;
}
}
/*
* 函数说明：去除头尾空格
* 参数：	字符串
* 返回值：	无
* 时间：2005-5-12
*/
function trim(inputString) {
return inputString.replace(/^ +/,"").replace(/ +$/,"");
}
/*
* 函数说明：取cookie值
* 参数：	cookie字段名
* 返回值：	cookie值
* 时间：2005-5-12
*/
function getCookie(sName) {
var aCookie = document.cookie.split("; ");
for (var i=0; i < aCookie.length; i++)
{
var aCrumb = aCookie[i].split("=");
if (sName == aCrumb[0])
return unescape(aCrumb[1]);
}
return null;
}
/*
* 函数说明：取历史记录
* 参数：	sKwId:显示的容器id,nNum:显示搜索记录的个数
* 时间：2007-11-20
*/
function getHistoryWords(sKwId,nNum){
var keys_str = getCookie('h_keys');
if (keys_str != null) {
var keys_array = keys_str.split("#");
if (keys_array.length >= 3) {
var strlen = 0;
var str = "<strong>最近搜索记录：</strong>";
for (var i = 0; i < keys_array.length && i < nNum; i++) {
var type = keys_array[i].substring(keys_array[i].length - 3, keys_array[i].length);
var key = keys_array[i].substring(0, keys_array[i].length - 3);
strlen = strlen + key.length;
if (strlen < nNum*6) {
if (type == '[供]') {
str += " <a target=_blank href=http://search.china.alibaba.com/selloffer/" + encodeURI(key) + ".html?tracelog=jy_homepage_historyky class=textwhite onMouseDown=\"return aliclick(this,'?tracelog=ui_homepage_searchbuy');\">" + key + "</a> ";
}
else {
str += " <a target=_blank href=http://search.china.alibaba.com/buyoffer/" + encodeURI(key) + ".html?tracelog=jy_homepage_historyky class=textwhite onMouseDown=\"return aliclick(this,'?tracelog=ui_homepage_searchsellerkey');\">" + key + "</a> ";
}
}
}
document.getElementById(sKwId).innerHTML=str;
}
}
}
/*
* 函数说明：限制页面内容中图片和表格的大小
* 参数：	nNum被限制的表格/图片的最大宽度
* 时间：2007-11-28 yaosl
*/
function ResizeContent(nNum){
var myContent,oldWidth;
var maxWidth=nNum;
var array=new Array(2);
array[0]= "img";
array[1]= "table";
for (n = 0; n < array.length; n++){
var detailImg = document.getElementsByTagName(array[n]);
for (i = 0; i < detailImg.length; i++) {
myContent = detailImg[i];
if (myContent.width > maxWidth) {
oldWidth = myContent.width;
myContent.width = maxWidth;
myContent.height = myContent.height * (maxWidth / oldWidth);
}
}
}
}
function $(element) {
if (arguments.length > 1) {
for (var i = 0, elements = [], length = arguments.length; i < length; i++)
elements.push($(arguments[i]));
return elements;
}
if (typeof element == 'string')
element = document.getElementById(element);
return element;
}
function trim(inputString) {
return inputString.replace(/^ +/,"").replace(/ +$/,"");
}
function sr_ra_1(o){
if(k=$("sr_keyw")){
if(""==k.value || "请输入"==k.value.substring(0,3)){
k.value = o.title
k.style.color = "#AAB7C7"
}
$("sel_ra").value = o.title
var a = o.value.split("||")
$("sr_fm").action = a[0]
//$("sr_fm").tracelog.value = a[1]
}
}
function sr_ra_2(o){
if(k=$("sr_keyw")){
if(""==k.value || "请输入"==k.value.substring(0,3)){
k.value = o.title
k.style.color = "#AAB7C7"
}
$("sel_ra").value = o.title
var a = o.value.split("||")
if(document.all){
$("sr_fm").attributes[83].value = a[0]
}else{
$("sr_fm").attributes[0].value = a[0]
}
//$("sr_fm").tracelog.value = a[1]
$("sr_fm").action.value = a[2]
$("sr_fm").searchType.value = a[3]
$("sr_fm").searchPlace.value = a[4]
}
}
function sr_forblog(){
if($("sr_fm").searchType.value=="person"){
$("sr_fm").username.value = $("sr_keyw").value
}else{
$("sr_fm").username.value = ""
}
if($("sr_fm").tracelog.value == "blogsearch_wintag" ){
$("sr_fm").ebookname.value = $("sr_keyw").value
$("sr_fm").keywords.value = "赢在中国"
}
else{
$("sr_fm").ebookname.value = ""
$("sr_fm").keywords.value = $("sr_keyw").value
}
}
var sr_gl = ["","",""]
function sr_sel(o,n){
if(k=$("sr_fm")){
if(o.value!=""){
var t = 1==n ? k.biztype : 2==n ? k.province : k.categoryId
t.value=o.value
sr_gl[n-1] = n
}else
sr_gl[n-1] = ""
k.tracelog.value = "chinaindex_searchcompany_" + sr_gl[0] + sr_gl[1] + sr_gl[2]
}
}
function sr_clickfrd(o){
var k = $("sr_keyw")
if(""==k.value || "请输入"==k.value.substring(0,3)){
k.value = o.title
k.style.color = "#AAB7C7"
}
$("sel_ra").value = o.title
$("sr_fm").searchType.value = o.value;
}
function sr_chgcateid(n){
$("sr_fm").categoryId.value = n
}
function sr_chgbiztyp(n){
$("sr_fm").biztype.value = n
}
function sr_chgtrdtp(n){
$("sr_fm").trade_type.value = n
}
function sr_onfocus(o){
var v = o.value;
if(v.substring(0,3) =="请输入")o.value = ""
o.style.color="#000";
}
function sr_onblur_1(o){
/*if($("sel_ra")){
var s = $("sel_ra").value;
if(""==o.value || s==o.value){ o.style.color="#AAB7C7";o.value= s }
}*/
}
function sr_addswd(){
var tr = $("sr_fm").tracelog.value
var a = ""
if("chinaindex_searchsale_cy1"==tr){
a = " 创业"
}else if("chinaindex_searchsale_cy2"==tr){
a = " 招商"
}else if("chinaindex_searchsale_cy"==tr){
a = " 加盟"
}else if("chinaindex_searchcompany_wm"==tr){
a = " 出口"
}
$("sr_fm").keywords.value =$("sr_keyw").value+a;
}
function tp_search(o){
var v = o.keywords.value;
if(v.length > 100){
alert("您输入的关键字过长！");
return false;
}
if(v == ""  || v.substring(0,3) =="请输入") {
alert("请输入关键字！");
return false;
}
}
function sr_bwzd(o){
var s=$('sr_keyw').value;
if( s == '' || s == $('sel_ra').value ){
alert('请输入关键字！');
return false;
}
var h = o.href
o.href = h.substring(0,h.indexOf('keywords=')+9) + $('sr_keyw').value
return true;
}
//suggestion
function getCookie(sName) {
var aCookie = document.cookie.split("; ");
for (var i=0; i < aCookie.length; i++)
{
var aCrumb = aCookie[i].split("=");
if (sName == aCrumb[0])
return unescape(aCrumb[1]);
}
return null;
}
function initHistory(){
var keys_str = getCookie('h_keys');
if(keys_str != null  )
{
var keys_array = keys_str.split("#");
if(keys_array.length >= 5){
var strlen =0;
var str="最近搜索记录：";
for(var i=0;i<keys_array.length && i<9;i++){
var type = keys_array[i].substring(keys_array[i].length-3,keys_array[i].length);
var key = keys_array[i].substring(0,keys_array[i].length-3);
strlen = strlen + key.length;
if(strlen < 30){
if(type =='[供]')
str+=" <a target=_blank href=http://search.china.alibaba.com/selloffer/"+encodeURI(key)+".html?tracelog=jy_homepage_historyky class=textwhite onMouseDown=\"return aliclick(this,'?tracelog=ui_homepage_searchbuy');\">"+ key +"</a> ";
else
str+=" <a target=_blank href=http://search.china.alibaba.com/buyoffer/"+encodeURI(key)+".html?tracelog=jy_homepage_historyky class=textwhite onMouseDown=\"return aliclick(this,'?tracelog=ui_homepage_searchsellerkey');\">"+ key +"</a> ";
}
}
document.getElementById("sform_1").innerHTML=str;
}
}
}
var searchActivedItem=1;
//结构化搜索
function SB_OnBlur_x(ctrlObj,ctrlMenuID, event){
if(searchActivedItem == 1){
return SB_OnBlur(ctrlObj,ctrlMenuID, event)
}else{
return true;
}
}
function SB_OnKeyDown_x(ctrlObj,ctrlMenuID, event){
if(searchActivedItem == 1){
return SB_OnKeyDown(ctrlObj,ctrlMenuID, event)
}else{
return true;
}
}
function SB_OnKeyUp_x(ctrlObj,ctrlMenuID, event){
if(searchActivedItem == 1){
return SB_OnKeyUp(ctrlObj,ctrlMenuID, event)
}else{
return true;
}
}
//new
function sr_topul_ini(){
var n = $("sr_n").value
var c = $("tl_"+n).className
$("tl_"+n).className = c.replace("_","_v_")
$("tl_"+n).onclick = $("tl_"+n).onmouseover = function(){return false}
}
//add by 070827
//初始化输入框默认值
function initDefaultValue(){
var keyW = getQuery("keywords");
if(keyW&&keyW!="")document.getElementById("sr_keyw").value = decodeURI(keyW);
}
function getQuery(name)
{
 var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
 var r = location.href.substr(location.href.indexOf("\?")+1).match(reg);
 if (r!=null) return r[2]; return null;
}
function getkeyword(obj){
var skey = document.getElementById("sr_keyw").value;
if(trim(skey)==""||"请输入"==skey.substring(0,3)){
return true;
}else{
window.location.href=obj.href+"?keywords="+encodeURI(skey);
return false;
}
}
function do_it(){
if (!newCheckAlitalkInstalled() )
{
document.getElementById('alitalk_chk_show').style.display="";
}else if(!newCheckAlitoolbarInstalled()){
document.getElementById('alitoolbar_chk_show').style.display="";
}
//setCookieAlitalkpopup() ;
}
var SB_menuItemArray = new Array();
var SB_menuItemSelectIndex = -1;
var SB_isMenuShow = false;
var SB_m_pageSize = 10;
var SB_m_page = 1;
var sg_cache = new Object();
var SB_objInput = null;
var SB_ctrlObj = null;
var SB_ctrlMenuID = null;
var SB_timeDelay = 50;
var SB_keyword = null;
var SB_lastRequestTime=new Date().getTime() - SB_timeDelay;
var SB_doneSign=true;
var SB_G_ctrlObj = null;
var SB_G_ctrlMenuID = null;
var SB_Previous = null;
var SB_getInfor = "SB_getInfor";
function SB_canDoSign(){
var lastRequestTime_tmp = new Date().getTime();
if(lastRequestTime_tmp - SB_lastRequestTime > SB_timeDelay){
return true;
}else{
return false;
}
}
function SB_doTime_OnKeyUp(){
if(SB_ctrlObj != null && SB_ctrlMenuID != null && SB_doneSign){
var ctrlObj = SB_ctrlObj;
ctrlMenuID = SB_ctrlMenuID;
SB_ctrlObj	= null;
SB_ctrlMenuID = null;
SB_LoadMenuItemArray(ctrlObj, ctrlMenuID, true);
}
}
function SB_ShowMenu(ctrlObj, ctrlMenuID, show){
SB_objInput = ctrlObj;
var menu = document.getElementById(ctrlMenuID);
var ifrm = document.getElementById(ctrlMenuID + "_IFRAME");
if(show){
var btn = ctrlObj;
if(btn){
var x = btn.offsetLeft;
var y = btn.offsetTop;
menu.style.left = x;
menu.style.top = y+22;
}
menu.style.display = "block";
SB_isMenuShow = true;
var widthX = ctrlObj.offsetWidth
var heightX = menu.offsetHeight
menu.style.width = widthX - 2 + "px"
ifrm.style.width = widthX - 4 + "px"
ifrm.style.height = heightX - 2 + "px"
ifrm.style.top = menu.style.top;
ifrm.style.left = menu.style.left;
ifrm.style.display = "block";
try{
if(ctrlObj.showTracelog && ctrlObj.showTracelog.length>0){
aliclick(document, "?tracelog=" + ctrlObj.showTracelog);
}
}catch(e) {}
}else{
menu.style.display = "none";
ifrm.style.display = "none";
SB_isMenuShow = false;
SB_lastRequestTime -= SB_timeDelay;
}
}
function SB_OnDropDown(ctrlObj, ctrlMenuID){
SB_LoadMenuItemArray(ctrlObj, ctrlMenuID);
ctrlObj.focus();
}
function SB_OnBlur(ctrlObj, ctrlMenuID, event){
SB_ShowMenu(ctrlObj, ctrlMenuID, false);
SB_doneSign = false;
}
function SB_OnKeyDown(ctrlObj, ctrlMenuID, event){
if( event.keyCode == 24){
return false;
}else{
return true;
}
}
function SB_OnKeyUp(ctrlObj, ctrlMenuID, event){
if(navigator.userAgent.indexOf('Opera') >= 0){
return;
}
if (navigator.userAgent.indexOf("Firefox")>=0 ||document.readyState == "complete"||(event.keyCode == 13 && document.readyState == "loading")) {
var returnValue = false;
switch (event.keyCode) {
case 38: // UP
if (document.getElementById(ctrlMenuID).style.display == "block") {
SB_SetMenuItemSelectIndex("OFFSET", -1);
SB_RebuildMenuSelection(ctrlObj, ctrlMenuID);
SB_SelectMenuItem(ctrlObj, ctrlMenuID, 0);
}
break;
case 40: // DOWN
if (document.getElementById(ctrlMenuID).style.display == "block") {
SB_SetMenuItemSelectIndex("OFFSET", 1);
SB_RebuildMenuSelection(ctrlObj, ctrlMenuID);
SB_SelectMenuItem(ctrlObj, ctrlMenuID, 0);
}
break;
case 13: // Enter
SB_ShowMenu(ctrlObj, ctrlMenuID, false);
return;
case 24: // ESC
SB_ShowMenu(ctrlObj, ctrlMenuID, false);
break;
default:
SB_doneSign = true;
SB_LoadMenuItemArray(ctrlObj, ctrlMenuID);
returnValue = true;
break;
}
}
return returnValue;
}
function SB_SelectMenuItem(ctrlObj, ctrlMenuID,isSubmit){
var menu = document.getElementById(ctrlMenuID);
var menuItemList = menu.childNodes;
for (var i = 0; i < menuItemList.length; i++) {
if (i == SB_menuItemSelectIndex) {
ctrlObj.value = menu.childNodes[i].firstChild.innerHTML;
break;
}
}
if (isSubmit == 1) {
SB_SelectSubmit(ctrlObj, ctrlMenuID)
}
}
function SB_SelectSubmit(ctrlObj,ctrlMenuID){
if (ctrlObj.value != "") {
try {
SB_SuggestCallBack()
}
catch(e) {}
try {
if (ctrlObj.selectTracelog && ctrlObj.selectTracelog.length > 0) {
aliclick(document, "?tracelog=" + ctrlObj.selectTracelog);
}
}
catch (e) {}
SB_ShowMenu(SB_objInput, ctrlMenuID, false);
return false;
}
}
function SB_SetMenuItemSelectIndex(action, index){
if (action == "SET") {
SB_menuItemSelectIndex = index;
}
if (action == "OFFSET") {
SB_menuItemSelectIndex += index;
}
if (SB_menuItemSelectIndex < 0) {
SB_menuItemSelectIndex = SB_menuItemArray.length - 1;
}
if (SB_menuItemArray == null || SB_menuItemSelectIndex >= SB_menuItemArray.length) {
SB_menuItemSelectIndex = 0;
}
}
function SB_RebuildMenu(ctrlObj, ctrlMenuID){
var html = "";
var start = 0;
var isContent = 0;
if (SB_m_page <= 0) {
SB_m_page = 1;
}
var maxPage = parseInt((SB_menuItemArray.length + SB_m_pageSize - 1)/SB_m_pageSize);
if (SB_m_page > maxPage) {
SB_m_page = maxPage;
}
start = (SB_m_page - 1)* SB_m_pageSize;
for(var i= start; i<SB_menuItemArray.length && i < start + SB_m_pageSize; i++){
if (SB_menuItemArray[i][0].length <= 20) {
html += "<div";
html += " onmousedown=\"SB_SelectMenuItem(SB_objInput,'" + ctrlMenuID + "',1);\"";
html += " onMouseOver=\"SB_SetMenuItemSelectIndex('SET', " + i + "); SB_RebuildMenuSelection(this,'" + ctrlMenuID + "');\"";
html += " onBlur=\"return SB_ShowMenu(SB_objInput,'" + ctrlMenuID + "', true);\"";
html += " style=\"font-size:13px;padding:0 3px;\"><span style=\"float:left;\">";
html += SB_menuItemArray[i][0];
html += "</span><span style=\"float:right;font-size:12px;color:#009933;\">约 <span style=\"font-family:Arial; font-size:11px;\">" + formatDNum(formatSNum(SB_menuItemArray[i][1])) + "</span> 结果</span>";
html += "</div>";
isContent = isContent + 1;
}
}
if (ctrlObj.getAttribute("isNewIntro") && ctrlObj.getAttribute("isNewIntro") == "true") {
html += "<div style=\"float:right; color:#003CC8; text-decoration:underline; padding-right:5px;\">关闭</div>";
}
document.getElementById(ctrlMenuID).innerHTML = html;
SB_menuItemSelectIndex = -1;
return isContent;
}
function SB_RebuildMenuSelection(ctrlObj, ctrlMenuID){
var menu = document.getElementById(ctrlMenuID);
var menuItemList = menu.childNodes;
for(var i=0; i< menuItemList.length; i++){
if(i == SB_menuItemSelectIndex){
menuItemList[i].className = "MB_MenuSelectedItem";
}else{
menuItemList[i].className = "";
}
}
}
function SB_LoadMenuItemArray(ctrlObj, ctrlMenuID, timeDelay){
var v =ctrlObj.value;;
if(v ==""){
SB_ShowMenu(ctrlObj, ctrlMenuID, false);
return;
}
if( v.length >12){
SB_ShowMenu(ctrlObj, ctrlMenuID, false);
return;
}
if(!SB_canDoSign() || !SB_doneSign){
if(!timeDelay){
SB_ctrlObj = ctrlObj;
SB_ctrlMenuID = ctrlMenuID;
setTimeout("SB_doTime_OnKeyUp()", SB_timeDelay);
}
return;
}
SB_doneSign = false;
SB_menuItemArray = ""
if (typeof(sg_cache[v]) != 'undefined') {
SB_menuItemArray = sg_cache[v];
}
if(typeof(SB_menuItemArray) =="undefined" || SB_menuItemArray == ""){
SB_menuItemArray = null;
if(SB_Previous != v){
SB_LoadIt(ctrlObj, ctrlMenuID,v);
SB_Previous = v;
}else{
return;
}
}else if(SB_menuItemArray && SB_menuItemArray.length > 0){
showMenuNeeded = true;
var isShow = SB_RebuildMenu(SB_G_ctrlObj, SB_G_ctrlMenuID);
if (isShow > 0) {
SB_ShowMenu(SB_G_ctrlObj, SB_G_ctrlMenuID, true);
SB_Previous = v;
SB_doneSign = true;
}else{
SB_ShowMenu(SB_G_ctrlObj, SB_G_ctrlMenuID, false);
}
}
SB_lastRequestTime=new Date().getTime();
}
function SB_LoadIt(ctrlObj, ctrlMenuID, v){
if(ctrlObj == null || ctrlMenuID == null){
return;
}
SB_loadContent(ctrlObj, ctrlMenuID, v);
}
function SB_loadContent(ctrlObj, ctrlMenuID, keyword){
SB_G_ctrlObj = ctrlObj;
SB_G_ctrlMenuID = ctrlMenuID;
var str='http://suggest.china.alibaba.com/bin/suggest?type=saleoffer&q='+keyword;
SB_keyword = keyword;
if(navigator.userAgent.indexOf("Firefox") <= 0) {
if(!document.getElementById(SB_getInfor)) {
var s = document.createElement('SCRIPT');
s.src = str;
s.setAttribute("id", SB_getInfor);
document.body.appendChild(s);
}else {
document.getElementById(SB_getInfor).src = str;
}
}else{
var s=document.createElement('SCRIPT');
s.src=str;
document.body.appendChild(s);
}
}
function _roll_back_(){
if (SB_G_ctrlObj == null || SB_G_ctrlMenuID == null) {
return;
}
SB_onLoadCompleted();
}
function SB_onLoadCompleted(){
var showMenuNeeded = false;
if(_suggest_result_.result && _suggest_result_.result.length >0){
SB_menuItemArray = _suggest_result_.result;
if(SB_menuItemArray && SB_menuItemArray.length > 0){
showMenuNeeded = true;
sg_cache[SB_keyword] = SB_menuItemArray;
_suggest_result_.result = null;
}
}
if(showMenuNeeded){
var isShow = SB_RebuildMenu(SB_G_ctrlObj, SB_G_ctrlMenuID);
if (isShow > 0) {
SB_ShowMenu(SB_G_ctrlObj, SB_G_ctrlMenuID, true);
}else{
SB_ShowMenu(SB_G_ctrlObj, SB_G_ctrlMenuID, false);
}
}else{
SB_ShowMenu(SB_G_ctrlObj, SB_G_ctrlMenuID, false);
}
SB_doneSign = true;
SB_lastRequestTime=new Date().getTime();
}
function formatDNum(originalNum){
var str_originalNum = originalNum.toString();
var str_finalNum = " ";
var counter = 0;
var i;
for(i=str_originalNum.length-1;i>=0;i--){
str_finalNum = str_originalNum.charAt(i) +  str_finalNum;
counter++;
if(counter==3){
counter = 0;
if(i!=0){
str_finalNum = ","+str_finalNum;
}
}
}
return str_finalNum;
}
function formatSNum(originalNum){
var str_originalNum = originalNum.toString();
var str_finalNum =  Math.floor(originalNum/Math.pow(10,(str_originalNum.length-3)))*Math.pow(10,(str_originalNum.length-3));
return str_finalNum;
}
/**
* @author shengliang.yaosl
* 2008-1-20
* suggest 提交
*/
function SB_SuggestCallBack(){
var searchForm = document.getElementById("sr_fm");
searchForm.submit();
}
/*  ObjectSwap for ie
Author: Karina Steffens, www.neo-archaic.net
simplify by xiaoma<xiaoma@taobao.com> at 2007-01-17
*/
//document.write('<style id="hideObject">object{visibility:hidden;}</style>');
(function(){
/*
var style = document.createElement("style");
style.setAttribute("type", "text/css");
style.setAttribute("id", "hideObject");
style.styleSheet.cssText = "object{visibility:hidden;}";
document.getElementsByTagName("head")[0].appendChild(style);
*/
var objects = document.getElementsByTagName("object");
for (var i=0; i<objects.length; i++){
var o = objects[i];
if (o.className.indexOf("NoSwap") != -1) continue;
var h = o.outerHTML;
var params = "";
var hasFlash = true;
for (var j = 0; j<o.childNodes.length; j++) {
var p = o.childNodes[j];
if (p.tagName == "PARAM")
params += p.outerHTML;
}
var tag = h.split(">")[0] + ">";
var newObject = tag + params + o.innerHTML + " </OBJECT>";
o.outerHTML = newObject;
}
//document.getElementById("hideObject").disabled = true;
})();
/**
* @author:aliued-wd junbiao.zhujb
*/
(function(){
var categoryCtrlObj,categoryListObj,categoryListTitleObj,categoryCache = new Array(),fatherObj,totAlist,tempAobj;
LetterCategory = {
/**
* 初始化类目筛选功能。
* categoryCtrlId String 类目筛选功能控制层ID
* categoryListId String 类目筛选功能显示层ID
*/
init:function(categoryCtrlId,categoryListId,fatherId){
categoryCtrlObj = document.getElementById(categoryCtrlId);
categoryListObj = document.getElementById(categoryListId);
fatherObj = document.getElementById(fatherId);
if(categoryListObj){
try{categoryListTitleObj = categoryCtrlObj.getElementsByTagName("span")[0];}catch(e){}
}
this.eventBinding(categoryCtrlObj,"a");
},
/**
* 给bindObj对象下的标签名为tagsName绑定onmouseover和onmouseout事件。
* bindObj Object
* tagsName String 标签名
*/
eventBinding:function(bindObj,tagsName){
var bingList = bindObj.getElementsByTagName(tagsName);
for(var i=0;i<bingList.length;i++){
if(bingList[i].href){
bingList[i].onmouseover = this.showResult;
bingList[i].onmouseout = this.hiddenResult;
}
}
},
/**
* 显示类目结果层。
*/
showResult:function(){
tempAobj = this;
LetterCategory.changeStyle(this,"show");
var categoryListStr_1 = LetterCategory.getCategoryListStr(this.innerHTML);
LetterCategory.setCategoryContent(categoryListStr_1,this.innerHTML);
categoryListObj.onmouseover = function(){LetterCategory.changeStyle(tempAobj,"show");};
categoryListObj.onmouseout = function(){LetterCategory.changeStyle(tempAobj,"hidden");};
},
/**
* 隐藏类目结果层。
*/
hiddenResult:function(){
LetterCategory.changeStyle(this,"hidden");
categoryListObj.parentNode.removeChild(document.getElementById("categoryScript"));
},
/**
* 更改类目层样式。
* a_link Object 当前触发的链接的DOM对象
* style_type String （show 显示  hidden 隐藏）
*/
changeStyle:function(a_link,style_type){
if(style_type == "show"){
a_link.className = "check";
categoryListTitleObj.className = "title_show";
categoryCtrlObj.className = "categoryCtrl";
categoryListObj.style.display = "block";
}else{
a_link.className = "";
categoryListTitleObj.className = "title_hidden";
categoryCtrlObj.className = "categoryCtrl_hidden";
categoryListObj.style.display = "none";
}
},
/**
* 根据字母获取相应的类目字符串,如果缓存中已经有这个类目字符串,
* 则从缓存中读取，如果没有则到页面中去提取新的数据，并把得到的新的数据放到缓存中.
* letter String 字母
*/
getCategoryListStr:function(letter){
var tempCategoryListStr = this.getCategoryListStrFromCache(letter);
if(tempCategoryListStr){
return tempCategoryListStr;
}else{
tempCategoryListStr = this.getCategoryListStrFromPage(letter);
this.addCategoryListStrToCache(tempCategoryListStr,letter);
if(tempCategoryListStr){
return tempCategoryListStr;
}
}
},
/**
* 根据字母从页面中提取相关数据.
* letter String 字母
*/
getCategoryListStrFromPage:function(letter){
if(!totAlist) totAlist = fatherObj.getElementsByTagName("a");
var tempCategoryListStr ="";
for(var i=0;i<totAlist.length;i++){
if(totAlist[i].className == "l_"+letter.substring(0,1)){
var tempUrl = "";
if(totAlist[i].href.indexOf("?")!=-1&&totAlist[i].href.indexOf("=")!=-1){
continue;
}else{
tempUrl = escape(totAlist[i].getAttribute("href")).substring(9,escape(totAlist[i].href).length);
}
tempCategoryListStr = tempCategoryListStr + "<a href=\"http://"+tempUrl+"\">"+totAlist[i].innerHTML+"</a>";
}
}
return tempCategoryListStr;
},
/**
* 根据字母从缓存中获取相应的类目字符串.
* letter String 字母.
*/
getCategoryListStrFromCache:function(letter){
for(var i=0;i<categoryCache.length;i++){
if(categoryCache[i].id == letter){
return categoryCache[i].value;
}
}
return null;
},
/**
* 把新的类目字符串加载到缓存中去.
* categoryListStr String 类目字符串.
* letter String 字母.
*/
addCategoryListStrToCache:function(categoryListStr,letter){
try{
categoryCache[categoryCache.length] = {id:letter,value:categoryListStr};
}catch(e){this.printError(e+":Set cache error!")}
},
/**
* 给类目结果层设置内容。
* categoryListStr String 类目列表字符串
*/
setCategoryContent:function(categoryListStr,letter){
if(categoryListObj){
if(!categoryListStr){categoryListStr = "<div style=\"text-align:center;\">没有拼音字母\“<span style='color:#ff7300;font-size:16px;font-weight:bold'>"+letter+"</span>\”开头的类目！</div>";}
categoryListObj.innerHTML = categoryListStr;
this.addListen(categoryListObj);
}
},
addListen:function(categoryListObj){
var categoryAList = categoryListObj.getElementsByTagName("a");
for(var i=0;i<categoryAList.length;i++){
categoryAList[i].onclick = function(){
try{
aliclick(this,'?tracelog=chinaindex_leimu_sx');
}catch(e){}
};
}
},
/**
* 错误提示。
* errorMsg String 错误提示内容
*/
printError:function(errorMsg){
alert(errorMsg);
}
}
})();
