$(document).ready(function () {
    //$('#header').load("include/header.html");
    $(".button-collapse").sideNav();
    $('.parallax').parallax();

    $('.timepicker').pickatime({
        default: 'now',
        twelvehour: false,
        donetext: 'OK',
        autoclose: false,
        vibrate: true
    });

    var sliderFormat = document.getElementById('rangePrice');

    $("#rangePrice").ionRangeSlider({
        min: 0,
        max: 2000,
        from: 550,
        prefix: '€'
    });
});