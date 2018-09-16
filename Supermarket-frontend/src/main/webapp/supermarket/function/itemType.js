function loadItems(mainTypeId, subTypeId,itemTypeId) {
    const mainType = $("#" + mainTypeId).val();
    const subType = $("#" + subTypeId).val();
    $.ajax({
            url: 'LoadItemType',
            type: 'post',
            dataType: 'json',
            cache: false,
            async: false,
            data: {
                itemMainTypeId: mainType,
                itemSubTypeId: subType
            },
            success: function (data) {
                $("#" + itemTypeId).empty();
                $('#' + itemTypeId).append('<option value="0">Select</option>');
                $.each(data, function (index, element) {
                    $('#' + itemTypeId).append('<option value="' + element.id + '">' + element.type + '</option>');
                });
            },
            error: function () {
                alert('error');
            }
        }
    );

}