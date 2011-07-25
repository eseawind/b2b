//auditValidity.jsp
 function auditValiditycheck_Value(){
		 	if (document.resumeForm.audit_desc.value == ""||document.resumeForm.audit_desc.value == null)
			{
				alert("请选择审核意见！");
				document.resumeForm.audit_desc.focus(); 
				return false;
			}
			return true;
		  }

//		   modifyVerify.jsp
			function modifyVerifycheckValue(){
		    if(window.confirm("确定要提交所执行的操作？")){
		      return true;
		    }else{
		      return false;
		    }
		   }
		   
//validityList.jsp
		    function checkRaleType(type){
			    if(type!="0"){
			       document.relationForm.submit();
			    }
			  }
			  
//verify.jsp
	function verifyCheck_Value()
	    {
	    if($F("verify_type")=="" || $F("verify_type")==null)
		{
			alert("请请输入验证类型!!!");
			$("verify_type").focus();
			return false;
		}
		var verify_name=$F("verify_name");
		verify_name=delAllSpace(verify_name);
		if(verify_name=="" || verify_name==null)
		{
			alert("请输入证书名称!");
			$("verify_name").focus();
			return false;
		}
		var req_date=$F("req_date");
		if(req_date=="" || req_date==null)
		{
			alert("申请日期不能为空!");
			$("req_date").focus();
			return false;
		}
		return true;
	}
	 //删除所有空格
		 function delAllSpace(str) {
			return str.replace(/^\s+|\s+$/g, "")
		 }
		 
		 
//addBiddingInfo.jsp
function addBiddingInfoCheck_Value()

{
	if (cTrim(document.bidForm.title.value,0) == "" || document.bidForm.title.value == null) 
	{                                                                                         

		alert("招标标题不可以为空！");                                                             

		document.bidForm.title.focus();                                                    

		return false;                                                                            

	}                                                                                       

	if (cTrim(document.bidForm.bidding_no.value,0) == "" || document.bidForm.bidding_no.value == null) 

	{                                                                                         

		alert("标号不可以为空！");                                                             

		document.bidForm.bidding_no.focus();                                                    

		return false;                                                                            

	}                                                                                         

	if (cTrim(document.bidForm.open_date.value,0) == "" || document.bidForm.open_date.value == null) 

	{                                                                                         

		alert("开标时间不可以为空！");                                                             

		document.bidForm.open_date.focus();                                                    

		return false;                                                                            

	}                                                                                        

	if (cTrim(document.bidForm.addr.value,0) == "" || document.bidForm.addr.value == null) 

	{                                                                                         

		alert("招标地点不可以为空！");                                                             

		document.bidForm.addr.focus();                                                    

		return false;

	}                                                                                     

	if (content.getText()=="" || document.bidForm.content.value == null) 

	{

		alert("招标说明不可以为空！");

		document.bidForm.content.focus();

		return false;

	}

	if (cTrim(document.bidForm.phone.value,0) == "" || document.bidForm.phone.value == null) 

	{                                                                                         

		alert("联系电话不可以为空！");                                                             

		document.bidForm.phone.focus();                                                    

		return false;                                                                            

	}
				var re =/(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/;
  		if(re.test(document.getElementById("phone").value)){   
 
			}else{   
				 alert("联系电话格式不正确！"); 
				document.getElementById("phone").value='';
				document.getElementById("phone").focus();
				return false;
			}                                                                                    
    
	 return true;

}

function addBiddingInfocheck_none(current_obj)

{

    if (current_obj.advshow.checked)

    {

	    current_obj.submit1.disabled=false;        	     

	}

	else

	{

	    current_obj.submit1.disabled=true;

	}

}

function addBiddingInfoconfirmsub(formobj)

{

    if(window.confirm('你确定要提交吗？')) 

    {  	    	

        if (!addBiddingInfoCheck_Value())

        {

             return;

        }

        

     	 addBiddingInfoaddparm(formobj);

         formobj.submit();   	         

    }

    else

    {

        return;

    }

}

function  addBiddingInfoaddparm(formobj)

{

  if(formobj.str_attr)

  {

 		var attr_str="";

 		formobj.str_attr.value="";

for(var i=0;i<formobj.length;i++)

{

	if(formobj[i].getAttribute("name").substring(0,4)=="attr")

	{

 	  attr_str =attr_str + formobj[i].getAttribute("name").substring(4, formobj[i].getAttribute("name").length)+":";

 	  attr_str = attr_str +formobj[i].getAttribute("value")+"|";

	}

}

formobj.str_attr.value=attr_str;

}

}    		


//addIsBiddingInfo.jsp
function addIsBiddingInfoCheck_Value()
{
	if (hit_content.getText()=="" || document.bidForm.hit_content.value == null) 
	{                                                                                         
		alert("中标公告内容不可以为空！");                                                             
		document.bidForm.hit_content.focus();                                                    
		return false;                                                                            
	}                                                                                       
	if (document.bidForm.hit_custname.value== "" || document.bidForm.hit_custname.value == null) 
	{                                                                                         
		alert("中标单位名称不可以为空！");                                                             
		document.bidForm.hit_custname.focus();                                                    
		return false;                                                                            
	}                                                                                      
	 return true;
}
function addIsBiddingInfocheck_none(current_obj)
{
    if (current_obj.advshow.checked)
    {
	    current_obj.submit1.disabled=false;        	     
	}
	else
	{
	    current_obj.submit1.disabled=true;
	}
}
function addIsBiddingInfoconfirmsub(formobj)
{
    if(window.confirm('你确定要提交吗？')) 
    {  	    	
        if (!addIsBiddingInfoCheck_Value())
        {
             return;
        }
        
     	 addIsBiddingInfoaddparm(formobj);
         formobj.submit();   	         
    }
    else
    {
        return;
    }
}
function  addIsBiddingInfoaddparm(formobj)
{
  if(formobj.str_attr)
  {
 		var attr_str="";
 		formobj.str_attr.value="";
for(var i=0;i<formobj.length;i++)
{
	if(formobj[i].getAttribute("name").substring(0,4)=="attr")
	{
 	  attr_str =attr_str + formobj[i].getAttribute("name").substring(4, formobj[i].getAttribute("name").length)+":";
 	  attr_str = attr_str +formobj[i].getAttribute("value")+"|";
	}
}
formobj.str_attr.value=attr_str;
}
}
