$(document).ready(function () {
	//$('#header').load("include/header.html");
	$(".button-collapse").sideNav();
	$('.parallax').parallax();



	var sliderFormat = document.getElementById('rangePrice');

	$("#rangePrice").ionRangeSlider({
		min: 0,
		max: 2000,
		from: 550,
		prefix: '€'
	});
});