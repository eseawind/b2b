
function searchP(){
	var pro_name = $F('product_name');
	var proArea = $F('area');
	var custName = $F('custName');
	var date_scope = $F('date_scope');
	if(pro_name=='请输入产品名'){
		document.getElementById('product_name').value='';
	}
	if(proArea=='请输入地区名'){
		document.getElementById('area').value='';
	}
	if(custName=='请输入公司名称'){
		document.getElementById('custName').value='';
	}
	if(date_scope=='产品发布日期'){
		document.getElementById('date_scope').value='';
	}
	document.seProForm.submit();
}