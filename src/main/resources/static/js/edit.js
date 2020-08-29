$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
		
		$.get(href, function(list, status){
			$('#idEdit').val(list.manageExamid);
			$('#categoryEdit').val(list.category);
			$('#examnameEdit').val(list.examname);
			$('#examdateEdit').val(list.examdate);
			});					
		$('#editModal').modal();
	});
	/*
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});
		*/
	
	$('table #questionButton').on('click',function(event){
		window.location.href="addQuestion.html";
	});
});