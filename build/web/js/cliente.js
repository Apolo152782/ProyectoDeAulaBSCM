
function llenarFormulario(fila){
    var id = $(fila).find(".id").text();
    var dni = $(fila).find(".dni").text();
    var nombre = $(fila).find(".nombre").text();
    var telefono = $(fila).find(".telefono").text();
    var direccion = $(fila).find(".direccion").text();
    var razon = $(fila).find(".razon").text();
    
    $("#txtId").val(id);
    $("#txtDni").val(dni); 
    $("#txtNombre").val(nombre);
    $("#txtTelefono").val(telefono);
    $("#txtDireccion").val(direccion);
    $("#txtRazon").val(razon); 
    
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
