function alertDeleteProducto(id) {
	
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
		    deleteProducto(id)
		  }
		})
}

function deleteProducto(id) {
	$.ajax({
		url : "/producto/delete/" + id,
		method : 'GET',
		success : function(response){
			Swal.fire(
		      'Producto eliminado',
		      'El Producto se ha eliminado con exito.',
		      'success'
		    ).then((result) => {
		    	location.reload();
			})		
		},
		error : function(err){
			Swal.fire(
		      'Ha ocurrido un error',
		      'No se ha podido eliminar el Producto, intente nuevamente.',
		      'warning'
		    )
			console.error(err);
		}		
	});
}