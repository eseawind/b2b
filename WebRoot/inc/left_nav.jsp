<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=GBK" %>
<jsp:useBean id="warnBean" class="com.saas.biz.warnparaMgr.WarnparaInfo" scope="page" />
<%
    HttpSession  logsession = request.getSession(); 
    String user_name = "",news_Image="news0.gif",user_id="",cust_id="";
    if (logsession.getAttribute("SESSION_USER_NAME") != null)
    {
        user_name = logsession.getAttribute("SESSION_USER_NAME").toString();
    }
    if (logsession.getAttribute("SESSION_USER_ID") != null)
    {
        user_id = logsession.getAttribute("SESSION_USER_ID").toString();
    }
    if (logsession.getAttribute("SESSION_CUST_ID") != null)
    {
        cust_id = logsession.getAttribute("SESSION_CUST_ID").toString();
    }
    boolean news=warnBean.checkUserWarninfo(cust_id,user_id);
    if(news){
      news_Image="news1.gif";
    }
%>
<link rel="stylesheet" type="text/css" href="/ext/resources/css/ext-all.css" />
<script type="text/javascript" src="/ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="/ext/ext-all.js"></script>
<!--
  Ext.onReady(function(){ 
     Ext.QuickTips.init();
     Ext.form.Field.prototype.msgTarget = 'side';
  });
function Menu_onclick() 
{
	var srcElement,targetElement,targetArrayElement,targetImgElement;
	var srcID,targetID;
	srcElement=window.event.srcElement;
	srcID=srcElement.id.substr(0,srcElement.id.length-2);
	 
	if (srcElement.className.substr(0,7)=="mid-xx1")
    {   
		
		targetID=srcID+"-div";
		targetElement=document.all(targetID);
		 
		targetImgElement = document.all(srcID+"-k");
		if (targetElement.style.display=="none")
        {			  
			targetElement.style.display="";		
			 
			targetImgElement.src="/images/arrow2.gif";
			/**
			var allDIV=document.all.tags("TR");
			for (var i=1;i<allDIV.length;i++)
            if (allDIV(i).id!=targetTrElement)
            {
                var otherID=allDIV(i).id.substr(0,allDIV(i).id.length-4);
                allDIV(i).style.display="none";
            }
       **/
        }
		else
        {
            targetElement.style.display="none";
            
            targetImgElement.src="/images/arrow1.gif";	
        }
    }
}
function showMyNet(){
  
   var wind;
   var tab;
   if(!tab)
   {
    tab=new Ext.FormPanel({
    labelAlign: 'center',
   // title: '������',
    buttonAlign:'right',
    bodyStyle:'padding:5px',
    width: 350,
    frame:true,
    labelWidth:80,
    onSubmit: Ext.emptyFn,   
		    submit: function() {   
		        this.getEl().dom.action = '/doTradeReg.do?trade_type_code=0081';
		        this.getEl().dom.submit();   
		    },  
    items: [{
            columnWidth:5,
            layout: 'form',
            border:false,
            items: [{
                xtype:'combo',
								store: new Ext.data.SimpleStore(
					      {
					        fields: ["retrunValue", "displayText"],
					        data: [[1,'�ҵ�����'],[2,'�ҵĲ���'],[3,'�ҵ�QQ����'],[4,'�ҵ�MSN����'],[5,'��˾��վ'],[6,'�ҵ��ղ�']]
					      }),
					      valueField :"retrunValue",
					      displayField: "displayText",
					      mode: 'local',
					      forceSelection: true,
					      blankText:'��ѡ��',
					      emptyText:'��ѡ��',
					      hiddenName:'pos_type',
					      editable: false,
								triggerAction: 'all',
								allowBlank:false,
                fieldLabel: '�ҵĻ�����',
                name: 'pos_type',
                width:150
            }]
      },
      {
        layout:'column',
        border:false,
        labelSeparator:'��',
        items:[{
            columnWidth:5,
            layout: 'form',
            border:false,
            items: [{
                xtype:'textfield',
                fieldLabel: '����������',
                name: 'name',
               width:150
            }]
     	   }
    	  ]
  	  }]
		})
        

   }
   if(!wind){
      wind = new Ext.Window({
	        title: '�����ҵĻ�����',
	        width: 300,
			    iconCls:'root-Img',
	        height:200,
	        minWidth: 200,
	        minHeight: 100,
	        layout: 'fit',
	        plain:true,
	        bodyStyle:'padding:5px;',
	        buttonAlign:'center',
          items:tab,
	        buttons: [{
	            text: '�ύ',
		  				handler:function(){tab.form.submit();}
		  				 
	        },{
	            text: '�ر�',
		 					handler:function(){wind.hide();}
	        }]
	    });
		wind.show();
	}
    else{
		wind.show();
	}
}


 function showEmail()
 {
 		var wind;
 		Ext.QuickTips.init();
 		if(!wind)
 		{
 			wind= new Ext.Window({
                iconCls:'root-Img',
                layout:'fit',
                width:370,
                autoScroll:true,
                title:'�ҵĻ���������',
                maximizable :true,
                height:320,
                frame:true,
                closeAction:'hide',
                plain: true,
                items:[{
                    autoLoad:{url:'/inc/showEmail.jsp?type=123', params:'number=10'}               	
                }],
		       		 buttons: [//{
		            //text: '�ύ'
			       // },
			        {
			            text: '�ر�',
			            handler:function(){
			             wind.hide();
			            }
			        }]
	            });	 
	            wind.show();       
 		}
 		else
 		{
 				wind.show();
 		}
 }
//-->
<script type="text/javascript">
var HttpRequest;
var url = "/ChatRoomServlet";
function getRequest(){
    if(window.XMLHttpRequest){
        return(new XMLHttpRequest());
    }else if(window.ActiveXObject){
        try{
            return(new ActiveXObject("Msxm12.XMLHTTP"));
        }catch(e){
            try{
                return(new ActiveXObject("Microsoft.XMLHTTP"));
            }catch(e){}
        }
    }
}
function sendRequest()
{
    if(document.getElementById("txtMessage").value.length<=0){
        return false;
    }
    HttpRequest = getRequest();
    
    //HttpRequest.onreadystatechange = getMessage;
    HttpRequest.open("POST", url, true);
    HttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var msg;
    msg = "Action=AddMessage&Message=" + document.getElementById("txtMessage").value;
    HttpRequest.send(msg);
    document.getElementById("txtMessage").value = "";
    //document.getElementById("txtMessage").focus();
}
function DisplayMessage(){
    if(HttpRequest.readyState == 4 && HttpRequest.status == 200){
        //alert("abd");
        //alert(HttpRequest.responseText);
       // var messages;
        //alert(HttpRequest.responseText);
       // messages = HttpRequest.responseText.split("!@#");
        //document.writeln(messages[0]);
        //document.writeln(messages[1]);
       // document.getElementById("Messages").innerHTML = messages[0];
        //document.getElementById("userList").innerHTML = "User�� <br>" + messages[1];
        //document.getElementById
    }
}
function logout(){
    HttpRequest = getRequest();
    HttpRequest.open("POST", url, true);
    HttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var msg;
    
    msg = "Action=Logout";
    HttpRequest.send(msg);
}
function getMessage(){
    HttpRequest = getRequest();
    HttpRequest.onreadystatechange = DisplayMessage;
    HttpRequest.open("POST", url, true);
    HttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var msg;
    msg = "Action=GetMessage";
    HttpRequest.send(msg);
    //document.getElementById("txtMessage").focus();
}
function login(){
    HttpRequest = getRequest();
    //var WshNetwork = new ActiveXObject("WScript.Network");
    
    HttpRequest.open("POST", url, true);
    HttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var msg;
    msg = "Action=Login&UserName=<%=user_name%>";// + WshNetwork.UserName;
    HttpRequest.send(msg);
    
    setInterval('getMessage();', 1000);
}
function chkSubmit(e){
    if(window.event){
        var keyNumber = e.keyCode;
        if(keyNumber == 13){
            sendRequest();
        }
    }
}
</script>
<tr>
    <td valign="top" rowspan="2"  >
        
        <div class="mid-bj" >
            <div class="mid-xx"   language=javascript onclick="return Menu_onclick()">
    		   <div class="mid-xx1"  class="Menu-T" id=sss-p style="cursor:hand">
    		      <div class="mid-xx3" >����ͨ��</div>
    			  <div class="mid-xx4">
    			    <img src="/admin/images/arrow2.gif" width="11" height="11" id="sss-k"/>
    			    </div>
    		   </div>
    	       <div class="mid-xx2"  id=sss-div>
    		        <table>
    		            <tr><td><img src="/admin/images/qlink/home22.gif" border=0></td><td><a href="/main.jsp" style="text-decoration:underline;">��ҳ</a></td></tr> 
    			        <tr><td><img src="/admin/images/qlink/cust22.gif" border=0></td><td><a href="/main.jsp?menu_id=W13jl64f78q5d56d873Y&menu_class=3&subsys_code=B2B" style="text-decoration:underline;">�����͹�������ɹ���Ϣ</a></td></tr>
    			        <tr><td><img src="/admin/images/qlink/conman22.gif" border=0></td><td><a href="/main.jsp?menu_id=3CL6681y73wON8S&menu_class=3&subsys_code=B2B" style="text-decoration:underline;">���������������</a></td></tr>
    			        <tr><td><img src="/admin/images/qlink/sale22.gif" border=0></td><td><a href="/main.jsp?menu_id=3CL6681y73wON8e21&menu_class=3&subsys_code=B2B" style="text-decoration:underline;">�鿴�Է����ҵı���</a></td></tr>
    			        <tr><td><img src="/admin/images/qlink/group22.gif" border=0></td><td><a href="/main.jsp?menu_id=3CL6681y73wON8en&menu_class=3&subsys_code=B2B" style="text-decoration:underline;">ѯ��(ѯ��)����</a></td></tr>
    			        <tr><td><img src="/admin/images/qlink/agent22.gif" border=0></td><td><a href="/gettradeinterface.do?menu_id=2x0La6O4q7528OU45d14&trade_type_code=0120" style="text-decoration:underline;" target="_blank">������˾���¶�̬</a></td></tr>
    			        <!--tr><td><img src="/admin/images/qlink/info22.gif" border=0></td><td><a href="/warnMgr/warnInfo.jsp" TARGET=appwin onclick="mydefss()" style="text-decoration:underline;"><img src="/admin/images/qlink/<%=news_Image%>" border=0 alt="Ԥ����ѯ"></a></td></tr-->
    			    </table>
    		   </div>
    	     </div>
    		 <div class="mid-xx" language=javascript onclick="return Menu_onclick()" style="display:none">
    		   <div class="mid-xx1" class="Menu-T" id=kkk-p style="cursor:hand">
    		      <div class="mid-xx3">�ҵĻ�����</div>
    			  <div class="mid-xx4"><img src="/admin/images/arrow2.gif" width="11" height="11" id="kkk-k"></div>
    		   </div>
    		   <div class="mid-xx2" id=kkk-div>
    		     <ul>
    			  <li><a href="javascript:showEmail()">�ҵ�����</a></li>
    			  <li><a href="javascript:showEmail()">�ҵĲ���</a></li>
    			  <li><a href="javascript:showEmail()">���ҵ�QQ���ѽ���</a></li>
    			  <li><a href="javascript:showEmail()">���ҵ�MSN���ѽ���</a></li>
    			  <li style="color:gray">�鿴��ҵ��������</li>
    			  <li><a href="javascript:showEmail()">����˾��վȥ</a></li>
    			  <li><a href="/showCollection.jsp?link_type=1" target="_blank">���ղص���ַ</a></li>
    			  <li><a href="javascript:showEmail()">���ڻ������ϵ�����</a></li>
    			</ul>
                 <div id="div_tab"></div>
                 <div id="saveInfo"></div>
    			 <div align="right"><a href="javascript:showMyNet()">�����ҵĻ�����</a></div>
    		   </div>
    		 </div>
    		 <div class="mid-xx" language=javascript onclick="return Menu_onclick()">
    		   <div class="mid-xx1" class="Menu-T" id=aaa-p style="cursor:hand">
    		      <div class="mid-xx3">���߿ͷ�</div>
    			  <div class="mid-xx4"><img src="/admin/images/arrow2.gif" width="11" height="11" id="aaa-k"></div>
    		   </div>
    		   <div class="mid-xx2" id=aaa-div>
    		   	<div style="text-align:left">
				  	���߿ͷ�QQ1��<a  href=tencent://message/?uin=860056743&Site=bizoss&Menu=yes><img border="0" SRC=http://wpa.qq.com/pa?p=1:860056743:9 alt="ϵͳȫ���ܿͷ�"></a>
          </div>
          <div style="text-align:left">
          	���߿ͷ�QQ2��<a  href=tencent://message/?uin=947069540&Site=bizoss&Menu=yes><img border="0" SRC=http://wpa.qq.com/pa?p=1:947069540:9 alt="�ͻ����ɹ�����桢���䡢�����ͷ�"></a>
          </div>
          <div style="text-align:left">
          	���߿ͷ�QQ3��<a  href=tencent://message/?uin=3510136&Site=bizoss&Menu=yes><img border="0" SRC=http://wpa.qq.com/pa?p=1:3510136:9 alt="�����̡����ۡ���桢����ͷ�"></a>
					</div>
					<div style="text-align:left">
          	���߿ͷ�QQ4��<a  href=tencent://message/?uin=578778707&Site=bizoss&Menu=yes><img border="0" SRC=http://wpa.qq.com/pa?p=1:578778707:9 alt="��������ƽ̨�ͷ�"></a>
					</div>
					<div style="text-align:left">
						 
          	���߿ͷ�MSN1��<A HREF="http://osi.hshh.org:8888/message/msn/pheelo@126.com">
<IMG SRC="http://osi.hshh.org:8888/msn/pheelo@126.com"
align="absmiddle" border="0" ALT="MSN Online Status Indicator"
onerror="this.onerror=null;this.src='http://osi.hshh.org/msnunknown.gif';"></A>

					</div>
					<div style="text-align:left">
          	���߿ͷ�mail��<a target=blank href=mailto:liuy@bizoss.com>�����ʼ��ͷ�</a>
					</div>
    		    <!--form action="#" onsubmit="return false;">
    		     <div id="Messages" style="font-size:9pt;word-wrap: break-word;height:400"></div>
    			<input type="text" size="20" id="txtMessage" onkeypress="chkSubmit(event);"/>
    			 &nbsp;&nbsp;<button onclick="sendRequest();">����</button>
    		</form-->
    		<div id="userList"></div>
    		   </div>
    		 </div>
	   </div>	       
      </td>
</tr>



