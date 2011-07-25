//mutilPriceInfo.jsp
	function checkThis(val){
			var size = document.getElementById('size').value;
			var all = '';
			for(var i=0;i<size;i++){
				var obj = 'goods_name'+i;
				if(document.getElementById(obj).checked){
					all = all+document.getElementById(obj).value+'|';
				}
				document.getElementById('allValue').value=all;
			}
		}
		function checkAllGoods(){	
		    var all = '';
			var size = document.getElementById('size').value;
			if(document.getElementById('checkAll').checked){
				for(var i=0;i<size;i++){
					var obj = 'goods_name'+i;
					document.getElementById(obj).checked = true;
					all = all+document.getElementById(obj).value+'|';
				}
				document.getElementById('allValue').value=all;
			}else{
			   for(var i=0;i<size;i++){
					var obj = 'goods_name'+i;
					document.getElementById(obj).checked = false;
				}
				document.getElementById('allValue').value="";
			}
		}
		function confirmsub(){
			if(document.getElementById("price_code").value=="" ||document.getElementById("price_code").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请填写报价单！");
		     return false;
		   }
		   if(document.getElementById("product_id").value=="" ||document.getElementById("product_id").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请选择产品！");
		     return false;
		   }
		   if(document.getElementById("price_type").value=="" ||document.getElementById("price_type").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请选择产品类型！");
		     return false;
		   }
		   if(document.getElementById("price").value=="" ||document.getElementById("price").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请填写价格！");
		     return false;
		   }
		   
		}
		
		function modiEpriceconfirmsub(){
			if(document.getElementById("price_code").value=="" ||document.getElementById("price_code").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请填写报价单！");
		     return false;
		   }
		   if(document.getElementById("product_id").value=="" ||document.getElementById("product_id").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请选择产品！");
		     return false;
		   }
		   if(document.getElementById("price_type").value=="" ||document.getElementById("price_type").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请填写价格类型！");
		     return false;
		   }
		   if(document.getElementById("price").value=="" || document.getElementById("price").value==null){
		     Ext.MessageBox.alert("bizoss 提示","请填写价格！");
		     return false;
		   }
		   
		}
		function selectGoods(val){
		   if(val!="0"){
		   	var cust_id =$F('cust_id');
		   	SalePriceInfo.getMoreGoods(cust_id,val,setData);
		  }else{
		  		document.getElementById("goods_name").value='';
			    document.getElementById("price_type").value='';
			    document.getElementById("price").value= '';
			    document.getElementById("start_date").value= '';
			    document.getElementById("ent_date").value= '';
			    document.getElementById("price_desc").value= '';
			    document.getElementById("remark").value= '';
		  }
		}
		function setData(arrayList){
			var goods_name='';
		   for(var i=0;i<arrayList.length;i++){
			    var Map=$H(arrayList[i]);
			    var goods_name1=Map.get('goods_name');
				var price_type=Map.get('price_type');
			   	var price=Map.get('price');
			    var start_date1=Map.get('start_date');
			    var start_date2 = start_date1.getYear()+'-'+(start_date1.getMonth()+1);
			    var start_date  = start_date2 +'-'+start_date1.getDate();
			    var ent_date1=Map.get('ent_date');
			    var ent_date2 =  ent_date1.getYear()+'-'+(ent_date1.getMonth()+1);
			    var ent_date  = ent_date2 +'-'+ent_date1.getDate();
			    var price_desc=Map.get('price_desc');
			    var remark=Map.get('remark');
		
			    document.getElementById("price_type").value=price_type;
			    document.getElementById("price").value= price;
			    document.getElementById("start_date").value= start_date;
			    document.getElementById("ent_date").value= ent_date;
			    document.getElementById("price_desc").value= price_desc;
			    document.getElementById("remark").value= remark;
			    goods_name=goods_name+'┣'+goods_name1+'\n';
		    }
		    
		     document.getElementById("goods_name").value=goods_name;
		}
		