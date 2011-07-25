//jobAnswerMgr.jsp
    function Check_Value()
	{
		       
		   if(document.getElementById("title").value.replace(/\s*/g,"")=="" || document.getElementById("title").value.replace(/\s*/g,"")=="")
				{
					alert("职位标题不能为空");
					document.getElementById("title").focus();
					return false;
				}
				 if(document.getElementById("request").value.replace(/\s*/g,"")=="" || document.getElementById("request").value.replace(/\s*/g,"")=="")
				{
					alert("职位要求不能为空");
					document.getElementById("request").focus();
					return false;
					
				}
 	    return true;
	}
	
//jobAnswerIndex.jsp
function checkRaleType(type){
	window.location.href = "jobAnswerIndex.jsp?" + addSearch("URL", "deal_tag", type);
}


function selectInit(selectElementID,selectedForValue){
	var selectObj = this.document.getElementById(selectElementID)
	var selectLength = selectObj.length;
	for (var i = 0; i<selectLength ; i ++){
		if (selectObj[i].value == selectedForValue){
			selectObj[i].selected  = true ;
		}
	}
}


function addSearch(searchStr,name,value){
	if (searchStr == "URL"){
		return searchManage(this.location.search.substr(1),"add",name,value);
	}
	return searchManage(searchStr,"add",name,value);	
}

function searchManage(searchStr,operType,name,value){
	var searchArray = new Array();
	var returnStr = "";		
	if (searchStr != ""){
		searchArray = searchStr.split("&");	
		
		for(var i = 0 ; i < searchArray.length ; i ++){
			if (searchArray[i] != ""){
				var paramArray = new Array();
				paramArray = searchArray[i].split("=");		
				if (paramArray[0] == name){
					searchArray.splice(i,1);
					i--;
				}
			}
		}
	}
	
	if (operType == "add"){
		returnStr = name +  "=" + value;
	}
	
	if (operType == "remove"){
	}
	
	
	for(var j = 0; j < searchArray.length; j++){
		if (searchArray[j] != ""){
			returnStr += "&" + searchArray[j];
		}
	}

	return returnStr;
	
}