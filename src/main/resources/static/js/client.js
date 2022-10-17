const urlVM = "http://132.145.209.209"

function traerClients() {
  $.ajax({
    url: "http://localhost:8080/api/Client/all",
    type: 'GET',
    dataType: "json",
    success: function (respuesta) {
      pintarClients(respuesta);
    },
    error: function (respuesta, xhr) {
      alert("Error de peticion");
    }
  });
}

function pintarClients(datos) {
  let html = "";

  html += "<thead>";
  html += "<tr>";
  html += "<th>Nombre</th>";
  html += "<th>Correo</th>";
  html += "<th>Edad</th>";
  html += "</tr>";
  html += "</thead>";

  html += "<tbody>";

  for (dato of datos) {
    html += "<tr>"
    html += "<td>" + dato.name + "</td>";
    html += "<td>" + dato.email + "</td>";
    html += "<td>" + dato.email + "</td>";
    html += "<tr>";

  }

  html += "</tbody>"

  $("#tblClients").html(html);
}

function Client() {
  let datos = {
    name: $("#name").val(),
    email: $("#email").val(),
    password: $("#password").val(),
  };

  let dataToSend = JSON.stringify(datos);

  $.ajax({
    url: "http://localhost:8080/api/Client/save",
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json',
    data: dataToSend,
    success: function (respuesta) {
      name: $("#name").val("");
      email: $("#email").val("");
      password: $("#password").val("");
      age: $("#age").val("");
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