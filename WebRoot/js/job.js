
// ���ó�����Ϣ
function setCityInfo(prov_id) {
	if (prov_id != "0") {
		AreaInfo.getAreaByParent(prov_id, function(data) {
			DWRUtil.removeAllOptions("city_l");
			var fectureArray = new Array();
			fectureArray = ['������Ϣ..'];
			DWRUtil.addOptions("city_l", fectureArray);
			DWRUtil.addOptions("city_l", data);
		});
	} else {
		DWRUtil.removeAllOptions("city_l");
		var fectureArray = new Array();
		fectureArray = ['������Ϣ..'];
		DWRUtil.addOptions("city_l", fectureArray);
	}
}

// ���ؼ���
function checkKey_Word() {
	var job_key = $F("job_key");
	job_key = delAllSpace(job_key);
	if (job_key == "" || job_key == null) {
		$("job_key").value = "������ؼ���";
	}
}

// ��ʼ����
function searchJob() {
	var province = DWRUtil.getText('prov_1');
	if (province == 'ʡ����Ϣ') {
		province = "";
	}
	var city = DWRUtil.getText('city_l');
	if (city == '������Ϣ..') {
		city = "";
	}
	var pub_job = DWRUtil.getValue('pub_job');
	var pub_date = $F('pub_date');
	var job_key = $F("job_key");
	if (job_key == '������ؼ���') {
		alert('������ؼ���');
		$('job_key').focus();
		return false;
	}
	window.open('/job/searchjobList.jsp?job_key='+job_key+'&pro='+province+'&city_1='+city+'&pub_job='+pub_job+'&pub_date='+pub_date);

}

/**
 * ɾ�����пո�
 */
function delAllSpace(str) {
	return str.replace(/^\s+|\s+$/g, "")
}



	// �����ڸǲ�
function popCoverDiv() {
	if (M("cover_div")) {
		// ��������ڸǲ㣬��������ʾ
		M("cover_div").style.display = 'block';
	} else {
		// ���򴴽��ڸǲ�
		var coverDiv = MC('div');
		document.body.appendChild(coverDiv);
		coverDiv.id = 'cover_div';
		with (coverDiv.style) {
			position = 'absolute';
			background = '#CCCCCC';
			left = '0px';
			top = '0px';
			var bodySize = getBodySize();
			width = bodySize[0] + 'px'
			height = bodySize[1] + 'px';
			zIndex = 0;
			if (isIE()) {
				filter = "Alpha(Opacity=60)";// IE�澳
			} else {
				opacity = 0.6;
			}
		}
	}
}

// �õ�½����ʾΪ��
function showLogin() {
	var login = M("login");
	login.style.display = "block";
}

// ����DIV�����ʽ
function change() {
	var login = M("login");
	login.style.position = "absolute";
	login.style.border = "1px solid #CCCCCC";
	login.style.background = "#F6F6F6";
	var i = 0;
	var bodySize = getBodySize();
	login.style.left = (bodySize[0] - i * i * 4) / 2 + "px";
	login.style.top = (bodySize[1] / 2 - 100 - i * i) + "px";
	login.style.width = i * i * 4 + "px";
	login.style.height = i * i * 1.5 + "px";

	popChange(i);
}
// ��DIV���Сѭ������
function popChange(i) {
	var login = M("login");
	var bodySize = getBodySize();
	login.style.left = (bodySize[0] - i * i * 4) / 2 + "px";
	login.style.top = (bodySize[1] / 2 - 100 - i * i) + "px";
	login.style.width = i * i * 4 + "px";
	login.style.height = i * i * 1.5 + "px";
	if (i <= 10) {
		i++;
		setTimeout("popChange(" + i + ")", 10);// ���ó�ʱ10����
	}
}
// ��DIV��
function openWindow() {
	change();
	showLogin();
	popCoverDiv()
	void(0);
}
// �ر�DIV��
function close() {
	M('login').style.display = 'none';
	M("cover_div").style.display = 'none';
	void(0);
}
/**
*����id�õ�����
**/
function M(id) {
	return document.getElementById(id);// ��M()��������document.getElementById(id)
}
/**
* ȡ��ҳ��ĸ߿�
**/
function getBodySize() {
	var bodySize = [];
	with (document.documentElement) {
		bodySize[0] = (scrollWidth > clientWidth) ? scrollWidth : clientWidth;// ����������Ŀ�ȴ���ҳ��Ŀ�ȣ�ȡ�ù������Ŀ�ȣ�����ȡҳ����
		bodySize[1] = (scrollHeight > clientHeight)
				? scrollHeight
				: clientHeight;// ����������ĸ߶ȴ���ҳ��ĸ߶ȣ�ȡ�ù������ĸ߶ȣ�����ȡ�߶�
	}
	return bodySize;
}
/**
*��������
**/
function MC(t) {
	return document.createElement(t);// ��MC()��������document.createElement(t)
};

/**
* �ж�������Ƿ�ΪIE
**/
function isIE() {
	return (document.all && window.ActiveXObject && !window.opera)
			? true
			: false;
}