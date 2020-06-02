/*===================================
=            MENU MOBILE            =
===================================*/
var sw = 0;
$(".jsBtnMenu").on("click", function() {
    animate_menu();
});

function animate_menu() {
    0 == sw ? ($(".container-menu-mobile").animate({ top: "0" }), sw = 1) : ($(".container-menu-mobile").animate({ top: "-100%" }), sw = 0);
}

/*====================================
=            LOAD ELECTORS            =
====================================*/

function genericFuntionAjax(param){
	var post_url = $(param).attr("action");
	var request_method = $(param).attr("method"); 
	var form_data = $(param).serialize();
	$.ajax({
		url : post_url,
		type: request_method,
		data : form_data,		 
	}).done(function(data){
		$("#result-search").css("display", "block");
		$("#result-search").html(data);		
		//loadevent();
	}).fail(function (jqXHR, textStatus){
        printMessage(textStatus,2);	
    });
}



/*=========================================================
=            NO PERMITIR CARACTERES ESPECIALES            =
=========================================================*/

$(document).on('keypress', '.NcharSpecial', function(evt) {

    evt = evt || event;
    return /[a-z0-9]/i.test(String.fromCharCode(evt.charCode || evt.keyCode)) ||
        !!(!evt.charCode && ~[8, 37, 39, 46].indexOf(evt.keyCode));

});

/*=============================
=            MODAL            =
=============================*/

$(document).on("click", "[data-switch='modal']", function() {

    var modal = $(this).attr("data-target");
    var id = $(this).attr("data-id");
    var status = $(this).attr("data-estado");

    setFullModalValues($(this));

    $(modal).css("display", "block");

});

$(".btnCloseModal").on("click", function() {    
    $(this).parents(".modalNormal").css("display", "none");

});

$(".modalNormal").on("click", function(event) {

    var modal = event.target.id;

    $("[data-name='modal-" + modal + "']").css("display", "none");

});



/*=============================================
BOTON BUSCAR -- ELECTORES
=============================================*/
$("button[data-js='searchBusiness']").on("click", function() {
	genericFuntionAjax("#formBusiness");
});


function paso(cedula){
	var  res = "No";
    $.ajax({
        type: 'GET',        
        url: "/update-elector/"+cedula,
        dataType: 'json',
        success: function(data) {
        	if(data ==1){
        		res ="Si"
        	}
        	$('#nced'+cedula).text(res);
        },
        error: function(e) {
            console.log("error al cargar datalist: " + e);
        }

    }); 
}

/*=============================================
BOTON LIMPIAR -- FRILTRO
=============================================*/
$("button[data-js='clearField']").on("click", function() {
	$("#formBusiness")[0].reset();
    $("#result-search").css("display", "none");
});


/*=============================================
PAGINADOR ---
=============================================*/


function paginatorBussines(size,pageNumber,operator){
	var page = $('#page').val();
	if(page=== ""){ page=1}
	switch (operator) {
		case "sum":
			if(pageNumber >1){
				pageNumber = parseFloat(page) + parseFloat(1);
			}				
			break;
		case "minus":
			if(pageNumber >1){
			pageNumber = parseFloat(page) - parseFloat(1);
			}			
			break;			
	}
	$('#size').val(size);
	$('#page').val(pageNumber);	
	genericFuntionAjax("#formBusiness");
}
if($("idCliente").val()===''){
	$('#createBusinessCustomer').val('');	
}
$("button[data-js='createBusinessSave']").on("click", function() {
	$('#idZona').prop('disabled', false);
	$('#anio').prop('disabled', false);
	$('#estado').prop('disabled', false);	
    createBussinesObjectAjax("#formBusiness", "formBusiness");
});

/*=============================================
INPUT MASK
=============================================*/

$(document).ready(function(){

    $(document).on("click mouseover", ".menu-ppal .main-nav", function() {
        $('.menu-ppal ul li ul').removeClass('active');
        $(this).next('ul').toggleClass('active', 500);
        $('.menu-ppal .main-nav').removeClass('active');
        $(this).toggleClass('active', 500);

    });

	$('#menu-icon').click(function(){
		$('.menu-ppal .main-nav-container').slideToggle(500);
	})


$('body').on('click',function() {
 $(".main-nav-container ul.active").removeClass('active');
 $(".main-nav-container .main-nav.active").removeClass('active');
 
});	
           
});

/*=============================================
DIAGRAM REPORT ONE
=============================================
*/



var densityCanvas = document.getElementById("densityChart");

Chart.defaults.global.defaultFontFamily = "Lato";
Chart.defaults.global.defaultFontSize = 18;

var densityData = {
  label: 'Miguel Hdez',
  data: [5, 20],
  backgroundColor: [
    'rgba(0, 99, 132, 0.6)'
  ],
  borderColor: [
    'rgba(240, 99, 132, 1)'
  ],
  borderWidth: 2,
  hoverBorderWidth: 0
};

var chartOptions = {
  scales: {
    yAxes: [{
      barPercentage: 0.5
    }]
  },
  elements: {
    rectangle: {
      borderSkipped: 'left',
    }
  }
};

var barChart = new Chart(densityCanvas, {
  type: 'horizontalBar',
  data: {
    labels: ["Pasaron", "No Pasaron"],
    datasets: [densityData],
  },
  options: chartOptions
});


$('document').ready(function(){
	 
    $(".no-controls").keydown(function(event) {
     
    // Desactivamos cualquier combinación con shift
    if(event.shiftKey)
        event.preventDefault();
     
    /*  
        No permite ingresar pulsaciones a menos que sean los siguientes
        KeyCode Permitidos
        keycode 8 Retroceso
        keycode 37 Flecha Derecha
        keycode 39  Flecha Izquierda
        keycode 46 Suprimir
    */
    //No permite mas de 11 caracteres Numéricos
    if (event.keyCode != 46 && event.keyCode != 8 && event.keyCode != 37 && event.keyCode != 39) 
        if($(this).val().length >= 11)
            event.preventDefault();

    // Solo Numeros del 0 a 9 
    if (event.keyCode < 48 || event.keyCode > 57)
        //Solo Teclado Numerico 0 a 9
        if (event.keyCode < 96 || event.keyCode > 105)
            /*  
                No permite ingresar pulsaciones a menos que sean los siguietes
                KeyCode Permitidos
                keycode 8 Retroceso
                keycode 37 Flecha Derecha
                keycode 39  Flecha Izquierda
                keycode 46 Suprimir
            */
            if(event.keyCode != 46 && event.keyCode != 8 && event.keyCode != 37 && event.keyCode != 39)
                event.preventDefault();
     
     
});
});


window.addEventListener("load", function() {
	formBusiness.cedula.addEventListener("keypress", soloNumeros, false);
	});

	//Solo permite introducir numeros.
	function soloNumeros(e){
	  var key = window.event ? e.which : e.keyCode;
	  if (key < 48 || key > 57) {
	    e.preventDefault();
	  }
	}