
// 设置城市信息
function setCityInfo(prov_id) {
	if (prov_id != "0") {
		AreaInfo.getAreaByParent(prov_id, function(data) {
			DWRUtil.removeAllOptions("city_l");
			var fectureArray = new Array();
			fectureArray = ['地市信息..'];
			DWRUtil.addOptions("city_l", fectureArray);
			DWRUtil.addOptions("city_l", data);
		});
	} else {
		DWRUtil.removeAllOptions("city_l");
		var fectureArray = new Array();
		fectureArray = ['地市信息..'];
		DWRUtil.addOptions("city_l", fectureArray);
	}
}

// 检测关键字
function checkKey_Word() {
	var job_key = $F("job_key");
	job_key = delAllSpace(job_key);
	if (job_key == "" || job_key == null) {
		$("job_key").value = "请输入关键字";
	}
}

// 开始搜索
function searchJob() {
	var province = DWRUtil.getText('prov_1');
	if (province == '省份信息') {
		province = "";
	}
	var city = DWRUtil.getText('city_l');
	if (city == '地市信息..') {
		city = "";
	}
	var pub_job = DWRUtil.getValue('pub_job');
	var pub_date = $F('pub_date');
	var job_key = $F("job_key");
	if (job_key == '请输入关键字') {
		alert('请输入关键字');
		$('job_key').focus();
		return false;
	}
	window.open('/job/searchjobList.jsp?job_key='+job_key+'&pro='+province+'&city_1='+city+'&pub_job='+pub_job+'&pub_date='+pub_date);

}

/**
 * 删除所有空格
 */
function delAllSpace(str) {
	return str.replace(/^\s+|\s+$/g, "")
}



	// 创建遮盖层
function popCoverDiv() {
	if (M("cover_div")) {
		// 如果存在遮盖层，则让其显示
		M("cover_div").style.display = 'block';
	} else {
		// 否则创建遮盖层
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
				filter = "Alpha(Opacity=60)";// IE逆境
			} else {
				opacity = 0.6;
			}
		}
	}
}

// 让登陆层显示为块
function showLogin() {
	var login = M("login");
	login.style.display = "block";
}

// 设置DIV层的样式
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
// 让DIV层大小循环增大
function popChange(i) {
	var login = M("login");
	var bodySize = getBodySize();
	login.style.left = (bodySize[0] - i * i * 4) / 2 + "px";
	login.style.top = (bodySize[1] / 2 - 100 - i * i) + "px";
	login.style.width = i * i * 4 + "px";
	login.style.height = i * i * 1.5 + "px";
	if (i <= 10) {
		i++;
		setTimeout("popChange(" + i + ")", 10);// 设置超时10毫秒
	}
}
// 打开DIV层
function openWindow() {
	change();
	showLogin();
	popCoverDiv()
	void(0);
}
// 关闭DIV层
function close() {
	M('login').style.display = 'none';
	M("cover_div").style.display = 'none';
	void(0);
}
/**
*根据id得到属性
**/
function M(id) {
	return document.getElementById(id);// 用M()方法代替document.getElementById(id)
}
/**
* 取得页面的高宽
**/
function getBodySize() {
	var bodySize = [];
	with (document.documentElement) {
		bodySize[0] = (scrollWidth > clientWidth) ? scrollWidth : clientWidth;// 如果滚动条的宽度大于页面的宽度，取得滚动条的宽度，否则取页面宽度
		bodySize[1] = (scrollHeight > clientHeight)
				? scrollHeight
				: clientHeight;// 如果滚动条的高度大于页面的高度，取得滚动条的高度，否则取高度
	}
	return bodySize;
}
/**
*创建对象
**/
function MC(t) {
	return document.createElement(t);// 用MC()方法代替document.createElement(t)
};

/**
* 判断浏览器是否为IE
**/
function isIE() {
	return (document.all && window.ActiveXObject && !window.opera)
			? true
			: false;
}