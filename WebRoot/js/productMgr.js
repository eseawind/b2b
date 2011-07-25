//addProductInfo.jsp
function addProductInfoCheck_Value()
{
    if (cTrim(document.form1.commodity_name.value,0) == "" || document.form1.commodity_name.value == null) 
	{                                                                                         
		alert("商品名称不可以为空！");                                                             
		document.form1.commodity_name.focus();                                                    
		return false;                                                                            
	}                                                                                      
	if (cTrim(document.form1.commodity_unit.value,0) == "" || document.form1.commodity_unit.value == null) 
	{                                                                                         
		alert("计价单位不可以为空！");                                                             
		document.form1.commodity_unit.focus();                                                    
		return false;                                                                            
	}                                                                                        
	if (cTrim(document.form1.sale_market.value,0) == "" || document.form1.sale_market.value == null) 
	{                                                                                         
		alert("销售地点不可以为空！");                                                             
		document.form1.sale_market.focus();                                                    
		return false;                                                                            
	}                                                                                      
	if (cTrim(document.form1.commodity_type.value,0) == "" || document.form1.commodity_type.value == null) 
	{                                                                                         
		alert("商品分类不可以为空！");                                                             
		document.form1.commodity_type.focus();                                                    
		return false;                                                                            
	}                                                                                      
	if (content.getText()=="" || document.form1.content.value == null) 
	{                                                                                         
		alert("说明不可以为空！");                                                             
		document.form1.content.focus();                                                    
		return false;                                                                            
	}                                                                                      
	if (cTrim(document.form1.commodity_brand.value,0) == "" || document.form1.commodity_brand.value == null) 
	{                                                                                         
		alert("品牌不可以为空！");                                                             
		document.form1.commodity_brand.focus();                                                    
		return false;                                                                            
	}                                                                                        
	if (cTrim(document.form1.commodity_price.value,0) == "" || document.form1.commodity_price.value == null) 
	{                                                                                         
		alert("原价不可以为空！");                                                             
		document.form1.commodity_price.focus();                                                    
		return false;                                                                            
	} 
	 else if(! isNum(document.form1.commodity_price.value))
	{
		alert("请输入正确的数字！");
		document.form1.commodity_price.focus(); 
		return false;
	}
	if (cTrim(document.form1.sale_price.value,0) == "" || document.form1.sale_price.value == null) 
	{                                                                                         
		alert("价格不可以为空！");                                                             
		document.form1.sale_price.focus();                                                    
		return false;                                                                            
	}
	else if(! isNum(document.form1.sale_price.value))
	{
		alert("请输入正确的数字！");
		document.form1.sale_price.focus(); 
		return false;
	}                                                                                                   
	if (cTrim(document.form1.trade_type_code.value,0) == "" || document.form1.trade_type_code.value == null) 
	{                                                                                         
		alert("TRADE_TYPE_CODE不可以为空！");                                                             
		document.form1.trade_type_code.focus();                                                    
		return false;                                                                            
	}                                                                                     
	if (cTrim(document.form1.price_type.value,0) == "" || document.form1.price_type.value == null) 
	{                                                                                         
		alert("价格类型不可以为空！");                                                             
		document.form1.price_type.focus();                                                    
		return false;                                                                            
	}                                                                                       
 	    return true;
 }
     function addProductInfocheck_none(current_obj)
    {
            if (current_obj.advshow.checked)
            {
        	    current_obj.submit1.disabled=false;        	     
        	}
        	else
        	{
        	    current_obj.submit1.disabled=true;
        	}
    	}
    	function exit()
    	{
    	    window.close();
    	}
    	function addProductInfoconfirmsub(formobj)
    	{
    	    if(window.confirm('你确定要提交吗？')) 
    	    {
    	        if (!addProductInfoCheck_Value())
    	        {
    	             return;
    	        }    	            	           
    	        formobj.submit();    	         
    	    }
    	    else
    	    {
    	        return;
    	    }
    	}
    	function   isNum(str)
	{   
	  return   (str.search(/^\d+(\.\d+)?$/)!=-1);   
	}  
	
//dowPproductList.jsp
  function dowPproductListchechIfo()
  {
	   if(confirm('是否确认注销本条记录？')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }
  
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

// modifyProductInfo.jsp
	function modifyProductInfoCheck_Value()
	{
	    if (cTrim(document.form1.commodity_name.value,0) == "" || document.form1.commodity_name.value == null) 
		{                                                                                         
			alert("商品名称不可以为空！");                                                             
			document.form1.commodity_name.focus();                                                    
			return false;                                                                            
		}                                                                                      
		if (cTrim(document.form1.commodity_unit.value,0) == "" || document.form1.commodity_unit.value == null) 
		{                                                                                         
			alert("计价单位不可以为空！");                                                             
			document.form1.commodity_unit.focus();                                                    
			return false;                                                                            
		}                                                                                        
		if (cTrim(document.form1.sale_market.value,0) == "" || document.form1.sale_market.value == null) 
		{                                                                                         
			alert("销售地点不可以为空！");                                                             
			document.form1.sale_market.focus();                                                    
			return false;                                                                            
		}                                                                                      
		if (cTrim(document.form1.commodity_type.value,0) == "" || document.form1.commodity_type.value == null) 
		{                                                                                         
			alert("商品分类不可以为空！");                                                             
			document.form1.commodity_type.focus();                                                    
			return false;                                                                            
		}                                                                                      
		if (content.getText()=="" || document.form1.content.value == null) 
		{                                                                                         
			alert("说明不可以为空！");                                                             
			document.form1.content.focus();                                                    
			return false;                                                                            
		}                                                                                      
		if (cTrim(document.form1.commodity_brand.value,0) == "" || document.form1.commodity_brand.value == null) 
		{                                                                                         
			alert("品牌不可以为空！");                                                             
			document.form1.commodity_brand.focus();                                                    
			return false;                                                                            
		}                                                                                        
		if (cTrim(document.form1.commodity_price.value,0) == "" || document.form1.commodity_price.value == null) 
		{                                                                                         
			alert("原价不可以为空！");                                                             
			document.form1.commodity_price.focus();                                                    
			return false;                                                                            
		} 
		 else if(! isNum(document.form1.commodity_price.value))
		{
			alert("请输入正确的数字！");
			document.form1.commodity_price.focus(); 
			return false;
		}
		if (cTrim(document.form1.sale_price.value,0) == "" || document.form1.sale_price.value == null) 
		{                                                                                         
			alert("价格不可以为空！");                                                             
			document.form1.sale_price.focus();                                                    
			return false;                                                                            
		}
		else if(! isNum(document.form1.sale_price.value))
		{
			alert("请输入正确的数字！");
			document.form1.sale_price.focus(); 
			return false;
		}                                                                                                   
		if (cTrim(document.form1.trade_type_code.value,0) == "" || document.form1.trade_type_code.value == null) 
		{                                                                                         
			alert("TRADE_TYPE_CODE不可以为空！");                                                             
			document.form1.trade_type_code.focus();                                                    
			return false;                                                                            
		}                                                                                     
		if (cTrim(document.form1.price_type.value,0) == "" || document.form1.price_type.value == null) 
		{                                                                                         
			alert("价格类型不可以为空！");                                                             
			document.form1.price_type.focus();                                                    
			return false;                                                                            
		}                                                                                       
	 	    return true;
	}
     function check_none(current_obj)
    {
            if (current_obj.advshow.checked)
            {
        	    current_obj.submit1.disabled=false;        	     
        	}
        	else
        	{
        	    current_obj.submit1.disabled=true;
        	}
    	}
    	function exit()
    	{
    	    window.close();
    	}
    	function modifyProductInfoconfirmsub(formobj)
    	{
    	    if(window.confirm('你确定要提交吗？')) 
    	    {
    	        if (!modifyProductInfoCheck_Value())
    	        {
    	             return;
    	        }    	            	           
    	        formobj.submit();    	         
    	    }
    	    else
    	    {
    	        return;
    	    }
    	}
    	
//specCommList.jsp
  function specCommListchechIfo()
  {
	   if(confirm('是否确认推荐该商品？')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }