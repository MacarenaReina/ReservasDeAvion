/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    changeLanguage($("#language1"));
});

function refreshLanguage() {
    $.ajax({    
        "url": "rest/languages",
        "type": "get",                    
        "dataType": "json",                    
        "success": function (elements) {                       
            $.each(elements, function (i, element) {
                $("#"+element.key).text(element.value);
            });
        }                
    });
}

function changeLanguage(event) {
    var languageSplit;
    if(event.target) {
        languageSplit = event.target.name.split("_");
    } else {
        languageSplit = event[0].name.split("_");
    }

    var language = {"key": languageSplit[0],
                    "value": languageSplit[1]};

    $.ajax({    
        "url": "rest/languages",
        "type": "POST",
        "contentType": 'application/json', 
        "data": JSON.stringify(language),
        "dataType": "json",                    
        "success": function (data, textStatus, jqXHR) {
            refreshLanguage(); 
        }                
    });
}

