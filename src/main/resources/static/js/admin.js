function traerDatosAdmins() {
  $.ajax({
      url: "http://localhost:8080/api/Admin/all",
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