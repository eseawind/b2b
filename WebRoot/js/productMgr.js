//addProductInfo.jsp
function addProductInfoCheck_Value()
{
    if (cTrim(document.form1.commodity_name.value,0) == "" || document.form1.commodity_name.value == null) 
	{                                                                                         
		alert("��Ʒ���Ʋ�����Ϊ�գ�");                                                             
		document.form1.commodity_name.focus();                                                    
		return false;                                                                            
	}                                                                                      
	if (cTrim(document.form1.commodity_unit.value,0) == "" || document.form1.commodity_unit.value == null) 
	{                                                                                         
		alert("�Ƽ۵�λ������Ϊ�գ�");                                                             
		document.form1.commodity_unit.focus();                                                    
		return false;                                                                            
	}                                                                                        
	if (cTrim(document.form1.sale_market.value,0) == "" || document.form1.sale_market.value == null) 
	{                                                                                         
		alert("���۵ص㲻����Ϊ�գ�");                                                             
		document.form1.sale_market.focus();                                                    
		return false;                                                                            
	}                                                                                      
	if (cTrim(document.form1.commodity_type.value,0) == "" || document.form1.commodity_type.value == null) 
	{                                                                                         
		alert("��Ʒ���಻����Ϊ�գ�");                                                             
		document.form1.commodity_type.focus();                                                    
		return false;                                                                            
	}                                                                                      
	if (content.getText()=="" || document.form1.content.value == null) 
	{                                                                                         
		alert("˵��������Ϊ�գ�");                                                             
		document.form1.content.focus();                                                    
		return false;                                                                            
	}                                                                                      
	if (cTrim(document.form1.commodity_brand.value,0) == "" || document.form1.commodity_brand.value == null) 
	{                                                                                         
		alert("Ʒ�Ʋ�����Ϊ�գ�");                                                             
		document.form1.commodity_brand.focus();                                                    
		return false;                                                                            
	}                                                                                        
	if (cTrim(document.form1.commodity_price.value,0) == "" || document.form1.commodity_price.value == null) 
	{                                                                                         
		alert("ԭ�۲�����Ϊ�գ�");                                                             
		document.form1.commodity_price.focus();                                                    
		return false;                                                                            
	} 
	 else if(! isNum(document.form1.commodity_price.value))
	{
		alert("��������ȷ�����֣�");
		document.form1.commodity_price.focus(); 
		return false;
	}
	if (cTrim(document.form1.sale_price.value,0) == "" || document.form1.sale_price.value == null) 
	{                                                                                         
		alert("�۸񲻿���Ϊ�գ�");                                                             
		document.form1.sale_price.focus();                                                    
		return false;                                                                            
	}
	else if(! isNum(document.form1.sale_price.value))
	{
		alert("��������ȷ�����֣�");
		document.form1.sale_price.focus(); 
		return false;
	}                                                                                                   
	if (cTrim(document.form1.trade_type_code.value,0) == "" || document.form1.trade_type_code.value == null) 
	{                                                                                         
		alert("TRADE_TYPE_CODE������Ϊ�գ�");                                                             
		document.form1.trade_type_code.focus();                                                    
		return false;                                                                            
	}                                                                                     
	if (cTrim(document.form1.price_type.value,0) == "" || document.form1.price_type.value == null) 
	{                                                                                         
		alert("�۸����Ͳ�����Ϊ�գ�");                                                             
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
    	    if(window.confirm('��ȷ��Ҫ�ύ��')) 
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
	   if(confirm('�Ƿ�ȷ��ע��������¼��')) 
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
			alert("��Ʒ���Ʋ�����Ϊ�գ�");                                                             
			document.form1.commodity_name.focus();                                                    
			return false;                                                                            
		}                                                                                      
		if (cTrim(document.form1.commodity_unit.value,0) == "" || document.form1.commodity_unit.value == null) 
		{                                                                                         
			alert("�Ƽ۵�λ������Ϊ�գ�");                                                             
			document.form1.commodity_unit.focus();                                                    
			return false;                                                                            
		}                                                                                        
		if (cTrim(document.form1.sale_market.value,0) == "" || document.form1.sale_market.value == null) 
		{                                                                                         
			alert("���۵ص㲻����Ϊ�գ�");                                                             
			document.form1.sale_market.focus();                                                    
			return false;                                                                            
		}                                                                                      
		if (cTrim(document.form1.commodity_type.value,0) == "" || document.form1.commodity_type.value == null) 
		{                                                                                         
			alert("��Ʒ���಻����Ϊ�գ�");                                                             
			document.form1.commodity_type.focus();                                                    
			return false;                                                                            
		}                                                                                      
		if (content.getText()=="" || document.form1.content.value == null) 
		{                                                                                         
			alert("˵��������Ϊ�գ�");                                                             
			document.form1.content.focus();                                                    
			return false;                                                                            
		}                                                                                      
		if (cTrim(document.form1.commodity_brand.value,0) == "" || document.form1.commodity_brand.value == null) 
		{                                                                                         
			alert("Ʒ�Ʋ�����Ϊ�գ�");                                                             
			document.form1.commodity_brand.focus();                                                    
			return false;                                                                            
		}                                                                                        
		if (cTrim(document.form1.commodity_price.value,0) == "" || document.form1.commodity_price.value == null) 
		{                                                                                         
			alert("ԭ�۲�����Ϊ�գ�");                                                             
			document.form1.commodity_price.focus();                                                    
			return false;                                                                            
		} 
		 else if(! isNum(document.form1.commodity_price.value))
		{
			alert("��������ȷ�����֣�");
			document.form1.commodity_price.focus(); 
			return false;
		}
		if (cTrim(document.form1.sale_price.value,0) == "" || document.form1.sale_price.value == null) 
		{                                                                                         
			alert("�۸񲻿���Ϊ�գ�");                                                             
			document.form1.sale_price.focus();                                                    
			return false;                                                                            
		}
		else if(! isNum(document.form1.sale_price.value))
		{
			alert("��������ȷ�����֣�");
			document.form1.sale_price.focus(); 
			return false;
		}                                                                                                   
		if (cTrim(document.form1.trade_type_code.value,0) == "" || document.form1.trade_type_code.value == null) 
		{                                                                                         
			alert("TRADE_TYPE_CODE������Ϊ�գ�");                                                             
			document.form1.trade_type_code.focus();                                                    
			return false;                                                                            
		}                                                                                     
		if (cTrim(document.form1.price_type.value,0) == "" || document.form1.price_type.value == null) 
		{                                                                                         
			alert("�۸����Ͳ�����Ϊ�գ�");                                                             
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
    	    if(window.confirm('��ȷ��Ҫ�ύ��')) 
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
	   if(confirm('�Ƿ�ȷ���Ƽ�����Ʒ��')) 
	{
		return true;
	}
	else
	{
		return false;
	}
  }