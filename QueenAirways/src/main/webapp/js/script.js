$(document).ready(function(){
    $('#btnSearch').click(function(e){
        $(".div_page1").parent().hide('slow');
        $(".div_page2").show('slow');
    });

    $('.row_page_2').children().click(function(e){
        $(".row_page_2").hide('slow');
        $(".div_page3").show('slow');
    });
});