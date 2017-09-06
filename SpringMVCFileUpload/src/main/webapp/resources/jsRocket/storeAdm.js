$(document).ready(function(){
	
	// Activated the table
	var tableStore = $('#tableStore').DataTable({
		"autoWidth": false,
		"columnDefs": [
			{"targets": [ 0 ],
		     "visible": false,
		     "searchable": false}
		],
		"ajax": {
			"url": "/SpringMVCFileUpload/getAllStores",
			"type": "POST",
			"success" :  function(data){
				$.each(data, function(ind, obj){
					
					tableStore.row.add([
						obj.strId,
						"<input type='checkbox' value='"+obj.strId+"' id=''>",
						obj.strNumber,
						obj.strCountryCode,
						obj.strName
					]).draw();
				});
			}
		},
	});
	
	$(window).load(function() {
		
	});
	
	$("#buttonSearch").click(function(){
		tableStore.clear().draw();
		tableStore.ajax.reload();
		
	});
	
	$("#buttonInsert").click(function(){
		$(this).callAjax("insertStore", "");
		
		$(".form-control").val("");

	});
	
	$("#buttonDelete").click(function(){
		
		var valuesChecked = $("#tableStore input[type='checkbox']:checkbox:checked").map(
			     					function () {
			     						return this.value;
			     					}).get().join(",");
		
		$(this).callAjax("deleteStore", valuesChecked);
		
	});
	
	$.fn.callAjax = function( method, checkeds ){
		$.ajax({
			type: "POST",
			url: "/SpringMVCFileUpload/" + method,
			dataType: "json",
			timeout : 100000,
			data: { storeNumber: $("#storeNumber").val(), countryCode: $("#countryCode").val(), storeName: $("#storeName").val(), checked: checkeds },
			
			success: function(data){
				tableClient.clear().draw();
				tableClient.ajax.reload();
			},
			error: function(e){
				alert("ERROR: ", e);
			}
		});
	} 
	 
});
