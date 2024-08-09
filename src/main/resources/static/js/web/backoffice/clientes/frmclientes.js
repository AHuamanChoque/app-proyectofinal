$(document).on("click","#btnagregar",function(){
    $("#txtdnicli").val("");
    $("#txtnombrecli").val("");
    $("#txtapellidocli").val("");
    $("#txtcelular").val("");
    $("#txtcorreo").val("");
    $("#txtedad").val("");
    $("#txtsexo").val("");
    $("#txtdireccion").val("");
    $("#hddcodprove").val("0");
    listarClientes();

    $("#modalclientes").modal("show");
})


$(document).on("click",".btnactualizar",function(){
    $("#txtdnicli").val($(this).attr("data-clidni"));
    $("#txtnombrecli").val($(this).attr("data-clinombre"));
    $("#txtapellidocli").val($(this).attr("data-cliape"));
    $("#txtcelular").val($(this).attr("data-clicel"));
    $("#txtcorreo").val($(this).attr("data-clicorreo"));
    $("#txtedad").val($(this).attr("data-cliedad"));
    $("#txtsexo").val($(this).attr("data-clisex="));
    $("#txtdireccion").val($(this).attr("data-clidire"));
    $("#hddcodcli").val($(this).attr("data-clicod"));

    listarClientes();

    $("#modalclientes").modal("show");
});



$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"POST",
        url:"/clientes/registrar",
        contentType:"application/json",
        data: JSON.stringify({
            codclientes: $("#hddcodcli").val(),
            dnicli: $("#txtdnicli").val(),
            nombrecli: $("#txtnombrecli").val(),
            apellidocli: $("#txtapellidocli").val(),
            celularcli: $("#txtcelular").val(),
            correocli: $("#txtcorreo").val(),
            edadcli: $("#txtedad").val(),
            sexocli: $("#txtsexo").val(),
            direccioncli: $("#txtdireccion").val(),
        }),
        success: function(resultado){
            if(resultado.resultado){
                listarClientes()
            }
            alert(resultado.mensaje)
        }
    });
    $("#modalclientes").modal("hide");
});



function listarClientes(){
    $.ajax({
        type: "GET",
        url: "/clientes/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblproduct > tbody").html("")
            $.each(resultado, function(index, value){
                $("#tblproduct > tbody").append("<tr>"+
                `<td>${value.codclientes}</td>`+
                `<td>${value.dnicli}</td>`+
                `<td>${value.nombrecli}</td>`+
                `<td>${value.apellidocli}</td>`+
                `<td>${value.celularcli}</td>`+
                `<td>${value.correocli}</td>`+
                `<td>${value.edadcli}</td>`+
                `<td>${value.sexocli}</td>`+
                `<td>${value.direccioncli}</td>`+
                `<td><button type="button" class="btn btn-info btnactualizar" `+
                ` data-clicod="${value.codclientes}" `+
                ` data-clidni="${value.dnicli}" `+
                ` data-clinombre="${value.nombrecli}" `+
                ` data-cliape="${value.apellidocli}" `+
                ` data-clicel="${value.celularcli}" `+
                ` data-clicorreo="${value.correocli}" `+
                ` data-cliedad="${value.edadcli}" `+
                ` data-clisex="${value.sexocli}" `+
                ` data-clidire="${value.direccioncli}">Actualizar</button></td></tr>`

                )

            })
        }
    })
}