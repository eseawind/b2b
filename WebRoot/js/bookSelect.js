function selectBook(){
		var book_type = document.getElementById('book_type').value;
		var book_key = document.getElementById('book_key').value;
		 
		if(book_key==''){
			alert('������ؼ���!');
			return false;
		}
		if(book_type==''){
			alert('��ѡ���ѯ����!');
			return false;
		}
		window.location.href="oil_book_list_dis.jsp?book_type="+book_type+"&book_key="+book_key;
}

function selectBook2(){
		var book_type = document.getElementById('book_type_key').value;
		var book_key = document.getElementById('key_book_word').value;
		if(book_key==''){
			alert('������ؼ���!');
			return false;
		}
		if(book_type==''){
			alert('��ѡ���ѯ����!');
			return false;
		}
		window.location.href="oil_book_list_dis.jsp?book_type="+book_type+"&book_key="+book_key;
}