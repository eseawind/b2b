function selPeople(){
		var key_word = document.getElementById('key_word').value;
		var sel_people = document.getElementById('sel_people').value;
		if(key_word=='' || key_word==null){
				alert('请输入关键字!');
				return false;
		}
		window.location.href='peopleTalk.jsp?key_word='+key_word+'&sel_people='+sel_people;
}


function disTest(){
		var key_word = document.getElementById('key_word').value;
		var param = document.getElementById('param').value;//0:按标题 1:按评测内容
		var disselect = document.getElementById('disselect').value;//0:所有评测 1:最新评测
		if(key_word=='' || key_word==null){
				alert('请输入关键字!');
				return false;
		}
		window.location.href='/news/zixun_list.jsp?key_word='+key_word+'&param='+param+'&disselect='+disselect;
}