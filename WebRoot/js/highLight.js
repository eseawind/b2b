window.onload = function() {
	$("date-time").innerHTML = getDate();
	var strUrl = top.location.href;
	if (strUrl != null && strUrl != "") 
	{	

		if (strUrl.indexOf("supply") > 0) 
		{
			$("supply").checked = true;
			$("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(1);
		}
		 else if (strUrl.indexOf("stock") > 0) 
		{
			$("stock").checked = true;
	    $("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(2);
		} else if (strUrl.indexOf("calalogList.jsp") > 0) {
			$("calalogList.jsp").checked = true;
		  $("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(3);
		} else if (strUrl.indexOf("enterprise") > 0) {
			$("enterprise").checked = true;
    	$("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(4);
		} else if (strUrl.indexOf("disTest") > 0) {
			$("disTest").checked = true;
		  $("dis12").className = "top3";
		 	$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(5);
		} else if (strUrl.indexOf("#") > 0) {
			$("#").checked = true;
	    $("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(6);
		} else if (strUrl.indexOf("#") > 0) {
			$("/").checked = true;
			$("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(7);
		} else if (strUrl.indexOf("news") > 0) {
			$("news").checked = true;
    	$("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(8);
		} else if (strUrl.indexOf("news") > 0) {
			$("news").checked = true;
	    $("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(9);
		} else if (strUrl.indexOf("school") > 0) {
			$("school").checked = true;
	    $("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(10);
		} else if (strUrl.indexOf("talents") > 0) {
			$("talents").checked = true;
	    $("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			setAdervtise(11);
		} else if (strUrl.indexOf("/") > 0) {
			if($("top_dh12")!=null){
	    $("dis12").className = "top3";
			$("dis11").className = "top3";
			$("dis10").className = "top3";
			$("dis9").className = "top3";
			$("dis8").className = "top3";
			$("dis7").className = "top3";
			$("dis6").className = "top3";
			$("dis5").className = "top3";
			$("dis4").className = "top3";
			$("dis3").className = "top3";
			$("dis2").className = "top3";
			$("dis1").className = "top3";
			}
		} else {
			 
			$("top_dh0").className = "top4";
			setAdervtise(0);
			getStockImage('img-1',1);
			getStockImage('img-2',2);
			getStockContent('stock-12');
			sendLeave( 'leaveWords' );
		}
	} else {
		 
		$("top_dh0").className = "top4";
		setAdervtise(0);
		getStockImage('img-1',1);
		getStockImage('img-2',2);
		getStockContent('stock-12');
		sendLeave( 'leaveWords' );
	}
}