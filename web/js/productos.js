function llenarFormulario(fila) {
    var id = $(fila).find(".id").text();
    var codigo = $(fila).find(".codigo").text();
    var nombre = $(fila).find(".nombre").text();
    var proveedores = $(fila).find(".proveedores").text();
    var stock = $(fila).find(".stock").text();
    var precio = $(fila).find(".precio").text();

    $("#txtId").val(id);
    $("#txtCodigo").val(codigo);
    $("#txtNombre").val(nombre);
    $("#txtProveedores").val(proveedores);
    $("#txtStock").val(stock);
    $("#txtPrecio").val(precio);

}

$(document).ready(function(){
    $('#mydataTable').DataTable();
    
    $("#exampleModal").on("hidden.bs.modal", function(){
        $('form')[0].reset();
        $("#txtCategoria option[selected]").removeAttr('selected');
    });
    
    $(document).on('click', '.btnEditar', function(){
        llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnEliminar', function(){
        llenarFormulario($(this).closest('tr'));
        $('.btnOcultar1').attr('disabled', 'disabled');
        $('.btnOcultar').removeAttr('disabled');
    });
    $(document).on('click', '.btnAdd', function(){
        $('.btnOcultar').attr('disabled', 'disabled');
        $('.btnOcultar1').removeAttr('disabled');
    });
});
