
/**
 * 主页js
 */

// 全文搜索
function checkSearchWEBValue() {
	var info_type = "";
	if ($("supply").checked) {
		info_type = "0141";
	} else if ($("stock").checked) {
		info_type = "0154";
	} else if ($("customer").checked) {
		info_type = "0139";
	} else if ($("news").checked) {
		info_type = "0161";
	}
	 else if ($("product").checked) {
		info_type = "0560";
	}
	var s_key = $F("s_key");
	s_key = delAllSpace(s_key);
	if (s_key == "" || s_key == null) {
		alert("请输入正确的关键字！");
		$("s_key").focus();
	} else {
		window.open("/search/searchListpage.jsp?p=0&info_type=" + info_type + "&key="
				+ s_key);
		
	}
}

// 关键字检索
function checkKeyWord(key) {
	var keyWord = delAllSpace(key);
	if (keyWord == "" || keyWord == null) {
		$(s_key).value = "请输入关键字！";
	}
}
/**
 * 删除所有空格
 */
function delAllSpace(str) {
	return str.replace(/^\s+|\s+$/g, "")
}

// 取出当前时间及星期
function getDate() {
	var now = new Date(); // 获取系统日期
	var yy = now.getYear(); // 获取年
	var mm = now.getMonth() + 1; // 获取月
	var week = getWeek(now.getDay()); // 获取该天的星期值
	var dd = now.getDate();
	var date_time = yy + "-" + mm + "-" + dd + " " + week;
	return date_time;
}
function getWeek(week) {
	var weekDay = "";
	if (week == "0") {
		weekDay = "星期天";
	} else if (week == "1") {
		weekDay = "星期一";
	} else if (week == "2") {
		weekDay = "星期二";
	} else if (week == "3") {
		weekDay = "星期三";
	} else if (week == "4") {
		weekDay = "星期四";
	} else if (week == "5") {
		weekDay = "星期五";
	} else {
		weekDay = "星期六";
	}
	return weekDay;
}

// 自动加载脚本

window.onload = function() {
	$("date-time").innerHTML = getDate();
//	Shadowbox.init();
	var strUrl = top.location.href;
	if (strUrl != null && strUrl != "") {	
		if (strUrl.indexOf("supply") > 0) {//供应
			alert("ddd");
	//		$("supply").checked = true;
			$("dis12").className = "nav_menu_bg";
			$("dis11").className = "";
			$("dis10").className = "";
			$("dis9").className = "";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
	//		setAdervtise(1);
		}else if (strUrl.indexOf("stock") > 0) {//求购
		//	$("stock").checked = true;
			$("dis12").className = "";
			$("dis11").className = "nav_menu_bg";
			$("dis10").className = "";
			$("dis9").className = "";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
//			setAdervtise(2);
		}
		 else if (strUrl.indexOf("product") > 0) {//产品
	//		$("product").checked = true;
			$("dis12").className = "";
			$("dis11").className = "";
			$("dis10").className = "";
			$("dis9").className = "nav_menu_bg";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
		}
		else if (strUrl.indexOf("enterprise") > 0) {//企业
	//		$("customer").checked = true;
			$("dis12").className = "";
			$("dis11").className = "nav_menu_bg";
			$("dis10").className = "";
			$("dis9").className = "";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
	//		setAdervtise(3);
		}
		else if (strUrl.indexOf("disTest") > 0) {//评测
			$("dis12").className = "";
			$("dis11").className = "nav_menu_bg";
			$("dis10").className = "";
			$("dis9").className = "";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
		} 
		else if (strUrl.indexOf("market") > 0) {//建材市场
			
			$("dis12").className = "";
			$("dis11").className = "nav_menu_bg";
			$("dis10").className = "";
			$("dis9").className = "";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
		//	setAdervtise(4);
		}
	else if (strUrl.indexOf("news") > 0) {//建材中国
		 
			$("dis12").className = "";
			$("dis11").className = "nav_menu_bg";
			$("dis10").className = "";
			$("dis9").className = "";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
	//		setAdervtise(4);
		}  
		else if (strUrl.indexOf("school") > 0) {//学院
			$("dis12").className = "";
			$("dis11").className = "nav_menu_bg";
			$("dis10").className = "";
			$("dis9").className = "";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
		}
		else if (strUrl.indexOf("talents") > 0) {//人才
			$("dis12").className = "";
			$("dis11").className = "nav_menu_bg";
			$("dis10").className = "";
			$("dis9").className = "";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
		} 
		else if (strUrl.indexOf("bookStore") > 0) {//图书
			$("dis12").className = "";
			$("dis11").className = "nav_menu_bg";
			$("dis10").className = "";
			$("dis9").className = "";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
		}
		else if (strUrl.indexOf("markerPlace") > 0) {//行情
			$("dis12").className = "";
			$("dis11").className = "nav_menu_bg";
			$("dis10").className = "";
			$("dis9").className = "";
			$("dis8").className = "";
			$("dis7").className = "";
			$("dis6").className = "";
			$("dis5").className = "";
			$("dis4").className = "";
			$("dis3").className = "";
			$("dis2").className = "";
			$("dis1").className = "";
		//	setAdervtise(1);
		}
		else {			 
			$("top_dh0").className = "dh_50";
		}
	} else {		 
		$("top_dh0").className = "dh_50";		
	}
	welcome('welcome');
	loginOrLogoout('logoinOrOut');
	setAdervtise(0);
	getStockImage('img-1',1);
	getStockImage('img-2',2);
	getStockContent('stock-7');
	sendLeave( 'leaveWords' );
}

function loginOrLogoout( logoin_div )
{  
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(logoin_div,
			'/member/comm/logoinorout.jsp?data=' + data, {
				method : 'get',
				evalScripts : true
			});

}

function welcome( welcome_div )
{  
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(welcome_div,
			'/member/comm/welcome.jsp?data=' + data, {
				method : 'get',
				evalScripts : true
			});

}

// 调用广告信息
function setAdervtise(range) {
	ParamethodMgr.getAdvertiseNumber('109', range,function(number){
		for (var i = 1; i <= number; i++) {
		var adv = 'adv-' + i;
		if ($(adv) != null && $(adv) != 'undefined') {
			getAdvertiseContent(adv, range, i);
		}
	}
	});
}

// 取出广告内容
function getAdvertiseContent(adv_div, range, no) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(adv_div,
			'/member/comm/advertiseInfo.jsp?range=' + range + "&no=" + no
					+ "&data=" + data, {
				method : 'get',
				evalScripts : true
			});
}

function getStockImage(img_div,n) {
	 
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(img_div,
			'/member/comm/stockImage.jsp?n=' + n
					+ "&data=" + data, {
				method : 'get',
				evalScripts : true
			});
}

function getStockContent(title_div) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(title_div,
			'/member/comm/stockTitle.jsp?data=' + data, {
				method : 'get',
				evalScripts : true
			});
}
function sendLeave(title_div) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater(title_div,
			'/member/comm/leaveWords.jsp?data=' + data, {
				method : 'get',
				evalScripts : true
			});

}
