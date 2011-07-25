      <script>
		             function getSelectedText(value){
		             var key_location=value;
		             var data = Math.round(Math.random() * 10000);
		             var myAjax = new Ajax.Updater('price2','price.jsp?&key_location='+ key_location,
					{
						method : 'get',
						evalScripts: true
					});
				 }
		</script>