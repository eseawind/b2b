//index.jsp
		 function indexconfirmsub(){
		     if( document.getElementById("commerce_name").value=="" || document.getElementById("commerce_name").value==null){
		       alert("请填写市场名称！");
		       document.getElementById("commerce_name").focus();
		       return false;
		     }
		     if( document.getElementById("get_date").value=="" || document.getElementById("get_date").value==null){
		       alert("请选择采集时间！");
		       document.getElementById("get_date").focus();
		       return false;
		     }
		     if( document.getElementById("last_price").value=="" || document.getElementById("last_price").value==null){
		       alert("请填写最新价格！");
		       document.getElementById("last_price").focus();
		       return false;
		     }
		     if( document.getElementById("ud_type").value =="" || document.getElementById("ud_type").value==null){
		       alert("请选择浮动类型！");
		       document.getElementById("ud_type").focus();
		       return false;
		     }
		     if( document.getElementById("ud_price").value=="" || document.getElementById("ud_price").value==null){
		       alert("请填写浮动价格！");
		        document.getElementById("ud_price").focus();
		       return false;
		     }
		     return true;
		 }		
//modifyoil.jsp
		  function modifyoilconfirmsub(){
		     if( document.getElementById("commerce_name").value=="" || document.getElementById("commerce_name").value==null){
		       alert("请填写市场名称！");
		       document.getElementById("commerce_name").focus();
		       return false;
		     }
		     if( document.getElementById("get_date").value=="" || document.getElementById("get_date").value==null){
		       alert("请选择采集时间！");
		       document.getElementById("get_date").focus();
		       return false;
		     }
		     if( document.getElementById("last_price").value=="" || document.getElementById("last_price").value==null){
		       alert("请填写最新价格！");
		       document.getElementById("last_price").focus();
		       return false;
		     }
		     if( document.getElementById("ud_type").value =="" || document.getElementById("ud_type").value==null){
		       alert("请选择浮动类型！");
		       document.getElementById("ud_type").focus();
		       return false;
		     }
		     if( document.getElementById("ud_price").value=="" || document.getElementById("ud_price").value==null){
		       alert("请填写浮动价格！");
		        document.getElementById("ud_price").focus();
		       return false;
		     }
		     return true;
		 }
		 
// modifypoint.jsp

		 function modifypointconfirmsub(){
		      if( document.getElementById("point_name").value=="" || document.getElementById("point_name").value==null){
		       alert("请填写指数名称！");
		       document.getElementById("point_name").focus();
		       return false;
		     }
		     if( document.getElementById("start_date").value=="" || document.getElementById("start_date").value==null){
		       alert("请选择开始时间！");
		       document.getElementById("start_date").focus();
		       return false;
		     }
		     if( document.getElementById("end_date").value=="" || document.getElementById("end_date").value==null){
		       alert("请选择结束时间！");
		       document.getElementById("end_date").focus();
		       return false;
		     }
		     if( document.getElementById("ud_num").value=="" || document.getElementById("ud_num").value==null){
		       alert("请填写当前值！");
		       document.getElementById("ud_num").focus();
		       return false;
		     }
		     if( document.getElementById("ud_type").value =="" || document.getElementById("ud_type").value==null){
		       alert("请选择浮动类型！");
		       document.getElementById("ud_type").focus();
		       return false;
		     }
		     if( document.getElementById("ud_num").value=="" || document.getElementById("ud_num").value==null){
		       alert("请填写浮动差值！");
		        document.getElementById("ud_num").focus();
		       return false;
		     }
		     return true;
		 }
		 
//  oilListchechIfo.jsp
function oilListchechIfo()
  {
	   if(confirm('是否确认注销本条记录？')) 
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
		       alert("请填写指数名称！");
		       document.getElementById("point_name").focus();
		       return false;
		     }
		     if( document.getElementById("start_date").value=="" || document.getElementById("start_date").value==null){
		       alert("请选择开始时间！");
		       document.getElementById("start_date").focus();
		       return false;
		     }
		     if( document.getElementById("end_date").value=="" || document.getElementById("end_date").value==null){
		       alert("请选择结束时间！");
		       document.getElementById("end_date").focus();
		       return false;
		     }
		     if( document.getElementById("ud_num").value=="" || document.getElementById("ud_num").value==null){
		       alert("请填写当前值！");
		       document.getElementById("ud_num").focus();
		       return false;
		     }
		     if( document.getElementById("ud_type").value =="" || document.getElementById("ud_type").value==null){
		       alert("请选择浮动类型！");
		       document.getElementById("ud_type").focus();
		       return false;
		     }
		     if( document.getElementById("ud_num").value=="" || document.getElementById("ud_num").value==null){
		       alert("请填写浮动差值！");
		        document.getElementById("ud_num").focus();
		       return false;
		     }
		     return true;
		 }
		 
//pointList.jsp
  function pointListchechIfo()
  {
	   if(confirm('是否确认注销本条记录？')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }