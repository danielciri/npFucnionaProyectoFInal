$(document).ready(function() {

  $.fn.timepicker.Constructor.prototype.getTime = function() {
    if (this.hour === '') {
      return '';
    }
    return (this.hour.toString().length === 1 ? '0' + this.hour : this.hour) + ':' + (this.minute.toString().length === 1 ? '0' + this.minute : this.minute) + (this.showSeconds ? ':' + (this.second.toString().length === 1 ? '0' + this.second : this.second) : '') + (this.showMeridian ? ' ' + this.meridian : '');
  }

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