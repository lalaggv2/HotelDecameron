const urlVM = "http://132.145.209.209"

function traerRooms() {
  $.ajax({
    url: "http://localhost:8080/api/Room/all",
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
  html += "<th>Correo</th>";
  html += "</tr>";
  html += "</thead>";

  html += "<tbody>";

  for (dato of datos) {
    html += "<tr>"
    html += "<td>" + dato.name + "</td>";
    html += "<td>" + dato.email + "</td>";
    html += "<tr>";

  }

  html += "</tbody>"

  $("#tblClients").html(html);
}

function guardarRoom() {
  let datos = {
    name: $("#name").val(),
    email: $("#email").val(),
    password: $("#password").val(),
  };

  let dataToSend = JSON.stringify(datos);

  $.ajax({
    url: "http://localhost:8080/api/Room/save",
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json',
    data: dataToSend,
    success: function (respuesta) {
      name: $("#name").val("");
      email: $("#email").val("");
      password: $("#password").val("");
      traerClients();

    },
    error: function (respuesta, xhr) {
      alert("Error de peticion")
    }
  });
}

function eliminarAdmin(idAdmin) {
  $.ajax({
  url: "http://localhost:8080/api/Admin/" + idAdmin,
    type: 'DELETE',

    success: function (respuesta) {
      traerAdmins();

    },
    error: function (respuesta, xhr) {
      alert("Error de peticion")
    }
  });

}