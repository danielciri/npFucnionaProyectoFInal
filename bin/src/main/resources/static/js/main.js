
/* Cuando el documento se cargue completamente, se ejecutara la function de mostrar los links*/
$(document).ready(function() {
	$('.menu li:has(ul)').click(function(e) {/*Seleccionamos los elementos li pero solo aquellos que tengan un ul y preguntamos si han sido clickeados*/
		e.preventDefault();


		if ($(this).hasClass('activado')) {
			$(this).removeClass('activado');
			$(this).children('ul').slideUp();
		} else {
			$('#ulitem li ul').slideUp();
			$('#ulitem li').removeClass('activado');
			$(this).addClass('activado');
			$(this).children('ul').slideDown();
		}
	});
});

