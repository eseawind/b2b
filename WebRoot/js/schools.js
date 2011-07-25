function doZoom(size){
  document.getElementById('zoom').style.fontSize=size+'px';
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

		function showHS(){
			var id=document.getElementById("trade_id").value;
			window.open("sch_list_answer.jsp?trade_id="+id);
		}
		function checkRelation(){
		    if(document.getElementById("keyword").value!=""){
		      return true;
		    }else{
		      alert('请输入关键字，否则会影响你的查询结果！');
		      document.getElementById("keyword").focus();
		    }
		  }
		  
		  		 function sch_list_reqcheckRelation(){
		    if(document.getElementById("keyword").value!=""){
		      return true;
		    }else{
		      alert('请输入关键字，否则会影响你的查询结果！');
		      document.getElementById("keyword").focus();
		    }
		  }
		  	  function search_listcheckRelation(){
		    var keyWords=document.getElementById("keyword").value;
		    keyWords=delAllSpace(keyWords);
		    if(keyWords !="" || keyWords=="请输入你要查的关键字"){
		        return true;
		    }else if(keyWords.indexOf("公司")>0){
		        alert('请输入正确的关键字，否则会影响你的查询结果！');
		        return false;
		    }else{
		      alert('请输入关键字，否则会影响你的查询结果！');
		      document.getElementById("keyword").focus();
		      return false;
		    }
		  }
		  function checkKey(){
		    var keyWords=document.getElementById("keyword").value;
		    keyWords=delAllSpace(keyWords);
		    if(keyWords==""||keyWords==null){
		       document.getElementById("keyword").value="请输入你要查的关键字";
		    }
		  }
		  function delAllSpace(str) {
			return str.replace(/^\s+|\s+$/g, "")
		 }
		 
		  		function sch_list_answercheck_Value(){
			if (document.answerForm.deal_user.value == ""||document.answerForm.deal_user.value == null)
			{
				alert("回答人不可以为空！");
				document.answerForm.deal_user.focus(); 
				return false;
			}
	    	var str=document.getElementById("deal_content").value;  
		 	if (str.length>500) {
			  alert("限制500字以内");   
			  	return false;   
			  }
		}