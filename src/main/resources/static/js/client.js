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
  html += "<th>Accion</th>";
  html += "</tr>";
  html += "</thead>";

  html += "<tbody>";

  for (dato of datos) {
    html += "<tr>"
    html += "<td>" + dato.name + "</td>";
    html += "<td>" + dato.email + "</td>";
    html += "<td>" + dato.age + "</td>";
    html += "<td><button class='btn btn-outline-primary btn-sm' onclick='eliminarClient(" + dato.idClient+")'>Eliminar</button></td>";
    html += "<tr>";

  }

  html += "</tbody>"

  $("#tblClients").html(html);
}

function guardarClient() {
  let datos = {
    name: $("#name").val(),
    email: $("#email").val(),
    password: $("#password").val(),
    age: $("#age").val(),
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

function eliminarClient(idClient) {
  $.ajax({
    url: "http://localhost:8080/api/Client/" + idClient,
    type: 'DELETE',

    success: function (respuesta) {
      confirm("El registro sera eliminado. Presione OK para eliminar")
      traerClients();

    },
    error: function (respuesta, xhr) {
      alert("Error de peticion")
    }
  });

}