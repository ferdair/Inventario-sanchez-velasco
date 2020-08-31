function searchById(){
	var criteria = $("#nameinput").val();
	$.ajax({
		url : "/producto/search/" + criteria,
		method : 'GET',
		success : function(response){
			$("#productoid").empty();			
			var count = Object.keys(response).length;			
			if(count > 0){								
				$("#productoid").addClass('visible').removeClass('invisible');
				$.each( response, function(index, producto ) {					
					$("#productoid").append("<option value='"+ producto.id +"'>" + producto.nombre + "</option>");					
				});
			}
			else{
				$("#productoid").addClass('invisible').removeClass('visible');
				console.log("No existe este producto " + criteria);				
			}			
		},
		error : function(err){
			console.log(err);
		}		
	});
}

function create(){		
	$.ajax({
		url : "/menu_producto/create",
		method : 'GET',
		success : function(response){
			$("#contentFrmMenuProducto").empty();
			$("#contentFrmMenuProducto").html(response);

		},
		error : function(err){
			console.log(err);
		}		
	});
}

function list(){
	$.ajax({
		url: "/menu/products/",
		method:'GET',
		success: function(response){
			console.log(response)

			$("#listProductos").empty();
			$("#listProductos").html(response);
		
		},
		error: function(err){
			console.log(err);
		}
	});
}

function save(){	
	var dataForm = objectifyForm($("#frmMenuProducto").serializeArray());	
	var requestBody = JSON.stringify(dataForm);
	console.log(requestBody);			
	$.ajax({
		url : developURL + "menu/add",
		method : 'POST',
		contentType : "application/json",
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},		
		data : requestBody,
		success : function(response){
			console.log(response);			 
			list();
		},
		error : function(err){
			console.log(err);
		}		
	});
	
}


$(document).ready(function(){
	
	$("#btnAdd").click(function(){
		create();
	});
	
	list();
	
	$("#btnSubmit").click(function(){
		save();		
	});
	
});