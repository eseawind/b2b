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
		function searchanser(val)
		{
				var srv5
				if('searchOne'==val)
				{
					srv5=document.getElementById("title").value;
				}
				else
				{
					srv5=document.getElementById("textfield").value;
				}
				if(srv5==""||srv5=="请输入您问题/查找的关键字")
				{
					alert("请输入问题或搜索内容！");
					return false;
				}
     		window.open("/inc/include/content.html?serch=" + srv5 );
		}
/////////////////////////////
window.onload=function()
{
	//var val=window.opener.document.getElementById("out").innerHTML;
	//document.getElementById("out").innerHTML=val;
	val=window.opener.document.getElementById("footer").innerHTML;
	document.getElementById("footer").innerHTML=val;

 	var r = window.location.search.substr(1);
 	var num=r.split("=");
 	var para=num[0];
 	var parValus=num[1];
 	if('id'==para)//查看待解决
 	{
  	getCritiqueDiv('view',parValus);
  	document.getElementById("topQ").className="nav_menu_bg";
 	 	document.getElementById("topA").className="";
  	document.getElementById("topT").className="";
 	}
 	if('serch'==para)//搜索问题
 	{
 		document.getElementById("position").innerHTML="问题列表";
 		document.getElementById("view").setAttribute("className","left_list_box");
  	document.getElementById("view").setAttribute("id","serch",0);
  	document.getElementById("topQ").className="nav_menu_bg";
  	document.getElementById("topA").className="";
  	document.getElementById("topT").className="";
 		getCritiqueDiv('serch',parValus);	
 	}
 if('detail'==para)//查看问题答案
 {
  document.getElementById("position").innerHTML="答案列表";
  document.getElementById("view").setAttribute("className","left_list_box");
  
  document.getElementById("view").setAttribute("id","answer",0);
  
  document.getElementById("topA").className="nav_menu_bg";
  document.getElementById("topQ").className="";
  
  document.getElementById("topT").className="";
  
  getCritiqueDiv('answer',parValus);	
 }
 if('question'==para)
 {
 	document.getElementById("position").innerHTML="待解决问题列表";
 	document.getElementById("view").setAttribute("className","left_list_box");
 	document.getElementById("view").setAttribute("id","question",0);
 	document.getElementById("topQ").className="nav_menu_bg";
 	document.getElementById("topA").className="";
 	document.getElementById("topT").className="";
 	getCritiqueDiv('question',parValus);
 	}
 	
 	if('answers'==para)
 	{
 	 document.getElementById("position").innerHTML="已解决问题列表";
 	 document.getElementById("view").setAttribute("className","left_list_box");
 	 document.getElementById("view").setAttribute("id","answers",0);
 	 document.getElementById("topA").className="nav_menu_bg";
 	 document.getElementById("topQ").className="";
 	 document.getElementById("topT").className="";
 	 getCritiqueDiv('answers',parValus);
 	}
}
 function openWin(val)
 {
 		window.location="/inc/include/content.html?detail="+val;
 }
  function openNew(val)
	{
		
		window.open("/inc/include/content.html?id="+val);
	}
	function openAnswer(val)
	{ 
	 window.open("/inc/include/content.html?detail="+val);
	}
	
	function aiwenTop()
	{
		val = "<div id='top'><div class='width'><div class='top_left'>欢迎访问 中国木材市场网-中木爱问</div><div class='top_right'><a href='#'>高级会员服务</a> | <a href='#'>联系我们</a> | <span class='lin2'><a href='#'>爱问帮助？</a></span></div></div></div>  "+
					"<div id='head'><div class='logo'><a href='/'><img src='/templates/default/images/logo.gif'  border='0' /></a></div><div class='head_right'><div class='head_right_button'><div class='button lin1'><span><a href='/member/index.html'>免费发布信息</a></span></div> "+
					"<div class='button'><span><a href='/default/product/'>产品中心</a></span></div><div class='button'><span><a href='/member/Newcregister.html'>免费注册</a></span></div><div class='button'><span><a href='/member/index.html'>登录</a></span></div></div>"+
					"<div class='nav_link'><ul><li id='dis12'><a href='/default/supply/index.html'>供应信息</a></li><li id='dis11'><a href='/default/stock/index.html'>求购信息</a></li><li id='dis10'><a href='/default/product/index.html'>产品库</a></li><li id='dis9'><a href='/default/enterprise/index.html'>企业库</a></li> "+     
					"<li id='dis8'><a href='/default/changyeJiaMeng/index.html'>创业加盟</a></li><li id='dis7'><a href='/default/pingCe/index.html'>评测</a></li><li id='dis6'><a href='/default/myzh/index.html'>市场展会</a></li><li id='dis5'><a href='/default/news/index.html'>资讯</a></li>"+
					"<li id='dis4'><a href='/default/aiwen/index.html'>问答</a></li><li id='dis3'><a href='/default/job/index.html'>人才</a></li></ul></div></div></div><div id='nav'><div class='nav_menu'>"+
					"<ul><li><a href='/default/aiwen/index.html'>爱问首页</a></li><li><a href='/default/aiwen/request/index.html'>待解决问题</a>&nbsp;&nbsp;|</li><li><a href='/default/aiwen/resolveReq/index.html'>已解决问题</a>&nbsp;&nbsp;|</li><li><a href='/default/aiwen/woodKnowledge/index.html'>企业知识</a>&nbsp;&nbsp;|</li>"+
					"<li><a href='/default/aiwen/woodPicture/index.html'>企业图库</a>&nbsp;&nbsp;|</li><li><a href='/default/aiwen/technology/index.html'>技术成果</a>&nbsp;&nbsp;|</li></ul><div class='nav_menu_sws'>我的商务室</div></div><div class='nav_search_box'><table width='100%' border='0' cellspacing='0' cellpadding='0' style='margin-top:12px;'>"+
					"<tr><td height='52' align='center'><span style='font-size:14px;'>请输入您的问题：</span><input name='textfield' id='textfield' type='text' style='font-size:14px; line-height:18px; height:20px; border:1px solid #7F9DB9' value='' size='42' />"+
					"<input type='button' name='Submit' value='搜索答案' class='school_button' onclick='return searchanser('searchTwo')'/></td><td align='right' valign='top'><a href='javascript:openMore('answers');'><img src='/templates/default/images/aiwen_15.gif' border='0' /></a><a href='javascript:openMore('question');'><img src='/templates/default/images/aiwen_16.gif' border='0' /></a></td></tr></table></div></div>";	
		return val;
	}