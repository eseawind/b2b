//addRoleRightInfo.jsp
     	function submitRoleForm(){
      		document.roleForm.submit();
      	}
      	function showTwoMenu(val){
        	var i = val;
        	var right_menu = "right_menu"+val;
        	var twoObj = "two"+val;
        	var twoMenuSize = document.getElementById(twoObj).value;
        	for(var j=0;j<twoMenuSize;j++){
        		var twoMenuObj = "two"+val+j;
        		if(document.getElementById(right_menu).checked==true){
        			document.getElementById(twoMenuObj).style.display = 'block';
        		}else{
        			document.getElementById(twoMenuObj).style.display = 'none';
        		}
        	}
        }
        
        function showThreeMenu(vali,valj){
        	var i = vali;
        	var j = valj;
        	var two_menu = "tow_menu"+i+j;
        	var threeObj = "three"+i;
        	var threeMenuSize = document.getElementById(threeObj).value;
        	for(var k=0;k<threeMenuSize;k++){
        		var threeMenuObj = "three"+i+j+k;
        		if(document.getElementById(two_menu).checked==true){
        			document.getElementById(threeMenuObj).style.display = 'block';
        		}else{
        			document.getElementById(threeMenuObj).style.display = 'none';
        			document.getElementById(threeMenuObj).checked=false;
        		}
        	}
        }
        
        function addRoleRightInfoconfirmsub(){
        	if(document.getElementById("role_code").value=="" || document.getElementById("role_code").value==null){
        		alert("��ѡ���ɫ����!");
        		return false;
        	}
        	if(document.getElementById("server_id").value=="" || document.getElementById("server_id").value==null){
        		alert("��ѡ���������!");
        		return false;
        	}
        	document.getElementById('')
        	if(document.getElementById("menu_id").value=="" || document.getElementById("menu_id").value==null){
        		alert("��ѡ�����˵�!");
        		return false;
        	}
        	if(document.getElementById("start_date").value=="" || document.getElementById("start_date").value==null){
        		alert("��ѡ��ʼʱ��!");
        		return false;
        	}
        	if(document.getElementById("end_date").value=="" || document.getElementById("end_date").value==null){
        		alert("��ѡ�����ʱ��!");
        		return false;
        	}
        }
        
//removeRoleRight.jsp
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


    	function confirmsub(formobj)


    	{


    	    if(window.confirm('��ȷ��Ҫ�ύ��')) 


    	    {  	    	


    	      checkIsDelete();


    	    }


    	    else


    	    {


    	        return;


    	    }


    	}


 function initMenu(role){


   if(role!="0"){


    var cust=document.getElementById("cust_id").value;


    RightMenu.getRoleByCodeAndClass("CRM","1",role,cust,setMenu1Info);


   }else{


    var cust=document.getElementById("menu_id").value="";


    DWRUtil.removeAllOptions("sort1");


    document.getElementById("sort2").style.display="none";


    document.getElementById("sort3").style.display="none";


   }


 }


 function setMenu1Info(data){


   DWRUtil.removeAllOptions("sort1");


   DWRUtil.addOptions("sort1",data);


 }


 function setMenu2Info(id){


   if(id !="0"){


      document.getElementById("menu_id").value=id;


      var cust=document.getElementById("cust_id").value;


      var role=document.getElementById("role_code").value;


      RightMenu.getRoleByUpmenId("CRM",id,cust,role,initMenu2);


   }


 }


function initMenu2(data){


   document.getElementById("sort2").style.display="block";


   DWRUtil.removeAllOptions("sort2");


   DWRUtil.addOptions("sort2",data);


   document.getElementById("sort3").style.display="none";


 } 


 function setMenu3Info(id){


   document.getElementById("menu_id").value=id;


   if(id !=""){


      var cust=document.getElementById("cust_id").value;


      var role=document.getElementById("role_code").value;


      RightMenu.getRoleByUpmenId("CRM",id,cust,role,initMenu3);


   }


 }


function initMenu3(data){


   document.getElementById("sort3").style.display="block";


   DWRUtil.removeAllOptions("sort3");


   DWRUtil.addOptions("sort3",data);


    var item=document.getElementById("sort3").length;


    if(item==0)


    {


    	document.getElementById("sort3").style.display="none"; 


    }


     else


   	{


   		document.getElementById("sort3").style.display="block";


   	}


 } 


 function setMenuID(id){


     document.getElementById("menu_id").value=id;


 }


 function checkIsDelete(){


   var id=document.getElementById("menu_id").value;


   if(id !=""){


      var cust=document.getElementById("cust_id").value;


      var role=document.getElementById("role_code").value;


      RightMenu.getRoleByUpmenId("CRM",id,cust,role,Check_Value);


   }else{


       alert("��ѡ��Ҫ���յ�Ȩ�޲˵���");


       return false;


   }


 }


    function Check_Value(data)


	{


	    for(var obj in data){


	     alert("���Ȼ����¼�Ȩ�޲˵���");


	     return ;


	    }


	    document.resumeForm.submit();


	}
