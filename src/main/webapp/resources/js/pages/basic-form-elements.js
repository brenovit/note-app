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
        count.innerHTML = this.value.length;
    });
});

