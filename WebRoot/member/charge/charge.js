function calcMoney(val){
	
   	   //document.getElementById("moneyId").value=val;
   	    //document.getElementById("v_amount").value=val;
   	   //�ó���������
   	   //����������ڣ� 
   	   FeeSetInfo.getFee(val,SetMoneyId);
   	   FeeSetInfo.getFeeTime(val,setExpireDate);
   	   FeeSetInfo.getFeeMoneyTime(val,SetMoneyDate);
   	   FeeSetInfo.SetLimitTime(val,SetLimitDate);
   	   
}		 
function SetMoneyId(val)
{
	document.getElementById("moneyId").value=val;
	document.getElementById("fee").value=val;
	document.getElementById("v_amount").value=val;
}	 
function SetLimitDate(val)
{
	document.getElementById("limit_time").value=val;
} 
function SetMoneyDate(val)
{
	document.getElementById("buyfordays").value=val;
}
function setExpireDate(val)
{
	document.getElementById("expire_date").value=val;
}
function selecPayMod(val)
{
	if(val==1){
		document.all("tab0").style.display="blank";
		document.all("tab1").style.display="none";
	 }
		else{
		document.all("tab0").style.display="none";
		document.getElementById("tab1").style.display="blank";
	}
}
function confirmsub(){
	if(document.getElementById("buyfordays1").value=='0'){
		alert("��ѡ�񶩹�ʱ��");
		return false;
	}
		document.getElementById("v_oid").value=document.getElementById("expire_date").value;
		return true;
}