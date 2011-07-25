

function selBook(){
	var book_name = document.getElementById('book_name').value;
	var sel_type = document.getElementById('sel_type').value;
	if(book_name==''){
		alert('«Î ‰»ÎÕº È√˚≥∆£°');
		return false;
	}
	document.bookForm.submit();
}