$(document).ready(function () {
    $.ajax({
        type: "get",
        url: "courts",
        dataType: "json",
        success: function (data) {
            console.log(data);

            $.each(data, function (index, item) {

                $("#contents").append("<div class='col-lg-3 col-md-6 mb-4'>" +
                    "<div class='card h-100'>" +
                    "<img id='image' class='card-img-top' src='img/" + item.image + "' alt='" + item.courtName + "'>" +
                    "<div class='card-body'>" +
                    "<h4 class='card-title' id='courtname'>" + item.courtName + "</h4>" +
                    "<p class='card-text' id='details'>Type : " + item.courtType + "</p>" +
                    "<p class='card-text' id='details'>Price : RM " + item.price + "</p>" +
                    "</div>" +
                    "<div class='card-footer'>" +
                    "<a href='#' class='btn btn-primary'>Find Out More!</a>" +
                    "</div>" +
                    "</div>" +
                    "</div>");
            });

        }
    });
});