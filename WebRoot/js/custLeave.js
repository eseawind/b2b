 
// 客户留言页面
function loadCustomerLeave(cust_id) {
	var strUrl = top.location.href;
	var iStart=strUrl.substring(strUrl.length-1,strUrl.length);
    if(iStart>0){
    	iStart=iStart;
    }else{
    	iStart=1;
    }
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater('commentDIV',
			'/member/comm/sendCustLeave.jsp?cust_id=' + cust_id+"&iStart="+iStart + "&data="
					+ data, {
				method : 'get',
				evalScripts : true
			});
}
function checkValue() 
{
		var rsrv_str3 = $F("rsrv_str3");
		rsrv_str3 = delAllSpace(rsrv_str3);
		if (rsrv_str3 == "" || rsrv_str3 == null) 
		{
			alert("请留下你的大名！");
			$("rsrv_str3").focus();
			return false;
		}
		var mail = $F("rsrv_str5");
		if (mail.charAt(0) == "." || mail.charAt(0) == "@"
				|| mail.indexOf('@', 0) == -1 || mail.indexOf('.', 0) == -1
				|| mail.lastIndexOf("@") == mail.length - 1
				|| mail.lastIndexOf(".") == mail.length - 1) {
			alert("Email的格式不正确！");
			$("rsrv_str5").focus();
			return false;
		}
	 	var content = $F("content");
		content = delAllSpace(content);
		if ( content == "" || content == null ) 
		{
			alert("请输入留信息！");
			$("content").focus();
			return false;
		}
		else if ( content.length < 10 ) 
		{
			alert("留言内容不能少于10个字符！");
			$("content").focus();
			return false;
		}
		else if( content.length > 2500 )
		{
			alert("留言内容太多！将会导致多余数据丢失！");
			$("content").focus();
			return false;
		} 
		$F("content") = "<xmp>" + $F("content") +"</xmp>";
		
		return true;
}

function delAllSpace(str) {
	return str.replace(/^\s+|\s+$/g, "")
}