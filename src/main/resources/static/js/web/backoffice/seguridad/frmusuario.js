$(document).on("click", "#btnagregar", function(){
    $("#txtnombre").val("")
    $("#txtapellido").val("")
    $("#txtemail").val("")
    $("#txtusuario").val("")
    $("#switchusuario").hide()
    $("#hddidusuario").val("0")
    $("#txtusuario").prop("readonly", false)
    $("#txtemail").prop("readonly", false)
    $("#divmensajepassword").show()
    $("#cbactivo").prop("checked", false)
    $("#btnenviar").hide()
    $("#modalNuevo").modal("show")
})



$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/seguridad/usuario",
        contentType: "application/json",
        data: JSON.stringify({
            idusuario: $("#hddidusuario").val(),
            nombreusuario: $("#txtnombre").val(),
            apellidosusuario: $("#txtapellido").val(),
            correousuario: $("#txtemail").val(),
            activo: $("#cbactivo").prop("checked"),
            nickusuario: $("#txtusuario").val()
        }),
        success: function(resultado){
            if(resultado.resultado){
                listarUsuarios()
            }
            alert(resultado.mensaje)
        }
    });
    $("#modalNuevo").modal("hide");
})





/*
function listarUsuarios(){
    $.ajax({
        type: "GET",
        url: "/seguridad/usuario",
        dataType: "json",
        success: function(resultado){
            $("#tblusuarios > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblusuarios > tbody").append("<tr>"+
                `<td>${value.idusuario}</td>`+
                `<td>${value.nombreusuario}</td>`+
                `<td>${value.apellidosusuario}</td>`+
                `<td>${value.correousuario}</td>`+
                `<td>${value.activo}</td>`+
                `<td><button type="button" class="btn btn-info btnactualizar" `+
                ` data-idusuario="${value.idusuario}">Actualizar`+
                `</button></td></tr>`)

            })
        }
    })
}

*/