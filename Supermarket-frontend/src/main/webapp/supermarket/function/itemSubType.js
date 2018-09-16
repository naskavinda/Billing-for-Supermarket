function loadItemSubType(name, itemMainTypeId) {
    if (itemMainTypeId > 0) {
        $.ajax({

                url: 'LoadItemSubType',
                type: 'post',
                dataType: 'json',
                cache: false,
                async: false,
                data: {
                    id: itemMainTypeId
                },
                success: function (data) {
                    $("#" + name).empty();
                    $('#' + name).append('<option value="0">Select</option>');
                    $.each(data, function (index, element) {
                        $('#' + name).append('<option value="' + element.id + '">' + element.type + '</option>');
                    });
                },
                error: function () {
                    alert('error');
                }
            }
        );
    } else {
        $("#" + name).empty();
    }
}