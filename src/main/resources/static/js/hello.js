/**
 * 
 */

$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/user/1"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-email').append(data.email);
    });
});