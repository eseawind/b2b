var xmlHttp = null;

function getSubitems(obj, classid, emptyName, emptyValue)
{
	var xmlHttp = createXmlHttp();
	
	if(classid == null)
		return;
	else if(classid == "000000000000000") 
		classid = "";
	xmlHttp.open("GET", "/crm/respositItems.jsp?classid=" + UrlEncode(classid), false);
	xmlHttp.send(null);
	var result = xmlHttp.responseText;
	if(result == null || result.length == 0)
	{
		obj.options.length = 0;
		this.sortDisplay();
		return;	
	}
	else
	{
		obj.options.length = 0;
		if(emptyName != null || emptyValue != null)
			obj.options.add(new Option(emptyName, emptyValue));
		result = result.split("\n");
		for(var index = 0; index < result.length; index++)
		{
			var columns = result[index].split(",");
			if(columns.length>1)
			{
			var option = new Option(columns[3], columns[0])
			obj.options.add(option);
			}
		}
		this.sortDisplay();
	}
}

function sortDisplay()
{
	if(document.classForm.sort2.options.length == 0)
	{
		document.classForm.sort2.style.display = "none";
		document.classForm.sort3.style.display = "none";
	}
	else
	{
		document.classForm.sort2.style.display = "block";
	}
	
	if(document.classForm.sort3.options.length == 0)
		document.classForm.sort3.style.display = "none";
	else
		document.classForm.sort3.style.display = "block";
}

function createXmlHttp()
{
	if (window.ActiveXObject && !window.XMLHttpRequest)
		return new ActiveXObject((navigator.userAgent.toLowerCase().indexOf('msie 5') != -1) ? 'Microsoft.XMLHTTP' : 'Msxml2.XMLHTTP');
	else
		return new window.XMLHttpRequest();
}