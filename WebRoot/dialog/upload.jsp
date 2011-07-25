<html>
    <head>
 
 <%
   String filename ="";
   if (filename == "")
    out.println("<script>self.document.form1.up_pic.value='/UserFiles/smallImage/"+filename+"'</script>");
 %>
 
</head>
<body>
       
        <form name="form1" method="post" action="" target="_self">
       <input type=file name=up_file>
       <input name="up_pic" type="hidden" id="shop_pic" size="30" />
       <input type=submit value="开始上传文件" >
     </form>
</body>
</html>



