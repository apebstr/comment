	$(document).ready(function() {
		$('#list').click(function(){
			$('#frm').attr('action', 'list.do').submit();
		});	
		
		$('#answer').click(function(){
			$('#frm').attr('action', 'write.do').submit();
		});
		
		$('#update').click(function(){
			$('#frm').attr('action', 'update.do').submit();
		});
		
		$('#delete').click(function(){
			$('#frm').attr('action', 'delete.do').submit();
		});
		

		$('#btnComSend').on('click',process);
	});
	
	console.log('jquery');

		function process() {
			$.ajax({
				type : 'POST',
				dataType : 'text',
				data : {comContent:$('#comContent').val()},
				url : 'view.do',
				success : viewMessage
			});
			console.log($('#comContent').val());
		};

		function viewMessage(res) {
			$('#commentView').html(res);
			console.log("viewMessage");
		};

