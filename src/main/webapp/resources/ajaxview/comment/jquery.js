$('#btnComSend').on('click', process);


function process() {
	$.ajax({
		type : 'post',
		dataType : 'text',
		data : {comContent: $('#comContent').val()},
		url : 'test.do',
		success : viewMessage
	});
	console.log("good");
	

};

function viewMessage(commentview){
	$('#commentView').html(commentview);
};