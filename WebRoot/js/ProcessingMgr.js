//modifyProcessInfo.jsp
function modifyProcessInfocheckInfo()
{
	  if(document.getElementById("title").value.replace(/\s*/g,"")=="" || document.getElementById("title").value.replace(/\s*/g,"")==null)
				{
					alert("���ⲻ��Ϊ��!!!");
					return false;
				}
		document.getElementById("category_title").value=document.getElementById("title").value;
				if (document.classForm.sort1.value == "" ||document.classForm.sort1.value.length<1)
	{
		alert("��ѡ���Ʒ���࣡");
		return false;
	} 
		var str=category_abstract.getText();
		str=str.replace(/\s*/g,""); 
		if(str == ""  )
		{
			alert("����д�����Ʒ�Ľ��ܣ�");
			return false;
		} 
	
	var str=category_desc.getText();
		str=str.replace(/\s*/g,""); 
		if(str == ""  )
		{
			alert("����д������Ϣ��������");
			return false;
		} 
	
     if(document.getElementById("start_date").value.replace(/\s*/g,"")=="" || document.getElementById("start_date").value.replace(/\s*/g,"")==null)
	 {
		alert("��ʼ���ڲ���Ϊ��!!!");
		return false;
	 }
	 if(document.getElementById("end_date").value.replace(/\s*/g,"")=="" || document.getElementById("end_date").value.replace(/\s*/g,"")==null)
	 {
		alert("�������ڲ���Ϊ��!!!");
		return false;
	} 
	  //////////////////�ж�ʱ���Ƿ����////////////////
	 
     ///////////////////////////////////////////////  
		if(!checkDate(document.classForm.start_date.value,document.classForm.end_date.value)){
		     return false;
		}
}
function   isNum(str)
{   
  return   (str.search(/^\d+(\.\d+)?$/)!=-1);   
}   
//����һ������
	function setOneClass()
	{
		Productclass.getProductClassByUpId("000000000000000","4",setSort1);
	}
	function setSort1(map_data)
	{
		DWRUtil.removeAllOptions("sort1");
		DWRUtil.addOptions("sort1",map_data);
		document.getElementById("sort2").style.display="none";
		document.getElementById("sort3").style.display="none"; 
		document.getElementById("nextElement").style.display="none"; 
	}
	//���ö�������
	function setSecondClass(val)
	{
		var up_class_id=val;
		var type="4";
		document.getElementById("rsrv_str1").value="1";
		Productclass.getProductClassByUpId(up_class_id,type,setSort2);
	}
	function setSort2(map_data)
	{
		DWRUtil.removeAllOptions("sort2");
		DWRUtil.addOptions("sort2",map_data);
		document.getElementById("sort3").style.display="none";
		document.getElementById("nextElement").style.display="none"; 
		 var item=document.getElementById("sort2").length;
	     if(item==0)
	    {
	    	document.getElementById("sort2").style.display="none";
	    }
	    else
	    	{
	    		document.getElementById("sort2").style.display="block";
	    	}
	}
	//������������
	function setTherdClass(val)
	{
		var up_class_id=val;
		var type="4";
		document.getElementById("rsrv_str1").value="2";
		Productclass.getProductClassByUpId(up_class_id,type,setSort3);
	}
	function setSort3(map_data)
	{
		if(map_data!=null)
		{
			 DWRUtil.removeAllOptions("sort3");
		     DWRUtil.addOptions("sort3",map_data);
		     var item=document.getElementById("sort3").length;
		     if(item==0)
		     {
		    	document.getElementById("sort3").style.display="none";
		    	document.getElementById("nextElement").style.display="none"; 
		     }
		     else
	     	 {
	     		document.getElementById("sort3").style.display="block";
	     	 }
		}
	}
	function setTypeName(obj)
	{
		var idx=obj.value;
		document.getElementById("class_id").value=idx;
		document.getElementById("class_name").value=DWRUtil.getText(obj.name);
		document.getElementById("count").value=obj.name;
	}
	 //��̬�����¼�������Ϣ
	function cretateSelect(index,value)
	{
	    document.getElementById("nextElement").style.display="block";
	    var type="4";
	 	document.getElementById("rsrv_str1").value="3";
	 	var divId=parseInt(index)+parseInt(1);
	 	document.getElementById("index_s").value=index;
	 	document.getElementById(index).innerHTML="<select name=sort"+index+" id=sort"+index+" onchange=cretateSelect("+divId+",this.value) size=3  style=width:130px></select><div id="+divId+"></div>";
	 	DWRUtil.removeAllOptions("sort"+index);
	 	Productclass.getProductClassByUpId(value,type,setNewSelect);
    }
    //�ص�����
     function setNewSelect(map_data){
      var id=document.getElementById("index_s").value;
      DWRUtil.addOptions("sort"+id,map_data);
        var item=document.getElementById("sort"+id).length;
	    if(item==0)
	    {
	    	document.getElementById(id).style.display="none"; 
	    }
	     else
	   	{
	   		document.getElementById(id).style.display="block";
	   	}
    }


//addProcess.jsp
function addProcesscheckInfo()
{
	  if(document.getElementById("category_title").value.replace(/\s*/g,"")=="" || document.getElementById("category_title").value.replace(/\s*/g,"")==null)
				{
					alert("���ⲻ��Ϊ��!!!");
					document.getElementById("category_title").focus();
					return false;
				}
		if (document.classForm.sort1.value == "" ||document.classForm.sort1.value.length<1)
		{
			alert("��ѡ���Ʒ���࣡");
			document.classForm.sort1.focus(); 
			return false;
		} 
		var str=category_abstract.getText();
		str=str.replace(/\s*/g,""); 
		if(str == ""  )
		{
			alert("����д�����Ʒ�Ľ��ܣ�");
			return false;
		} 
	
	var str=category_desc.getText();
		str=str.replace(/\s*/g,""); 
		if(str == ""  )
		{
			alert("����д������Ϣ��������");
			return false;
		} 
	
      if(document.getElementById("start_date").value.replace(/\s*/g,"")=="" || document.getElementById("start_date").value.replace(/\s*/g,"")==null)
				{
					alert("��ʼ���ڲ���Ϊ��!!!");
					document.getElementById("start_date").focus();
					return false;
				}
			  if(document.getElementById("end_date").value.replace(/\s*/g,"")=="" || document.getElementById("end_date").value.replace(/\s*/g,"")==null)
				{
					alert("�������ڲ���Ϊ��!!!");
					document.getElementById("end_date").focus();
					return false;
				} 
	   //////////////////�ж�ʱ���Ƿ����////////////////
		   if(!checkDate(document.getElementById("start_date").value,document.getElementById("end_date").value)){
		     return false;
		   }
		   ///////////////////////////////////////////////
	
			if (document.classForm.category_addr.value == ""||document.classForm.category_addr.value == null)
			{
				alert("��Ʒ��Ϣ��ַ������Ϊ�գ�");
				document.classForm.category_addr.focus(); 
				return false;
			}
  	return true;
	
}

//deleteProcessList.jsp
  function deleteProcessListchechIfo()
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
  
//modifyProcessList.jsp
	  function modifyProcessListCheck_Value(){
	       if(document.getElementById("start_date").value ==null || document.getElementById("start_date").value ==""){
	        alert("��ѡ��ʼʱ�䣡");
	        return false;
	       }
	       if(document.getElementById("end_date").value ==null || document.getElementById("end_date").value ==""){
	        alert("��ѡ�����ʱ�䣡");
	        return false;
	       }
	       document.orderdateform.submit();
	    }
	  function Change()
	  {
	  	document.getElementById("keyword1").value="";
	  	
	  }