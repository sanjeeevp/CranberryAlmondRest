$('#search').click(function() {
    $.ajax({
        type: 'POST',
        url: 'cityResults.htm',
        data: $('#cityDetails').serialize(),
        dataType:"json", //to parse string into JSON object,
        success: function(data){ 
            if(data){
                var len = data.length;
                var txt = "";
                if(len > 0){
                    for(var i=0;i<len;i++){
                        if(data[i].city && data[i].cStatus){
                            txt += "<tr><td>"+data[i].city+"</td><td>"+data[i].cStatus+"</td></tr>";
                        }
                    }
                    if(txt != ""){
                        $("#table").append(txt).removeClass("hidden");
                    }
                }
            }
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('error: ' + textStatus + ': ' + errorThrown);
        }
    });
    return false;//suppress natural form submission
});

//function CrunchifyTableView(objArray, theme) {
// 
//    needHeader = true;
// 
//    var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;
// 
//    var str = '<table class="' + theme + '">';
// 
//    // Only create table head if needHeader is set to True..
//    if (needHeader) {
//        str += '<thead><tr>';
//        for (var index in array[0]) {
//            str += '<th scope="col">' + index + '</th>';
//        }
//        str += '</tr></thead>';
//    }
// 
//    // table body
//    str += '<tbody>';
//    for (var i = 0; i < array.length; i++) {
//        str += (i % 2 == 0) ? '<tr class="alt">' : '<tr>';
//        for (var index in array[i]) {
//            str += '<td>' + array[i][index] + '</td>';
//        }
//        str += '</tr>';
//    }
//    str += '</tbody>'
//    str += '</table>';
//    return str;
//}