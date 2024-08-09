$(document).on("click","#btnagregar",function(){
    $("#txtnombrecargo").val("");
    $("#hddcodcargo").val("0");
    $("#modalcargo").modal("show");
})


$(document).on("click",".btnactualizar",function(){
    $("#txtnombrecargo").val($(this).attr("data-cargonom"));
    $("#hddcodcargo").val($(this).attr("data-cargocode"));
    listarCargos();
    $("#modalcargo").modal("show");
});


$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"POST",
        url:"/cargo/registrar",
        contentType:"application/json",
        data: JSON.stringify({
            codcargo: $("#hddcodcargo").val(),
            nombrecargo: $("#txtnombrecargo").val(),
        }),
        success: function(resultado){
            if(resultado.resultado){
                listarCargos()
            }
            alert(resultado.mensaje)
        }
    });
    $("#modalcargo").modal("hide");
});





function listarCargos(){
    $.ajax({
        type: "GET",
        url: "/cargo/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblproduct > tbody").html("")
            $.each(resultado, function(index, value){
                $("#tblproduct > tbody").append("<tr>"+
                `<td>${value.codcargo}</td>`+
                `<td>${value.nombrecargo}</td>`+
                `<td><button type="button" class="btn btn-info btnactualizar" `+
                ` data-cargocode="${value.codcargo}" `+
                ` data-cargonom="${value.nombrecargo}">Actualizar</button></td></tr>`
                )

            })
        }
    })
}
