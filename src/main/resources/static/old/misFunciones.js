function traerDatosCategoria() {
    $.ajax({
        url: "http://129.80.9.51:8080/api/Category/all",
        type: 'GET',
        dataType: "json",
        success: function (respuesta){
            pintarDatos(respuesta);
        },
        error: function (respuesta, xhr){
            alert("Error de peticion");
        }
    });
}

function pintarDatos(datos) {
    let html = "";
    html += "<tr>";
    Object.keys(datos[0]).forEach(element =>{
        html += "<th>"+element+"</th>"});
    html += "</tr>";

    for (let i = 0; i < datos.length; i++) {
        html += "<tr>";
        Object.values(datos[i]).forEach(element =>{
            if(typeof (element) == 'object') {
                html += "<td>" + element[0].name + "</td>";
            } else {
                html += "<td>" + element + "</td>";
            }
        });
        html += "</tr>";
    }

    $("#tblCategorias").empty();
    $("#tblCategorias").append(html);
}