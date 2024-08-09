$(document).on("click","#btnagregar",function(){
    $("#txtrazonsocial").val("");
    $("#txtrucproveedor").val("");
    $("#txtelefonoproveedor").val("");
    $("#cbodescripcion").prop("checked",false);
    $("#hddcodprove").val("0");
    listarTipoProve($(this).attr("data-provecodtipo"));

    $("#modalproveedor").modal("show");
})


$(document).on("click",".btnactualizar",function(){
    $("#txtrazonsocial").val($(this).attr("data-proverazon"));
    $("#txtrucproveedor").val($(this).attr("data-proveruc"));
    $("#txtelefonoproveedor").val($(this).attr("data-provetelefono"));
    $("#hddcodprove").val($(this).attr("data-provecod"));
    $("#cbodescripcion").empty();
    listarTipoProve($(this).attr("data-provecodtipo"));

    $("#modalproveedor").modal("show");
});



$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"POST",
        url:"/proveedor/registrar",
        contentType:"application/json",
        data: JSON.stringify({
            codproveedor: $("#hddcodprove").val(),
            razonsocial: $("#txtrazonsocial").val(),
            rucproveedor: $("#txtrucproveedor").val(),
            telefonoproveedor: $("#txtelefonoproveedor").val(),
            codtipoprovee: $("#cbodescripcion").val()
        }),
        success: function(resultado){
            if(resultado.resultado){
                listarProveedores()
            }
            alert(resultado.mensaje)
        }
    });
    $("#modalproveedor").modal("hide");
});



function listarProveedores(){
    $.ajax({
        type: "GET",
        url: "/proveedor/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblproduct > tbody").html("")
            $.each(resultado, function(index, value){
                $("#tblproduct > tbody").append("<tr>"+
                `<td>${value.codproveedor}</td>`+
                `<td>${value.razonsocial}</td>`+
                `<td>${value.rucproveedor}</td>`+
                `<td>${value.telefonoproveedor}</td>`+
                `<td>${value.descripcion}</td>`+
                `<td><button type="button" class="btn btn-info btnactualizar" `+
                ` data-provecod="${value.codproveedor}" `+
                ` data-proverazon="${value.razonsocial}" `+
                ` data-proveruc="${value.rucproveedor}" `+
                ` data-provetelefono="${value.telefonoproveedor}" `+
                ` data-provecodtipo="${value.codtipoproveedor}">Actualizar</button></td></tr>`
                )

            })
        }
    })
}




function listarTipoProve(idtipoprov){
    $.ajax({
    type:"GET",
    url:"/tipoproveedor/listar",
    dataType:"json",
    success:function(resultado){
        $.each(resultado,function(index,value){
            $("#cbodescripcion").append(`<option value="${value.codtipoprovee}">${value.descripcion}</option>`)
        });
        if(idcate > 0)
            $("#cbodescripcion").val(idtipoprov);

    }
    });
}