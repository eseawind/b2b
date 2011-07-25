function changeImg(img) {
	if (img.name == "pic") {
		img.src = "images/picOpen.gif";
		img.name = "picName";
	} else {
		img.src = "images/picClose.gif";
		img.name = "pic";
	}
}

function menuChange(obj, menu) {
	if (menu.style.display == "") {
		obj.background = "images/background/left_bg_show.gif";
		menu.style.display = "none";
	} else {
		obj.background = "images/background/left_bg_hide.gif";
		menu.style.display = "";
	}
}
function menuload() {
	menu2.style.display = "";

}

function ShowMenu(divid, picId) {

	if (divid.style.display == "") {
		divid.style.display = "none";
		picId.src = "images/1.gif";
	} else {
		divid.style.display = "";
		picId.src = "images/_1.gif";
	}

}

function setSessionCode(subsys_code) {
	var data = Math.round(Math.random() * 10000);
	var myAjax = new Ajax.Updater('sesson-div',
			'syscode.jsp?subsys_code='+subsys_code+'&data=' + data, {
				method : 'get',
				evalScripts : true
			});

}
