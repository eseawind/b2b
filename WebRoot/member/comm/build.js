function createCustomerWeb(value) {	
	var company = document.getElementById('company').value;
	if(company=='' || company=='请输入企业站名称...'){
			alert('请输入企业站名称！');
			document.getElementById('company').value='';
			document.getElementById('company').focus();
			return false;
	}
	var   reg=/[^A-Za-z0-9]/g; 
	if(reg.test(company)){
			alert('企业站名称只能由数字或字母组成！');
			return false;
	}
  createCustomerHTML(value,company);
}

// 生成进度条
var i = 0;
function test() {
	i++;
	document.getElementById("loading").style.width = i + "%";
	document.getElementById("loadtext").innerText = i + "%";
	if (i < 100) {
		setTimeout("test()", 10);
		$('closeWin').style.display='block';
	} else {
		$("finsh").style.display = "block";
		$('closeWin').style.display='none';
		$("type").disabled="disabled"
		
	}
	window.setTimeout("subtest()", 6000);
}
// 生成企业网站
function createCustomerHTML(rootpath,company) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater('temp',
			'/member/comm/createHTML.jsp?company='+company+'&rootpath='+rootpath+'&data=' + data, {
				method : 'get',
				evalScripts : true
	});
	
	$('process').style.display="block";
	//document.comForm.submit();
	i = 0;
	window.setTimeout("test()", 200);
	
	
	
}

function subtest(){
	document.comForm.submit();	
}


