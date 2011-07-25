<%@ page contentType="text/html;charset=GBK" %>

<%

    String menu_ids = "";

	if (request.getParameter("menu_id") != null) {

		menu_ids = request.getParameter("menu_id");

	}

%>

</br>

<div class="line1">『bizoss』客户服务中心提示</div>

<div class="line2">	

    <%

        if (menu_ids.equals("y741UJS1SQ4dX48") || menu_ids.equals("RcEw88NYx3535O50QCT6"))

        {

    %>

    bizoss的这项功能您可以轻松的将您的建议、报告、请示、报表、计划等内容上报给您的上级组织或部门，相关文件可以通过附件形式上传

    <%

        }

        else if (menu_ids.equals("8Xp764Lv6H28moq"))

        {

    %>

    通过该功能您可以方便快捷的对企业北部其它组织或部门上报的文件进行审批，与传统的文件审批流程相比效率明显提高。

    <%

        }        

        else if (menu_ids.equals("2PDC4335HW5583L"))

        {

    %>

    这项功能可以让您查询之前上报过且已被审批的文件，请点击下拉菜单选择您要查询的文件。

    <%

        }        

        else if (menu_ids.equals("H1I57c6rL2sIC8hs2oY8") || menu_ids.equals("8P2a1QwdK02jN8b"))

        {

    %>

    企业内部部门可以通过这种方式向下级组织或部门下达指示、精神等或下发文件进行学习，相关文件可以通过附件形式上传。

    <%

        }        

        else if (menu_ids.equals("teu721B0E4adLp8"))

        {

    %>

    您可以在此组织学习上级下达的文件，通过这项功能，你还可以方便的查阅上级下发过的文件。

    <%

        }        

        else if (menu_ids.equals("JVQ5ygmH471Hx77C5SX2") || menu_ids.equals("3dmi6G8uy312P0B"))

        {

    %>

    您可以通过该功能将有关文件转发给相关组织部门，相关部门可以在转发浏览中查询该文件的内容，这项功能适用于逐层传达的文件。

    <%

        }        

        else if (menu_ids.equals("0o16MbM2gl1323E"))

        {

    %>

    您可以在这里选择浏览其它部门转发过来的文件。

    <%

        }        

        else if (menu_ids.equals("v6Pbg32131e1740") || menu_ids.equals("V84b824xn7k473j"))

        {

    %>

    通过这项功能您可以向部门内部发布通知、公告，部门内部可以从通知浏览中浏览到相关内容。

    <%

        }        

        else if (menu_ids.equals("7t2wv641B7773gR"))

        {

    %>

    您可以在这里方便、快速的浏览到部门内部发布的通知。

    <%

        }        

        else if (menu_ids.equals("T8p8Utw4HUij7Q2"))

        {

    %>

    您可以在下拉菜单中删除过期、失效的通知。

    <%

        }        

        else if (menu_ids.equals("zshi1fk1CC81S11p") || menu_ids.equals("NliRe8Gs65Wa442823LD"))

        {

    %>

    bizoss的这项功能使企业内部各部门可以对企业公开的管理决策进行讨论，提出自己的意见和看法，让企业的管理更加民主化规范化。

    <%

        }        

        else if (menu_ids.equals("zshi2fk1CC81S11p") || menu_ids.equals("Xd2fk1CC81S11p"))

        {

    %>

    通过这项功能您可以把企业内部的政务、决策、决定公开化，让其它组织部门参与讨论，提出意见或看法，让企业管理更加民主化。

    <%

        }        

        else if (menu_ids.equals("yhonMB3k73nHkR4") || menu_ids.equals("5477404776E8581"))

        {

    %>

    bizoss这项功能旨在让您的企业作息管理更加方便规范，您可以在此登记您的考勤记录，包括上班签到、下班签退、外出工作、病假、事假、出差等。

    <%

        }

        else if (menu_ids.equals("84U74L47F5N2qPe"))

        {

    %>

    通过这项功能您可以查询您在一段时间内的考勤记录，请在对话框内输入开始时间及结束时间并点击“提交”按钮确认。

    <%

        }
            
        else if (menu_ids.equals("yhonMB3k73FFFF4"))

        {    

    %>
    
    通过这项功能您可以查询某部门在一段时间内的考勤记录，请选择部门后在对话框内输入开始时间及结束时间并点击“提交”按钮确认。
    
	<%

        }
        
    %>
</div>
</br>



