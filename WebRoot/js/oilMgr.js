//index.jsp
		 function indexconfirmsub(){
		     if( document.getElementById("commerce_name").value=="" || document.getElementById("commerce_name").value==null){
		       alert("����д�г����ƣ�");
		       document.getElementById("commerce_name").focus();
		       return false;
		     }
		     if( document.getElementById("get_date").value=="" || document.getElementById("get_date").value==null){
		       alert("��ѡ��ɼ�ʱ�䣡");
		       document.getElementById("get_date").focus();
		       return false;
		     }
		     if( document.getElementById("last_price").value=="" || document.getElementById("last_price").value==null){
		       alert("����д���¼۸�");
		       document.getElementById("last_price").focus();
		       return false;
		     }
		     if( document.getElementById("ud_type").value =="" || document.getElementById("ud_type").value==null){
		       alert("��ѡ�񸡶����ͣ�");
		       document.getElementById("ud_type").focus();
		       return false;
		     }
		     if( document.getElementById("ud_price").value=="" || document.getElementById("ud_price").value==null){
		       alert("����д�����۸�");
		        document.getElementById("ud_price").focus();
		       return false;
		     }
		     return true;
		 }		
//modifyoil.jsp
		  function modifyoilconfirmsub(){
		     if( document.getElementById("commerce_name").value=="" || document.getElementById("commerce_name").value==null){
		       alert("����д�г����ƣ�");
		       document.getElementById("commerce_name").focus();
		       return false;
		     }
		     if( document.getElementById("get_date").value=="" || document.getElementById("get_date").value==null){
		       alert("��ѡ��ɼ�ʱ�䣡");
		       document.getElementById("get_date").focus();
		       return false;
		     }
		     if( document.getElementById("last_price").value=="" || document.getElementById("last_price").value==null){
		       alert("����д���¼۸�");
		       document.getElementById("last_price").focus();
		       return false;
		     }
		     if( document.getElementById("ud_type").value =="" || document.getElementById("ud_type").value==null){
		       alert("��ѡ�񸡶����ͣ�");
		       document.getElementById("ud_type").focus();
		       return false;
		     }
		     if( document.getElementById("ud_price").value=="" || document.getElementById("ud_price").value==null){
		       alert("����д�����۸�");
		        document.getElementById("ud_price").focus();
		       return false;
		     }
		     return true;
		 }
		 
// modifypoint.jsp

		 function modifypointconfirmsub(){
		      if( document.getElementById("point_name").value=="" || document.getElementById("point_name").value==null){
		       alert("����дָ�����ƣ�");
		       document.getElementById("point_name").focus();
		       return false;
		     }
		     if( document.getElementById("start_date").value=="" || document.getElementById("start_date").value==null){
		       alert("��ѡ��ʼʱ�䣡");
		       document.getElementById("start_date").focus();
		       return false;
		     }
		     if( document.getElementById("end_date").value=="" || document.getElementById("end_date").value==null){
		       alert("��ѡ�����ʱ�䣡");
		       document.getElementById("end_date").focus();
		       return false;
		     }
		     if( document.getElementById("ud_num").value=="" || document.getElementById("ud_num").value==null){
		       alert("����д��ǰֵ��");
		       document.getElementById("ud_num").focus();
		       return false;
		     }
		     if( document.getElementById("ud_type").value =="" || document.getElementById("ud_type").value==null){
		       alert("��ѡ�񸡶����ͣ�");
		       document.getElementById("ud_type").focus();
		       return false;
		     }
		     if( document.getElementById("ud_num").value=="" || document.getElementById("ud_num").value==null){
		       alert("����д������ֵ��");
		        document.getElementById("ud_num").focus();
		       return false;
		     }
		     return true;
		 }
		 
//  oilListchechIfo.jsp
function oilListchechIfo()
  {
	   if(confirm('�Ƿ�ȷ��ע��������¼��')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }
  
  //point.jsp
  		 function pointconfirmsub(){
		     if( document.getElementById("point_name").value=="" || document.getElementById("point_name").value==null){
		       alert("����дָ�����ƣ�");
		       document.getElementById("point_name").focus();
		       return false;
		     }
		     if( document.getElementById("start_date").value=="" || document.getElementById("start_date").value==null){
		       alert("��ѡ��ʼʱ�䣡");
		       document.getElementById("start_date").focus();
		       return false;
		     }
		     if( document.getElementById("end_date").value=="" || document.getElementById("end_date").value==null){
		       alert("��ѡ�����ʱ�䣡");
		       document.getElementById("end_date").focus();
		       return false;
		     }
		     if( document.getElementById("ud_num").value=="" || document.getElementById("ud_num").value==null){
		       alert("����д��ǰֵ��");
		       document.getElementById("ud_num").focus();
		       return false;
		     }
		     if( document.getElementById("ud_type").value =="" || document.getElementById("ud_type").value==null){
		       alert("��ѡ�񸡶����ͣ�");
		       document.getElementById("ud_type").focus();
		       return false;
		     }
		     if( document.getElementById("ud_num").value=="" || document.getElementById("ud_num").value==null){
		       alert("����д������ֵ��");
		        document.getElementById("ud_num").focus();
		       return false;
		     }
		     return true;
		 }
		 
//pointList.jsp
  function pointListchechIfo()
  {
	   if(confirm('�Ƿ�ȷ��ע��������¼��')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }