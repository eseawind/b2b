//---------获得表单的焦点------//
function MakeFocus(current_form) {
       var current_form;
       var temp_obj=current_form;
	   temp_obj.focus();
}
//---------定义trim、left、right方法------//
function trim_spaces(from_where){
       var temp_string=this;
	   if(arguments.length == 0){
	   from_where = "BOTH";
	   }
	   
	   if(from_where.toUpperCase() == "LEFT" || from_where == "BOTH"){
	          while (temp_string.left(1) == " ")
	             {
				  temp_string = temp_string.substring(1);
	              }
	   }
	   if(from_where.toUpperCase() == "RIGHT" || from_where == "BOTH"){
	          while (temp_string.right(1) == " ")
			     {
	              temp_string = temp_string.substring(0,temp_string.length-2);
	              }
	   
	   }
	   return temp_string;

}
function extract_left(total_chars){
       return this.substring(0,total_chars);

}
function extract_right(total_chars){
       return this.substring(this.length-total_chars)
}
//---------left方法从左边提取字符------//
String.prototype.left = extract_left;
//---------right方法从右边提取字符------//
String.prototype.right = extract_right;
//---------trim方法用来去掉字符串两边的空格------//
String.prototype.trim = trim_spaces;

//---------计算选择列表中被选择的条数，返回条数------//
function get_selections(current_list){
var selected_num=0;
var selected_value = new Array();
for (var counter=0;counter<current_list.options.length;counter++){
       if (current_list.options[counter].selected){
	       selected_value[selected_num]=current_list.options[counter].value;
	       selected_num++;
		   }
       }
	   return selected_value;
}

//---------检查数据是否为整型数据------//

function its_a_digit(character){
      var digit_characters = "0123456789";
	  if (digit_characters.indexOf(character) ==-1){
	  return false;
	  }
	  else return true;
}
function its_integer(string_value){
      for (var counter=0;counter<string_value.length;counter++){
	  current_char=string_value.charAt(counter);
	  if(!its_a_digit(current_char)){
	  return false;
	  }
	  }
	  return true;
}
 
//****************************************************************
// Description: sInputString 为输入字符串，iType为类型，分别为
// 0 - 去除前后空格; 1 - 去前导空格; 2 - 去尾部空格
//****************************************************************
function cTrim(sInputString,iType)
{
var sTmpStr = ' '
var i = -1

if(iType == 0 || iType == 1)
{
while(sTmpStr == ' ')
{
++i
sTmpStr = sInputString.substr(i,1)
}
sInputString = sInputString.substring(i)
}

if(iType == 0 || iType == 2)
{
sTmpStr = ' '
i = sInputString.length
while(sTmpStr == ' ')
{
--i
sTmpStr = sInputString.substr(i,1)
}
sInputString = sInputString.substring(0,i+1)
}
return sInputString
}
