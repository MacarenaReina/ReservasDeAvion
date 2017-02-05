/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    var company = $("#airlines");
    company.empty();
    
    $.ajax({
        "url": "rest/airlines",
        "type": "get",
        "dataType": "json",
        "success": function (airlines) {
            $.each(airlines, function(i, airline) {
                var div = $("<div>");
                div.addClass("col s12 m12 l12");
                
                var input = $("<input>");
                input.attr("name", "groupCompany");
                input.attr("type", "radio");
                input.attr("id", airline.id);
                
                var label = $("<label>");
                label.attr("for", airline.id);
                label.text(airline.name);
                
                div.append(input);
                div.append(label);
                
                company.append(div);
            });
        }
    });
});

