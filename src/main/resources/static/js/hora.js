$(document).ready(function() {
  $('#fechaInicio').timepicker({
    useCurrent: false,
    format: 'HH:mm:ss',
    minuteStep: 1,
    showSeconds: true,
    showMeridian: false,
    disableFocus: true,
    icons: {
      up: 'fa fa-chevron-up',
      down: 'fa fa-chevron-down'
    }
  }).on('focus', function() {
    $('#fechaInicio').timepicker('showWidget');
  });

});