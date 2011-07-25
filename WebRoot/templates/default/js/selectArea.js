

var fectureArray=new Array();
	 fectureArray=['«Î—°‘Ò'];
function setProvince()
{
	AreaInfo.getAreaByParent('5J2mc0X0G85BH',function(data){
		DWRUtil.removeAllOptions("province");
		DWRUtil.addOptions("province",fectureArray);
		DWRUtil.addOptions("province",data);
	                          })
}
function setCitys2(prov)
{
   var provence=prov;
	 AreaInfo.getAreaByParent(provence,function(data){
			   DWRUtil.removeAllOptions("eparchy_code");
				 DWRUtil.addOptions("eparchy_code",fectureArray);
				 DWRUtil.addOptions("eparchy_code",data);
			   DWRUtil.removeAllOptions("city");
				 DWRUtil.addOptions("city",fectureArray);
	});
}
function setCitys(prov)
{
   var provence=prov;
	 AreaInfo.getAreaByParent(provence,function(data){
			   DWRUtil.removeAllOptions("eparchy_codeS");
				 DWRUtil.addOptions("eparchy_codeS",fectureArray);
				 DWRUtil.addOptions("eparchy_codeS",data);
			   DWRUtil.removeAllOptions("city");
				 DWRUtil.addOptions("city",fectureArray);
	});
}
function setAreas(city_id){
	AreaInfo.getAreaByParent(city_id,function(data){
	 DWRUtil.removeAllOptions("city_code");
     DWRUtil.addOptions("city_code",fectureArray);
	 DWRUtil.addOptions("city_code",data);
	});
}
	
function b2bsearsh()
{
	if(document.getElementById("keyWords").value=='')
	{
		alert('«Î ‰»Îπÿº¸◊÷!');
		document.getElementById("keyWords").focus();
		return ;
	}
	if(document.getElementById("province").value=='0'||document.getElementById("province").value=='«Î—°‘Ò')
	{	
		document.getElementById("province").value='';
	}
	if(document.getElementById("eparchy_codeS").value=='0'||document.getElementById("eparchy_codeS").value=='«Î—°‘Ò')
	{
		document.getElementById("eparchy_codeS").value='';
	}
	if(document.getElementById("part").value=='0'||document.getElementById("part").value==null)
	{
		document.getElementById("part").value='365';
	}
 var eparchy_codeS = document.getElementById("eparchy_codeS").value;
 var province = document.getElementById("province").value;
 var part = document.getElementById("part").value;
 var keywords = document.getElementById("keyWords").value;
 //
 if(document.getElementById("stockflag"))
 {
 	  var radiObj = document.getElementById("stockflag").value;
 }
 if(radiObj != null && radiObj == "imstock")
 {
 		window.open('/inc/include/StockPage.html?keywords='+keywords+'&province='+province+'&eparchy_codeS='+eparchy_codeS+'&part='+part);	
 }
 else
 {
 		window.open('/inc/include/SupplyPage.html?keywords='+keywords+'&province='+province+'&eparchy_codeS='+eparchy_codeS+'&part='+part+'&type='+'0');
 }
}