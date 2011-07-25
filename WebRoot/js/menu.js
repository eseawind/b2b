function menu_display(t_id){//显示隐藏程序
        var t_id;//表格ID
        var i_id;//图片ID
        var on_img="../images/fold_2.gif";//打开时图片
        var off_img="../images/fold_1.gif";//隐藏时图片
                if (t_id.style.display == "none") {//如果为隐藏状态
                t_id.style.display="";//切换为显示状态
                //i_id.src=on_img;//换图
}
        else{//否则
                t_id.style.display="none";//切换为隐藏状态
                //i_id.src=off_img;
                }//换图

}
