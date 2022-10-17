const urlVM = "http://132.145.209.209:8080"

function traerRooms() {
  $.ajax({
    url:  urlVM +"/api/Room/all",
    type: 'GET',
    dataType: "json",
    success: function (respuesta) {
      pintarRooms(respuesta);
    },
    error: function (respuesta, xhr) {
      alert("Error de peticion");
    }
  });
}

function pintarRooms(datos) {
  let html = "";

  html += "<thead>";
  html += "<tr>";
  html += "<th>Nombre</th>";
  html += "<th>Hotel</th>";
  html += "<th>Estrellas</th>";
  html += "<th>Descripcion</th>";
  html += "<th>Accion</th>";
  html += "</tr>";
  html += "</thead>";

  html += "<tbody>";

  for (dato of datos) {
    html += "<tr>"
    html += "<td>" + dato.name + "</td>";
    html += "<td>" + dato.hotel + "</td>";
    html += "<td>" + dato.stars + "</td>";
    html += "<td>" + dato.description + "</td>";
    html += "<td><button class='btn btn-outline-primary btn-sm' onclick='eliminarRoom(" + dato.idAdmin+")'>Eliminar</button></td>";
    html += "<tr>";

  }

  html += "</tbody>"

  $("#tblRooms").html(html);
}

function guardarRoom() {
  let datos = {
    name: $("#name").val(),
    email: $("#email").val(),
    password: $("#password").val(),
  };

  let dataToSend = JSON.stringify(datos);

  $.ajax({
    url: urlVM + "/api/Room/save",
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json',
    data: dataToSend,
    success: function (respuesta) {
      name: $("#name").val("");
      email: $("#hotel").val("");
      stars: $("#stars").val("");
      description: $("#description  ").val("");

      traerRooms();

    },
    error: function (respuesta, xhr) {
      alert("Error de peticion")
    }
  });
}

function eliminarRoom(id) {
  $.ajax({
  url: urlVM + "/api/Room/" + id,
    type: 'DELETE',

    success: function (respuesta) {
      confirm("El registro sera eliminado. Presione OK para eliminar")
      traerRooms();

    },
    error: function (respuesta, xhr) {
      alert("Error de peticion")
    }
  });

}