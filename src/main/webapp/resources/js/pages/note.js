$(function () {

    autosize($('textarea.auto-growth'));

    //Datetimepicker plugin
    $('.datetimepicker').bootstrapMaterialDatePicker({
        format: 'DD/MM/YYYY HH:mm',
        clearButton: true,
        weekStart: 1
    });
    
    $('#note-body-label').html(255 - $('#note-body-textarea').text().length);
    
    $("#note-body-textarea").on('change', function(){
    	$('#note-body-content').value = this.value; 
    });
    
    $('#note-body-textarea').on('input', function () {
    	$('#note-body-label').html(255 - this.value.length);
    });

    $('#note-type').on('change', function(){
        var noteType = this.value;

        $('.noteType').removeClass('hide');
        $('.noteType').addClass('hide');
        $("#noteType_"+noteType).removeClass('hide');
    });

    var noteTypeSelectElement = document.getElementById('note-type');
    
    if(noteTypeSelectElement.value != undefined){
        $("#noteType_"+noteTypeSelectElement.value).removeClass('hide');
    }
});