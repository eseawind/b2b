	 function check_Value(){
		   var para_code6=$F("para_code6");
		   para_code6=delAllSpace(para_code6);
		   if(para_code6 =="" || para_code6==null){
		    alert("����ѡ��Ա������");
		    $("para_code6").focus();
		    return false;
		   }
		   $("para_code2").value=DWRUtil.getText("para_code6");
		   var para_code4=$F("para_code4");
		   para_code4=delAllSpace(para_code4);
		   if(para_code4=="" || para_code4==null){
		    alert("��ѡ���Ա����");
		    $("para_code4").focus();
		    return false;
		   }
		   $("para_code5").value=DWRUtil.getText("para_code4");
		   var para_code3=$F("para_code3");
		   para_code3=delAllSpace(para_code3);
		   if(para_code3 =="" || para_code3==null){
		    alert("�����뽱���ƽ�������");
		    $("para_code3").focus();
		    return false;
		   }
		   
		   var start_date=$F("start_date");
		   start_date=delAllSpace(start_date);
		   if(start_date =="" || start_date==null){
		    alert("��ʼʱ�䲻��Ϊ�գ�");
		    $("start_date").focus();
		    return false;
		   }
		   
		   var end_date=$F("end_date");
		   end_date=delAllSpace(end_date);
		   if(end_date =="" || end_date==null){
		    alert("����ʱ�䲻��Ϊ�գ�");
		    $("end_date").focus();
		    return false;
		   }
		     //////////////////�ж�ʱ���Ƿ����////////////////
		   if(!checkDate(start_date,end_date)){
		     return false;
		   }
		   ///////////////////////////////////////////////
		   return true;
		 }
		 //ɾ�����пո�
		 function delAllSpace(str) {
			return str.replace(/^\s+|\s+$/g, "")
		 }
		 
		 	function chechIfo()
		  {
			   if(confirm('�Ƿ�ȷ��ɾ��������¼��')) 
			{
				return true;
			}
			else
			{
				return false;
			}
		  }