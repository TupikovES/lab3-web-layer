/**
 * Created by petka on 28.03.2017.
 */
$(document).ready(function () {
    $("#addDivision").click(function () {
        $.ajax({
            url: "../add",
            type: "POST",
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify({
                name: $("#name").val()
            }),
            statusCode: {
                200: function (data) {
                    window.location.reload();
                }
            }
        });
    });
});