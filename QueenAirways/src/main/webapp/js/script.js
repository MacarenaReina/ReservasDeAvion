$(document).ready(function () {
	//$('#header').load("include/header.html");
	$(".button-collapse").sideNav();
	$('.parallax').parallax();

	var sliderFormat = document.getElementById('rangePrice');

	$("#rangePrice").ionRangeSlider({
		hide_min_max: true,
		keyboard: true,
		min: 0,
		max: 5000,
		from: 0,
		to: 500,
		type: 'double',
		step: 1,
		prefix: "€",
		grid: true
	});
});