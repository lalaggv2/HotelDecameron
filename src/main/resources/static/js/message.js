const urlVM = "http://132.145.209.209"

function traerMessages() {
  $.ajax({
    url: "http://localhost:8080/api/Message/all",
    type: 'GET',
    dataType: "json",
    success: function (respuesta) {
      pintarMessages(respuesta);
    },
    error: function (respuesta, xhr) {
      alert("Error de peticion");
    }
  });
}

function pintarMessages(datos) {
  let html = "";

  html += "<thead>";
  html += "<tr>";
  html += "<th>Nombre</th>";
  html += "<th>Message</th>";
  html += "<th>Accion</th>";
  html += "</tr>";
  html += "</thead>";

  html += "<tbody>";

  for (dato of datos) {
    html += "<tr>"
    html += "<td>" + dato.name + "</td>";
    html += "<td>" + dato.textarea + "</td>";
    html += "<td><button class='btn btn-outline-primary btn-sm' onclick='eliminarMessage(" + dato.idMessage+")'>Eliminar</button></td>";
    html += "<tr>";

  }

  html += "</tbody>"

  $("#tblMessage").html(html);
}

function guardarMessage() {
  let datos = {
    name: $("#name").val(),
    message: $("#textarea").val(),
  };

  let dataToSend = JSON.stringify(datos);

  $.ajax({
    url: "http://localhost:8080/api/Message/save",
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json',
    data: dataToSend,
    success: function (respuesta) {
      name: $("#name").val("");
      message: $("#textarea").val("");
     
      traerMessages();

    },
    error: function (respuesta, xhr) {
      alert("Error de peticion")
    }
  });
}

function eliminarMessage(idMessage) {
  $.ajax({
  url: "http://localhost:8080/api/Message/" + idMessage,
    type: 'DELETE',

    success: function (respuesta) {
      confirm("El registro sera eliminado. Presione OK para eliminar")
      traerMessages();

    },
    error: function (respuesta, xhr) {
      alert("Error de peticion")
    }
  });

}

