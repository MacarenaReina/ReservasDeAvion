$( document ).ready(function() {
  $("title").parent().click(function(){
    var fillAsiento = $(this).css("fill");
    var colorGrey = "rgb(204, 204, 204)";
    var colorGreen = "rgb(0, 128, 0)";
    if(fillAsiento == colorGrey){
      $(this).css({ fill: "green" });
    }else if(fillAsiento == colorGreen){
      $(this).css({ fill: "#cccccc" });
    }
  });
});
