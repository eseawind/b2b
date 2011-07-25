
/***
 *软件在线组装
 *@B2B软件平台
 */

//选择服务

function selectServer(sys_code){
	$("menu_id").value="0";
	$("sub_code").value=sys_code;
	var cust_class=$F("cust_class");
	if(cust_class!="s"){
	    var data = Math.round(Math.random() * 10000);
	    var myAjax = new Ajax.Updater('send-tree', 
			'send_menu.jsp?sub_code=' + sys_code + "&cust_class="+cust_class+"&data=" + data,
			{
				method : 'get',
				evalScripts: true
			});
	}
}

//未分配菜单
function creatTree(cust_class) {
	$("menu_id").value="0";
	var sub_code=$F("sub_code");
	if(sub_code=="" || sub_code==null){
		alert("请选择服务名称！");
		return;
	}
	if(cust_class!="s"){
	    var data = Math.round(Math.random() * 10000);
	    var myAjax = new Ajax.Updater('send-tree', 
			'send_menu.jsp?sub_code=' + sub_code + "&cust_class="+cust_class+"&data=" + data,
			{
				method : 'get',
				evalScripts: true
			});
	}else{
	  alert("请选择客户级别!");
	  return;
	}
}
/***
 * 保存数据
 */
function checkvalue(){
	var sub_code=$F("sub_code");
	if(sub_code=="" || sub_code==null){
		alert("请选择服务名称！");
		return false;
	}
	var cust_class=$F("cust_class");
	if(cust_class=="" || cust_class==null){
		alert("请选择客户级别！");
		return false;
	}
	var start_date=$F("start_date");
	if(start_date=="" || start_date==null){
		alert("开始时间不能为空！");
		return false;
	}
	var end_date=$F("end_date");
	if(end_date=="" || end_date==null){
		alert("结束时间不能为空！");
		return false;
	}
	if(!checkDate(start_date, end_date)){
		return false;
	}
	var menu_id=$F("menu_id");
	if(menu_id=="0"){
		alert("你没有进行任何操作，不需要提交数据！");
		return false;
	}
	return true;
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
 //删除所有空格
 function delAllSpace(str) {
	return str.replace(/^\s+|\s+$/g, "")
 }
