/**
 * Created by petka on 28.03.2017.
 */
$(document).ready(function () {
    $("#addPlayer").click(function () {
        $.ajax({
            url: "../add",
            type: "POST",
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify({
                firstName: $("#firstName").val(),
                lastName: $("#lastName").val(),
                age: $("#age").val()
            }),
            statusCode: {
                200: function (data) {
                    window.location.reload();
                }
            }
        });
    });
});