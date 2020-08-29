$('document').ready(function(){
	
	$('table #addButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
		
		$.get(href, function(list, status){
			$('#examid').val(list.manageExamid);
			$('#question');
			$('#optionA');
			$('#optionB');
			$('#optionC');
			$('#optionD');
			$('#answer');
			
			});					
		$('#addModal').modal();
		 
	});
	/*
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});
		*/
	
});