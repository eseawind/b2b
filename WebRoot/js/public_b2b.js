
/** **************************************************************
 * 
 *  以下javascript代码为B2B平台所用到的公用方法
 *  用户可以在本文件中加自己的方法
 *  
 * ****************************************************************/
/**
 * 删除所有空格
 */
function delAllSpace(str) {
	return str.replace(/^\s+|\s+$/g, "")
}
/**
 * 删除左边空格
 */
function delLeftSpace(str) {
	return str.replace(/^\s+/g, "")
}
/**
 * 删除右边空格
 */
function delRightSpace(str) {
	return str.replace(/\s+$/g, "")
}

/**
 * @startDay 开始时间
 * @endDay 结束时间
 * @判断开始时间是否小于结束时间
 */
function checkDate(startDay, endDay) {
	var startD1 = startDay + "   " + "00:00";
	var endD1 = endDay + "   " + "23:59";
	var n1 = new Date(startD1.replace(/-/g, "/"));
	var n2 = new Date(endD1.replace(/-/g, "/"));
	var n = n2.getTime() - n1.getTime();
	if (startDay == "" || endDay == "") {
		alert("请选择完整的开始时和结束时间!");
		return false;
	}
	if (n <= 0) {
		alert("开始日期必须大于结束日期，请重新选择！");
		return false;
	}
	return true;
}

//设置城市信息
function setXcityInfo(prov_id) {
	if (prov_id != "0") {
		AreaInfo.getAreaByParent(prov_id, function(data) {
			DWRUtil.removeAllOptions("x_city");
			DWRUtil.addOptions("x_city", fectureArray);
			DWRUtil.addOptions("x_city", data);
		});
	} else {
		DWRUtil.removeAllOptions("x_city");
		var fectureArray = new Array();
		fectureArray = ['请选择..'];
		DWRUtil.addOptions("x_city", fectureArray);
	}
}