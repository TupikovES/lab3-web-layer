/**
 * Created by petka on 28.03.2017.
 */
$(document).ready(function () {
    $("#addClub").click(function () {
        $.ajax({
            url: "clubs/add",
            type: "POST",
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify({
                name: $("#name").val(),
                city: $("#city").val()
            }),
            statusCode: {
                200: function (data) {
                    window.location.href = 'clubs';
                }
            }
        });
    });
});