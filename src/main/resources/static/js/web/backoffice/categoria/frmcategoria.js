$(document).on("click","#btnagregar",function(){
    $("#txtnombrecategoria").val("");
    $("#hddcodcate").val("0");
    $("#modalcategoria").modal("show");
})




$(document).on("click",".btnactualizar",function(){
    $("#txtnombrecategoria").val($(this).attr("data-catnombre"));
    $("#hddcodcate").val($(this).attr("data-catcode"));
    listarCategorias();
    $("#modalcategoria").modal("show");
});



$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"POST",
        url:"/categoria/registrar",
        contentType:"application/json",
        data: JSON.stringify({
            codcategoria: $("#hddcodcate").val(),
            nombrecategoria: $("#txtnombrecategoria").val(),
        }),
        success: function(resultado){
            if(resultado.resultado){
                listarCategorias()
            }
            alert(resultado.mensaje)
        }
    });
    $("#modalcategoria").modal("hide");
});


function listarCategorias(){
    $.ajax({
        type: "GET",
        url: "/categoria/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblproduct > tbody").html("")
            $.each(resultado, function(index, value){
                $("#tblproduct > tbody").append("<tr>"+
                `<td>${value.codcategoria}</td>`+
                `<td>${value.nombrecategoria}</td>`+
                `<td><button type="button" class="btn btn-info btnactualizar" `+
                ` data-catcode="${value.codcategoria}" `+
                ` data-catnombre="${value.nombrecategoria}">Actualizar</button></td></tr>`
                )

            })
        }
    })
}