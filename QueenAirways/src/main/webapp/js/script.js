$(document).ready(function () {
    $('#btnSearch').click(function (e) {
        var valueRadio = $('input[name=groupCompany]:checked').val();
        var firstFormBool = true;

         $(':input[type="number"]').each(function () {
            if($.isNumeric($(this).val())==false) {
                firstFormBool = false;
            }
        });
        
        if((firstFormBool === false)||(valueRadio === undefined)){
            return false;
        
        } else {
            $(".div_page1").parent().hide('slow');
            $(".div_page2").show('slow');
        }  
    });

    $('.row_page_2').children().click(function (e) {    
        $(".row_page_2").parent().hide('slow');
        $(".div_page3").show('slow');
    });
    
    $('#btnReserva').click(function (e){
        
        var valueRadio = $('input[name=gDate]:checked').val();
        
        var valueFName = $('#first_name').val();
        valueFName = $.trim(valueFName);
        var matches = valueFName.match(/\d+/g);
        var validateName = validar(valueFName,matches);
        
        
        var valueLName = $('#last_name').val();
        valueLName = $.trim(valueLName);
        var matches2 = valueLName.match(/\d+/g);
        var validateLName = validar(valueLName,matches2);
        
        
        var valueTLF = $('#telephone').val();
        valueTLF = $.trim(valueTLF);
        var matches3 = new RegExp(/^[0-9-()+]{3,20}/);
        var validateTLF = matches3.test(valueTLF);
        
        var valueCard = $('#card').val();
        valueCard = $.trim(valueCard);
        var matches4 = new RegExp(
        /^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$/);
        var validateCard = matches4.test(valueCard);
        
        var secondFormBool = true;
        
        if(validateName == false){
            secondFormBool = false;
        }else if(validateLName == false){
            secondFormBool = false;
        }else if(validateTLF == false){
            secondFormBool = false;
        }else if(validateCard == false){
            secondFormBool = false;
        }
         
        if((secondFormBool == false)||(valueRadio === undefined)){
            alert("nanai");
        }else{
            alert("todo ok");
        }
    });
    
    function validar(element,match){
        if((element != "")||(match == null)){
            return true;
        }
        else{
            return false;
        }
    }
    
});