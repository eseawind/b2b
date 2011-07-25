	 function check_Value(){
		   var para_code6=$F("para_code6");
		   para_code6=delAllSpace(para_code6);
		   if(para_code6 =="" || para_code6==null){
		    alert("请填选择员动作！");
		    $("para_code6").focus();
		    return false;
		   }
		   $("para_code2").value=DWRUtil.getText("para_code6");
		   var para_code4=$F("para_code4");
		   para_code4=delAllSpace(para_code4);
		   if(para_code4=="" || para_code4==null){
		    alert("请选择会员级别！");
		    $("para_code4").focus();
		    return false;
		   }
		   $("para_code5").value=DWRUtil.getText("para_code4");
		   var para_code3=$F("para_code3");
		   para_code3=delAllSpace(para_code3);
		   if(para_code3 =="" || para_code3==null){
		    alert("请输入奖励黄金数量！");
		    $("para_code3").focus();
		    return false;
		   }
		   
		   var start_date=$F("start_date");
		   start_date=delAllSpace(start_date);
		   if(start_date =="" || start_date==null){
		    alert("开始时间不能为空！");
		    $("start_date").focus();
		    return false;
		   }
		   
		   var end_date=$F("end_date");
		   end_date=delAllSpace(end_date);
		   if(end_date =="" || end_date==null){
		    alert("结束时间不能为空！");
		    $("end_date").focus();
		    return false;
		   }
		     //////////////////判断时间是否合理////////////////
		   if(!checkDate(start_date,end_date)){
		     return false;
		   }
		   ///////////////////////////////////////////////
		   return true;
		 }
		 //删除所有空格
		 function delAllSpace(str) {
			return str.replace(/^\s+|\s+$/g, "")
		 }
		 
		 	function chechIfo()
		  {
			   if(confirm('是否确认删除本条记录？')) 
			{
				return true;
			}
			else
			{
				return false;
			}
		  }