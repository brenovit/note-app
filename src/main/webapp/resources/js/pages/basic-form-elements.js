$(function () {

    autosize($('textarea.auto-growth'));

    //Datetimepicker plugin
    $('.datetimepicker').bootstrapMaterialDatePicker({
        format: 'DD/MM/YYYY HH:mm',
        clearButton: true,
        weekStart: 1
    });

    ta = document.getElementById("note-body");
    count = document.getElementById("note-body-label");

    ta.addEventListener("input", function (e) {
        count.innerHTML = 255 - this.value.length;
    });

    $('#noteTypeSelect').on('change', function(){
        var noteType = this.value;

        $('.noteType').removeClass('hide');
        $('.noteType').addClass('hide');
        $("#noteType_"+noteType).removeClass('hide');
    });

    noteTypeSelectElement = document.getElementById('noteTypeSelect');
    
    if(noteTypeSelectElement.value != undefined){
        $("#noteType_"+noteTypeSelectElement.value).removeClass('hide');
    }
});