function alertDeleteConsumo(id) {
	
	Swal.fire({
		  title: '¿Estás seguro?',
		  text : "Una vez eliminado, ¡no podrás recuperar este registro!" ,
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Sí, Eliminar!',
		  cancelButtonText: 'Cancelar'
		}).then((result) => {
		  if (result.value) {
		    deleteConsumo(id)
		  }
		})
}

function deleteConsumo(id) {
	$.ajax({
		url : "/consumo/delete/" + id,
		method : 'GET',
		success : function(response){
			Swal.fire(
		      'Consumo eliminado',
		      'El Consumo se ha eliminado con exito.',
		      'success'
		    ).then((result) => {
		    	location.reload();
			})		
		},
		error : function(err){
			Swal.fire(
		      'Ha ocurrido un error',
		      'No se ha podido eliminar el Menú, intente nuevamente.',
		      'warning'
		    )
			console.error(err);
		}		
	});
}