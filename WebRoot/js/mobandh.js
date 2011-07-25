// 自动加载脚本

window.onload = function() 
{
	var strUrl = top.location.href;
	if (strUrl != null && strUrl != "") 
	{
		if (strUrl.indexOf("supply") > 0) {
			$("top_dh2").className = "dh";
			$("top_dh1").className = "dh";
			$("top_dh3").className = "dh";
			$("top_dh4").className = "dh";
			$("top_dh5").className = "dh";
			$("top_dh6").className = "dh";
			$("top_dh7").className = "dh";
			$("top_dh8").className = "dhse";
			$("top_dh9").className = "dh";
		} else if (strUrl.indexOf("credit") > 0) {
			$("top_dh2").className = "dh";
			$("top_dh1").className = "dh";
			$("top_dh3").className = "dh";
			$("top_dh4").className = "dh";
			$("top_dh5").className = "dh";
			$("top_dh6").className = "dh";
			$("top_dh7").className = "dhse";
			$("top_dh8").className = "dh";
			$("top_dh9").className = "dh";
		} else if (strUrl.indexOf("stock") > 0) {
			$("top_dh2").className = "dh";
			$("top_dh1").className = "dh";
			$("top_dh3").className = "dh";
			$("top_dh4").className = "dh";
			$("top_dh5").className = "dh";
			$("top_dh6").className = "dhse";
			$("top_dh7").className = "dh";
			$("top_dh8").className = "dh";
			$("top_dh9").className = "dh";
		} else if (strUrl.indexOf("active") > 0) {
			$("top_dh2").className = "dh";
			$("top_dh1").className = "dh";
			$("top_dh3").className = "dh";
			$("top_dh4").className = "dh";
			$("top_dh5").className = "dhse";
			$("top_dh6").className = "dh";
			$("top_dh7").className = "dh";
			$("top_dh8").className = "dh";
			$("top_dh9").className = "dh";
		} else if (strUrl.indexOf("techo") > 0) {
			$("top_dh5").className = "dh";
			$("top_dh1").className = "dh";
			$("top_dh2").className = "dh";
			$("top_dh3").className = "dh";
			$("top_dh4").className = "dhse";
			$("top_dh6").className = "dh";
			$("top_dh7").className = "dh";
			$("top_dh8").className = "dh";
			$("top_dh9").className = "dh";
		} else if (strUrl.indexOf("product") > 0) {
			$("top_dh1").className = "dh";
			$("top_dh2").className = "dh";
			$("top_dh3").className = "dhse";
			$("top_dh4").className = "dh";
			$("top_dh5").className = "dh";
			$("top_dh6").className = "dh";
			$("top_dh7").className = "dh";
			$("top_dh8").className = "dh";
			$("top_dh9").className = "dh";
		} else if (strUrl.indexOf("resume") > 0) {
			$("top_dh7").className = "dh";
			$("top_dh1").className = "dh";
			$("top_dh2").className = "dhse";
			$("top_dh3").className = "dh";
			$("top_dh4").className = "dh";
			$("top_dh5").className = "dh";
			$("top_dh6").className = "dh";
			$("top_dh8").className = "dh";
			$("top_dh9").className = "dh";
		} else if (strUrl.indexOf("leavel") > 0) {
				$("top_dh1").className = "dhse";
				$("top_dh2").className = "dh";
				$("top_dh3").className = "dh";
				$("top_dh4").className = "dh";
				$("top_dh5").className = "dh";
				$("top_dh6").className = "dh";
				$("top_dh7").className = "dh";
				$("top_dh8").className = "dh";
				$("top_dh9").className = "dh";
		} else {
			$("top_dh9").className = "dhse";
		}
		
		
	} 
	else 
	{
		$("top_dh9").className = "dhse";
	}
	 
}

 
