function checksubmit()
{
var supId=document.getElementById("classlevelsrc").value;
document.getElementById("record_src").value ="[{\"supId\":\""+supId+"\"},{\"ssubId\":\"";
var tupId=document.getElementById("classleveltar").value;
document.getElementById("record_tar").value ="[{\"tupId\":\""+tupId+"\"}]";
	var flag1=false;
	var ff="";
	var temp1=document.classForm.src;
	var srcId =document.getElementById("record_src").value;	
 if(null!=temp1&&temp1!="undefined"){
	for(var i=0;i<temp1.length;i++)
	{
		if(temp1[i].checked){
			 ff=ifexsit(temp1[i].value,tupId);
			 ff=ff.trim();
			if(ff=="")//û���ظ���
			{
				srcId=srcId+temp1[i].value+",";	 
	      flag1=true;
	   }
	 else
	 	{  		
	 		alert(ff+"��Ŀ��������Ѵ��ڣ�")//�ĸ��ظ��ˣ�
	 		return false;
	 	}
	 
	}
	}

}
 if(flag1)
	 {
	 	document.getElementById("record_src").value=srcId+"\"}]";
	 	return true;
	 	}
	 	else if(!flag1){
	 		 alert("��ѡ��ҪԴ�������࣡");
	 			return false;
	 		}
	 return false;
}
//extends
String.prototype.trim = function() { return this.replace(/(^\s*)|(\s*$)/g, ""); } 
//ajax if exsit
function ifexsit(val,supId)
{
	var xmlHttp = createXmlHttp();
	if(val != null)
	xmlHttp.open("GET", "ifcopyKind.jsp?uptype="+UrlEncode(supId)+"&class_id=" + UrlEncode(val), false);
	xmlHttp.send(null);
	var result = xmlHttp.responseText;
	return result;
	}
	//select all
	function seltAll(val){
		if(val.checked){
		var temp1=document.classForm.src;
    if(null!=temp1&&temp1!="undefined"){
	  for(var i=0;i<temp1.length;i++)
	  {
		temp1[i].checked=true;
	}
}
}
}
////////////////////////////
function dispItem(clsId)
{
	if(document.getElementById("select_all").checked==true){
		document.getElementById("select_all").checked=false;
	}
 Productclass.getProdtClassByUpId("000000000000000",clsId,dispItemValue);
}
function dispItemValue(val)
{ 
	document.getElementById("desr").style.display="block";
	document.getElementById("desr").innerHTML =val;
}
//target
function dispItemtar(clsId)
{
 Productclass.getPdtClassByUpId("000000000000000",clsId,dispItemValuetar);
}
function dispItemValuetar(val)
{
	//alert(val);
	document.getElementById("targt").style.display="block";
	document.getElementById("targt").innerHTML =val;
}

function test1(val)
{
	if(val.checked){
  Productclass.getClassNameById(val.value,test2)
	}		
}
function test2(val)
{
	 var upId=document.getElementById("classleveltar").value;
	Productclass.isExsit("000000000000000",upId,val,test3)
	
}
function test3(flag)
{
	if(flag){
		alert("���ӷ�����Ŀ�������Ѵ��ڣ����追�����빴��");	
		}

}
//record the Դ��¼��


//////////////////////////
function selectLevel(leveles,target)
{
	if(target)
	{
   if(leveles=="10")
	 {
	   document.getElementById("typeInfo").style.display ="block";
	   setOneClass("10",target);
	 }
	 else
	{
	  document.getElementById("typeInfo").style.display ="none";
	} 	
  }
  else
	{
		 if(leveles=="10")
	 {
	   document.getElementById("typeInfotgt").style.display ="block";
	   setOneClass("10",target);
	 }
	 else
	{
	  document.getElementById("typeinfotgt").style.display ="none";
	} 	
		
		}
}
//����һ������
	function setOneClass(val,target)
	{
		if(target){
				var type=val;
				if(type!="0"){
				 document.getElementById("typeinfo").style.display="block";
				 Productclass.getProductClassByUpId("000000000000000",type,setSort1);
				}else{
				 document.getElementById("typeInfo").style.display="none";
				 document.classForm.class_name.value="";
				 document.classForm.class_desc.value="";
				}
		}
		else
			{
				var type=val;
				if(type!="0"){
				 document.getElementById("typeinfotgt").style.display="block";
				 Productclass.getProductClassByUpId("000000000000000",type,setSort1tgt);
				}else{
				 document.getElementById("typeInfotgt").style.display="none";
				 document.classForm.class_name.value="";
				 document.classForm.class_desc.value="";
				}
				
		}
	}
	function setSort1(map_data)
	{
		DWRUtil.removeAllOptions("sort1");
		DWRUtil.addOptions("sort1",map_data);
		document.getElementById("sort2").style.display="none";
		document.getElementById("sort3").style.display="none"; 
		document.getElementById("nextElement").style.display="none"; 
	}
		function setSort1tgt(map_data)
	{
		DWRUtil.removeAllOptions("sort1tgt");
		DWRUtil.addOptions("sort1tgt",map_data);
		document.getElementById("sort2tgt").style.display="none";
		document.getElementById("sort3tgt").style.display="none"; 
		document.getElementById("nextElementtgt").style.display="none"; 
	}
	//���ö�������
	function setSecondClass(val,target)
	{
		if(target){
							var up_class_id=val;
							var type="10";
							Productclass.getProductClassByUpId(up_class_id,type,setSort2);
	   					}
		else
							{
							var up_class_id=val;
					    var type="10";
					   Productclass.getProductClassByUpId(up_class_id,type,setSort2tgt);							
							}
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
	function setSort2tgt(map_data)
	{
		DWRUtil.removeAllOptions("sort2tgt");
		DWRUtil.addOptions("sort2tgt",map_data);
		document.getElementById("sort3tgt").style.display="none";
		document.getElementById("nextElementtgt").style.display="none"; 
		 var item=document.getElementById("sort2tgt").length;
	     if(item==0)
	    {
	    	document.getElementById("sort2tgt").style.display="none";
	    }
	    else
	    	{
	    		document.getElementById("sort2tgt").style.display="block";
	    	}
	}
	//������������
	function setTherdClass(val,target)
	{ if(target){
		var up_class_id=val;
		var type="10";
		Productclass.getProductClassByUpId(up_class_id,type,setSort3);
	}
	else
		{
				var up_class_id=val;
				var type="10";
				Productclass.getProductClassByUpId(up_class_id,type,setSort3tgt);
			}
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
	function setSort3tgt(map_data)
	{
		if(map_data!=null)
		{
			DWRUtil.removeAllOptions("sort3tgt");
		     DWRUtil.addOptions("sort3tgt",map_data);
		     var item=document.getElementById("sort3tgt").length;
		     if(item==0)
		     {
		    	document.getElementById("sort3tgt").style.display="none";
		    	document.getElementById("nextElementtgt").style.display="none"; 
		     }
		     else
		     	{
		     		document.getElementById("sort3tgt").style.display="block";
		     	}
		}
	}
	
	function setTypeName(classId,leave)
	{
		
		document.classForm.class_level.value=leave;
		document.classForm.up_class_id.value=classId;
	}
	 //��̬�����¼�������Ϣ
	function cretateSelect(index,value)
	{

	 document.getElementById("nextElement").style.display="block";

	 document.getElementById("class_level").value=index;

	 var type=document.getElementById("class_type").value;
	  
	 var divId=parseInt(index)+parseInt(1);

	 document.getElementById("index_s").value=index;

	 document.getElementById(index).innerHTML="<select name=sort"+index+" id=sort"+index+" onchange=cretateSelect("+divId+",this.value) size=3 onclick=setTypeName(this.value) style=width:130px></select><div id="+divId+"></div>";
	 DWRUtil.removeAllOptions("sort"+index);
	 Productclass.getProductClassByUpId(value,type,setNewSelect);
   }
    //�ص�����
     function setNewSelect(map_data){
      var id=document.getElementById("index_s").value;
      document.getElementById("class_level").value=id;
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
    	 //Ŀ�궯̬�����¼�������Ϣ
	function cretateSelectgt(index,value)
	{
	 document.getElementById("nextElementtgt").style.display="block";
	 document.getElementById("class_level").value=index;
	 var type=document.getElementById("class_type").value;
	 var divId=parseInt(index)+parseInt(1);
	 document.getElementById("index_s").value=index;
	 document.getElementById(index).innerHTML="<select name=sort"+index+"tgt id=sort"+index+"tgt onchange=cretateSelectgt("+divId+",this.value) size=3 onclick=setTypeName(this.value) style=width:130px></select><div id="+divId+"></div>";
	 DWRUtil.removeAllOptions("sort"+index+"tgt");
	 Productclass.getProductClassByUpId(value,type,setNewSelect2);
    }
    //�ص�����
     function setNewSelect2(map_data){
      var id=document.getElementById("index_s").value;
      document.getElementById("class_level").value=id;
      DWRUtil.addOptions("sort"+id+"tgt",map_data);
        var item=document.getElementById("sort"+id+"tgt").length;
	    if(item==0)
	    {
	    	document.getElementById(id).style.display="none"; 
	    }
	     else
	   	{
	   		document.getElementById(id).style.display="block";
	   	}
    }
    //�ص�����
     function setNewSelect(map_data){
      var id=document.getElementById("index_s").value;
      document.getElementById("class_level").value=id;
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
    
function createXmlHttp()
{
	if (window.ActiveXObject && !window.XMLHttpRequest)
		return new ActiveXObject((navigator.userAgent.toLowerCase().indexOf('msie 5') != -1) ? 'Microsoft.XMLHTTP' : 'Msxml2.XMLHTTP');
	else
		return new window.XMLHttpRequest();
}