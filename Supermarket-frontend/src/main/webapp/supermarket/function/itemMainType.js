function loadItemMainType(id) {
    $.ajax({
            url: 'LoadItemMainType',
            type: 'post',
            dataType: 'json',
            cache: false,
            async: false,
            success: function (data) {
                $("#"+id).empty();
                $('#'+id).append('<option value="0">Select</option>');
                $.each(data, function (index, element) {
                    $('#'+id).append('<option value="' + element.id + '">' + element.type + '</option>');
                });
            },
            error: function () {
                alert('error');
            }
        }
    );
}

function loadItemMainTypeById(ref) {
    const valueOfItemMainTypeComboBox = $("#allItemMainType").val();
    if (valueOfItemMainTypeComboBox === 0) {
        $("#mainType").val("");
        $("#btnSaveItemMainType").html('Save');
    } else {
        const x = $(ref).find('option:selected').text();
        $("#mainType").val(x);
        // $.ajax({
        //     url: 'SaveItemMainType',
        //     type: 'post',
        //     cache: false,
        //     async: false,
        //     data: {
        //         userId: valueOfItemMainTypeComboBox
        //     },
        //     success: function (data) {
        //         var x = JSON.parse(data);
        //         $("#mainType").val(x.type);
        //         $("#btnSaveItemMainType").html('Update');
        //     },
        //     error: function () {
        //         alert('error');
        //     }
        // });
    }
}

function saveOrUpdateBank(key) {

    if (key === 13) {

        const id = $("#allItemMainType").val();
        const mainType = $("#mainType").val();

        if (id === '' || mainType === '') {
            alert('Fill All Required field');
        } else {
            let jsn_object = {jsn: []};
            jsn_object.jsn.push({
                "id": id,
                "type": mainType
            });
            let arr = JSON.stringify(jsn_object);
            $.ajax({
                    url: 'SaveItemMainType',
                    data: {
                        jsnobj: arr
                    },
                    type: 'post',
                    cache: false,
                    async: false,
                    success: function () {
                        $("#mainType").val("");
                        $("#btnSaveBank").html('Save');
                        alert('Successfully Saved....!!!!');
                        $("#allBank").empty();
                        loadItemMainType();
                    },
                    error: function () {
                        alert('error');
                    }
                }
            );
        }
    }
}