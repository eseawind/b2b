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
	var delay = delay||1000, speed=speed||20, lh = lh||20;
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


/*首页公告关闭*/
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


/*鲜活度,5分钟刷新*/
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


