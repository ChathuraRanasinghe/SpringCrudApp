var ajaxConfig = {
    method:"GET",
    url:"http://localhost:8080/api/v1/customers?action=count",
    async:true
};

$.ajax(ajaxConfig).done(function(response){
    $("#lblCustomersCount").text(response);
});
