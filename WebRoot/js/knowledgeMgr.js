//classEntity.jsp

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
		//var idx=obj.value;
		//document.getElementById("class_id").value=idx;
		//document.getElementById("class_name").value=DWRUtil.getText(obj.name);
		//document.getElementById("count").value=obj.name;
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

//deleteResposList.jsp

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
  
//modifyReposeInfo.jsp

    function modifyReposeInfoCheck_Value()
	{
	    if (document.reposForm.title.value.replace(/\s*/g,"") == "" || document.reposForm.title.value.replace(/\s*/g,"") == null) 
			{                                                                                         
				alert("���ⲻ����Ϊ�գ�");                                                             
				document.reposForm.title.focus();                                                    
				return false;                                                                            
			}  
			var str=content.getText();
			str=str.replace(/\s*/g,""); 
			if(str == ""  )
			{
				alert("֪ʶ���ݲ�����Ϊ�գ�");
				return false;
			}
			
			
			if( str.length > 4000)
			{
				 alert( "֪ʶ��������Ӧ����4000��" );
				 return false;	
			}                                                                                   
		                                                                                      
 	    return true;
	}
     function check_none(current_obj)
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
    	function modifyReposeInfoconfirmsub(formobj)
    	{
    	    if(window.confirm('��ȷ��Ҫ�ύ��')) 
    	    {  	    	
    	        if (!modifyReposeInfoCheck_Value())
    	        {
    	             return;
    	        }
    	         formobj.submit();   	         
    	    }
    	    else
    	    {
    	        return;
    	    }
    	}
    	
//modifyResposList.jsp

	  function modifyResposListCheck_Value(){
	       if(document.getElementById("start_time").value ==null || document.getElementById("start_time").value ==""){
	        alert("��ѡ��ʼʱ�䣡");
	        return false;
	       }
	       if(document.getElementById("end_time").value ==null || document.getElementById("end_time").value ==""){
	        alert("��ѡ�����ʱ�䣡");
	        return false;
	       }
	    document.modifyResposform.submit();
	  }
	  
//addCollegeInfo.jsp
  	function addCollegeInfoconfirmsub()
  	{   	
        if (document.getElementById("title").value=="")
        {
        		  alert("���ⲻ����Ϊ��!!!");
        			document.getElementById("title").focus();
             return false;
        }  	           
  	}