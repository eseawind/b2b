//answer.jsp
		function answerchick(){
			if (document.getElementById('content').value == '' || document.getElementById('content').value == null){
				alert ('����д�ظ�!');
				return false;
			}
			document.answerform.submit();
		}
		
// �����ؼ���
function searchEnterprise() {
	var cust_name = $F('ent_name');
	cust_name = delAllSpace(cust_name);
	if (cust_name == '' || cust_name == null) {
		alert('��������ҵ����');
		return false;
	} else if (cust_name == '��������ҵ����') {
		alert('��������ҵ����');
		return false;
	}
	var province = DWRUtil.getValue('prov_1');
	var eparchy_code = DWRUtil.getValue('city_l');
	var part = DWRUtil.getValue('part');
	if (province == 'ȫʡ��Ϣ') {
		province = '';
	}
	if (eparchy_code == '������Ϣ..') {
		eparchy_code = '';
	}
	window.open("/enterprise/searchEnterprise.jsp?enterprise=1&province="+province+"&city="+eparchy_code+"&cust_name="+cust_name+"&group="+part);
}

//changeOrderState.jsp
			function changeOrderStatechick(){
				document.payform.submit();
			}
			
//enquiry.jsp
	   //��ֵ�ж�
	    function enquiryCheck_Value(){
	       if(document.getElementById("keyword").value ==null || document.getElementById("keyword").value ==""){
	        alert("����д��ȷ����Ʒ��������Ӱ���ѯ�����");
	        return false;
	       }
	       document.orderform.submit();
	    }
	    
// modiOrderMoney.jsp
			function modiOrderMoneychick(){
				if (document.getElementById('carriage_pay').value == '' || document.getElementById('carriage_pay').value == null){
					alert('����д�˷�!');
					return false;
				}
				document.payform.submit();
			}
			
//otherTotalOrder.jsp
	   //��ֵ�ж�
	    function otherTotalOrderCheck_Value(){
	       if(document.getElementById("start_date").value ==null || document.getElementById("start_date").value ==""){
	        alert("��ѡ��ʼʱ�䣡");
	        return false;
	       }
	       if(document.getElementById("end_date").value ==null || document.getElementById("end_date").value ==""){
	        alert("��ѡ�����ʱ�䣡");
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
