
function searchP(){
	var pro_name = $F('product_name');
	var proArea = $F('area');
	var custName = $F('custName');
	var date_scope = $F('date_scope');
	if(pro_name=='�������Ʒ��'){
		document.getElementById('product_name').value='';
	}
	if(proArea=='�����������'){
		document.getElementById('area').value='';
	}
	if(custName=='�����빫˾����'){
		document.getElementById('custName').value='';
	}
	if(date_scope=='��Ʒ��������'){
		document.getElementById('date_scope').value='';
	}
	document.seProForm.submit();
}