function searchById(){
	var criteria = $("#nameinput").val();
	$.ajax({
		url : "/menu/search/" + criteria,
		method : 'GET',
		success : function(response){
			$("#menuid").empty();			
			var count = Object.keys(response).length;			
			if(count > 0){								
				$("#menuid").addClass('visible').removeClass('invisible');
				$.each( response, function(index, menu ) {					
					$("#menuid").append("<option value='"+ menu.id +"'>" + menu.nombre + "</option>");					
				});
			}
			else{
				$("#menuid").addClass('invisible').removeClass('visible');
				console.log("No existe este menu " + criteria);				
			}			
		},
		error : function(err){
			console.log(err);
		}		
	});
}

function create(){		
	$.ajax({
		url : "/consumo_menu/create",
		method : 'GET',
		success : function(response){
			$("#contentFrmConsumoMenu").empty();
			$("#contentFrmConsumoMenu").html(response);

		},
		error : function(err){
			console.log(err);
		}		
	});
}

function list(){
	$.ajax({
		url: "/consumo/menues/",
		method:'GET',
		success: function(response){
console.log(response)
			$("#listMenus").empty();
			$("#listMenus").html(response);
		
		},
		error: function(err){
			console.log(err);
			console.log("list");

		}
	});
}

function save(){	
	var dataForm = objectifyForm($("#frmConsumoMenu").serializeArray());	
	var requestBody = JSON.stringify(dataForm);
	console.log(requestBody);
	$.ajax({
		url : developURL + "consumo/add",
		method : 'POST',
		contentType : "application/json",
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},		
		data : requestBody,
		success : function(response){
			console.log(response);			 
			list();
		},
		error : function(err){
			console.log("save")
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