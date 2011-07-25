//addProductInfo.jsp
	 function addProductInfoCheck_Value(){ 
        var name=document.getElementById("product_name").value;
	   if(name=="" || name==null){
	      alert("产品名称不能为空！");
	      return false;
	   }
	   if(document.getElementById("product-div").innerHTML==""){
	   	alert("产品分类不能为空!");
		return false;
	   }
	   if(document.getElementById("product_type")=="" || document.getElementById("product_type")==null){
	     alert("产品类型不能为空！");
	      return false;
	   }
	    var size=document.getElementById("size").value;
	    var values="";
	    for(var i=0;i<size;i++){
	      var obj="attr_value"+i;
	      values=values+document.getElementById(obj).name+"#"+document.getElementById(obj).value+"|";
	    }
	    document.getElementById("rsrv_str1").value=values;
 	    return true;
	}