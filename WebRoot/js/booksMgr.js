//modi_product_attr.jsp
function modi_product_attrCheck_Value()
 { 
	    var size=document.getElementById("size").value;
	    var values="";
	    for(var i=0;i<size;i++){
	      var obj="attr_value"+i;
	      values=values+document.getElementById(obj).name+"#"+document.getElementById(obj).value+"|";
	    }
	    document.getElementById("rsrv_str1").value=values;
 	    return true;
}