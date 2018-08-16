$(document).ready(function(){
	// alert(window.innerWidth);
	$("#title").width(window.innerWidth * 0.8);
	$("#begDate").calendar();
	$("#endDate").calendar();
})

let startDate;

$('#showTooltips').click(function(){
	let cardNo = $('#cardNo').val();
	let begDate = $('#begDate').val();
	let endDate = $('#endDate').val();
	if(!cardNo){
		$.toast('请输入病单号','forbidden');
		return false;
	}
	if(!begDate){
		$.toast('请选择开始日期','forbidden');
		return false;
	}
	if(!endDate){
		$.toast('请选择结束日期','forbidden');
		return false;
	}

	if(new Date(begDate)>new Date(endDate)){
		$.toast('日期输入有误','forbidden');
		return false;
	}

	$.showLoading();
	let send_data = {
		'cardNo':cardNo,
		'begDate':begDate,
		'endDate':endDate
	};
	$.ajax({
		type:'post',
		url:'http://127.0.0.1:8080/report/list',
//	url:'http://218.2.176.62:8099/WebService.asmx/GetLisInfo',
		contentType:'application/x-www-form-urlencoded',
		data:JSON.stringify(send_data),
    	dataType:'json',
		success:function(data){
			$.hideLoading();
			window.location = './list.html?cardNo=' + cardNo + '&begDate='+ begDate+ '&endDate=' + endDate; 
		},
		error:function(a,b){
			$.hideLoading();
			$.toast('输入信息有误','forbidden');
		}
	})

});


