$(function(){
    $.ajax({
        type: 'get',
        async: true,
        url: '/plat/getMessage',
        success: function(result) {
            debugger;
            var obj = JSON.parse(result);
            var html = "";
            for(var prop in obj) {
                html += "<p>" + obj[prop] +"</p>"
            }
            $('#container').append(html);
        }
    });
});
