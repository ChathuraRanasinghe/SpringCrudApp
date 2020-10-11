$(document).ready(loadAllCustomers);

function loadAllCustomers(){

    var ajaxConfig = {
        method: "GET",
        url:"http://localhost:8080/api/v1/customers",
        async: true
    };

    $.ajax(ajaxConfig).done(function(response){
        response.forEach(function (customer){
            var html = "<tr>" +
                "<td>" + customer.id + "</td>" +
                "<td>" + customer.name + "</td>" +
                "<td>" + customer.address + "</td>" +
                '<td class="recycle"><i class="fa fa-2x fa-trash"></i></td>' +
                "</tr>";

            $("#tblCustomers tbody").append(html);

            $(".recycle").off();
            $(".recycle").click(function(){

                var customerID = ($(this).parents("tr").find("td:first-child").text());

                if (confirm("Are you sure that you want to delete?")){

                    $.ajax({
                        method:"DELETE",
                        url:"",
                        async: true
                    }).done(function(response){
                        alert("Customer has been successfully deleted");
                        $("#tblCustomers tbody tr").remove();
                        loadAllCustomers();
                    });

                }

            });
       });
    });

}