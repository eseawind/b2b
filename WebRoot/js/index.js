
/**
 * ��ҳjs
 */

// ȫ������
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
		alert("��������ȷ�Ĺؼ��֣�");
		$("s_key").focus();
	} else {
		window.open("/search/searchListpage.jsp?p=0&info_type=" + info_type + "&key="
				+ s_key);
		
	}
}

// �ؼ��ּ���
function checkKeyWord(key) {
	var keyWord = delAllSpace(key);
	if (keyWord == "" || keyWord == null) {
		$(s_key).value = "������ؼ��֣�";
	}
}
/**
 * ɾ�����пո�
 */
function delAllSpace(str) {
	return str.replace(/^\s+|\s+$/g, "")
}

// ȡ����ǰʱ�估����
function getDate() {
	var now = new Date(); // ��ȡϵͳ����
	var yy = now.getYear(); // ��ȡ��
	var mm = now.getMonth() + 1; // ��ȡ��
	var week = getWeek(now.getDay()); // ��ȡ���������ֵ
	var dd = now.getDate();
	var date_time = yy + "-" + mm + "-" + dd + " " + week;
	return date_time;
}
function getWeek(week) {
	var weekDay = "";
	if (week == "0") {
		weekDay = "������";
	} else if (week == "1") {
		weekDay = "����һ";
	} else if (week == "2") {
		weekDay = "���ڶ�";
	} else if (week == "3") {
		weekDay = "������";
	} else if (week == "4") {
		weekDay = "������";
	} else if (week == "5") {
		weekDay = "������";
	} else {
		weekDay = "������";
	}
	return weekDay;
}

// �Զ����ؽű�

window.onload = function() {
	$("date-time").innerHTML = getDate();
//	Shadowbox.init();
	var strUrl = top.location.href;
	if (strUrl != null && strUrl != "") {	
		if (strUrl.indexOf("supply") > 0) {//��Ӧ
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
		}else if (strUrl.indexOf("stock") > 0) {//��
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
		 else if (strUrl.indexOf("product") > 0) {//��Ʒ
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
		else if (strUrl.indexOf("enterprise") > 0) {//��ҵ
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
		else if (strUrl.indexOf("disTest") > 0) {//����
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
		else if (strUrl.indexOf("market") > 0) {//�����г�
			
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
	else if (strUrl.indexOf("news") > 0) {//�����й�
		 
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
		else if (strUrl.indexOf("school") > 0) {//ѧԺ
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
		else if (strUrl.indexOf("talents") > 0) {//�˲�
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
		else if (strUrl.indexOf("bookStore") > 0) {//ͼ��
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
		else if (strUrl.indexOf("markerPlace") > 0) {//����
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

// ���ù����Ϣ
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

// ȡ���������
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
