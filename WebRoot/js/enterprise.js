//answer.jsp
		function answerchick(){
			if (document.getElementById('content').value == '' || document.getElementById('content').value == null){
				alert ('请填写回复!');
				return false;
			}
			document.answerform.submit();
		}
		
// 搜索关键字
function searchEnterprise() {
	var cust_name = $F('ent_name');
	cust_name = delAllSpace(cust_name);
	if (cust_name == '' || cust_name == null) {
		alert('请输入企业名称');
		return false;
	} else if (cust_name == '请输入企业名称') {
		alert('请输入企业名称');
		return false;
	}
	var province = DWRUtil.getValue('prov_1');
	var eparchy_code = DWRUtil.getValue('city_l');
	var part = DWRUtil.getValue('part');
	if (province == '全省信息') {
		province = '';
	}
	if (eparchy_code == '地市信息..') {
		eparchy_code = '';
	}
	window.open("/enterprise/searchEnterprise.jsp?enterprise=1&province="+province+"&city="+eparchy_code+"&cust_name="+cust_name+"&group="+part);
}

//changeOrderState.jsp
			function changeOrderStatechick(){
				document.payform.submit();
			}
			
//enquiry.jsp
	   //空值判断
	    function enquiryCheck_Value(){
	       if(document.getElementById("keyword").value ==null || document.getElementById("keyword").value ==""){
	        alert("请填写正确的商品名，否则影响查询结果！");
	        return false;
	       }
	       document.orderform.submit();
	    }
	    
// modiOrderMoney.jsp
			function modiOrderMoneychick(){
				if (document.getElementById('carriage_pay').value == '' || document.getElementById('carriage_pay').value == null){
					alert('请填写运费!');
					return false;
				}
				document.payform.submit();
			}
			
//otherTotalOrder.jsp
	   //空值判断
	    function otherTotalOrderCheck_Value(){
	       if(document.getElementById("start_date").value ==null || document.getElementById("start_date").value ==""){
	        alert("请选择开始时间！");
	        return false;
	       }
	       if(document.getElementById("end_date").value ==null || document.getElementById("end_date").value ==""){
	        alert("请选择结束时间！");
	        return false;
	       }
	       document.orderform.submit();
	    }
	    
//viewsaleinfo1.jsp
    function viewsaleinfo1Check_Value()
	{
 	    return true;
	}
	
//watchUserOrder.jsp
	 function watchUserOrderCheck_Key(){
	 	document.orderform1.submit();
	}
