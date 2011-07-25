//searchResume.jsp
function searchResume()
{
	if($F('position')=='' && $F('degree')=='0' && $F('job_age')=='') {
		alert('请输入查询条件!');
		return false;
	}
}
//searchJob.jsp
function searchJob()
{
	if($F('job_type')=='0' && $F('job_addr')=='0' && $F('pub_date')=='0') {
		alert('请选择查询条件!');
		return false;
	}
}

