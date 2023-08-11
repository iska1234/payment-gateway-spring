$(document).ready(function(){
    $('.botonmicuenta').css("font-weight", "900");
    $('#mispedidos').hide();
    $('.sinproductos').hide();
    $('#datos-enviodomicilio').hide();
    $('#datos-recojotienda').hide();

    $('.cat').click(function(){
        $('.sinproductos').hide();
        const valor = $(this).attr('data-filter');
        if(valor == 'todos'){
            $('.caja-prod').show(400);
        }
        else{
        $('.caja-prod').not('.' + valor).hide(400);
        $('.caja-prod').filter('.' + valor).show(400);
        if(valor == 'prodhp' || valor == 'prodlenovo' || valor == 'prodrazer'){
            $('.sinproductos').show();
        }
        }
    })

    $('.cat').click(function(){
        $(this).addClass('seleccionado').siblings().removeClass('seleccionado');
    })

    $('.botonmicuenta').click(()=>{
        $('#micuenta').show('1000');
        $('#mispedidos').hide();

        $('.botonmicuenta').css("font-weight", "900");
        $('.botonmispedidos').css("font-weight", "100");
    });

    $('.botonmispedidos').click(()=>{
        $('#mispedidos').show('1000');
        $('#micuenta').hide();

        $('.botonmispedidos').css("font-weight", "900");
        $('.botonmicuenta').css("font-weight", "100");
    });

    $('#botonborrar').click(()=>{
        $('.cuadroproducto-detalle').animate({opacity: "0"}, 200);
        setTimeout($('.cuadroproducto-detalle').hide('1000'), 100);
    });

    $('#despacho-delivery').click(()=>{
        $('#recojotienda-form').trigger("reset");
        $('#datos-enviodomicilio').show('1000');
        $('#datos-recojotienda').hide();
    })

    $('#despacho-recogertienda').click(()=>{
        $('#domicilio-form').trigger("reset");
        $('#datos-recojotienda').show('1000');
        $('#datos-enviodomicilio').hide();
    })
    
    //---------
    const credito = $('#tarjeta-info');
    const pagoefect = $('#pagoefectivo-procesar');
    const yape = $('#yape-procesar');
    const plin = $('#plin-procesar');

    credito.hide('1000');
    pagoefect.hide('1000');
    yape.hide('1000');
    plin.hide('1000');
    
    $('#tarjeta-creditodebito').click(()=>{
        credito.show('1000');
        pagoefect.hide('1000');
        yape.hide('1000');
        plin.hide('1000');
    });

    $('#pagoefectivo').click(()=>{
        credito.hide('1000');
        pagoefect.show('1000');
        yape.hide('1000');
        plin.hide('1000');
    });
    
    $('#yape').click(()=>{
        credito.hide('1000');
        pagoefect.hide('1000');
        yape.show('1000');
        plin.hide('1000');
    });

    $('#plin').click(()=>{
        credito.hide('1000');
        pagoefect.hide('1000');
        yape.hide('1000');
        plin.show('1000');
    });

    //------------
    $('#boton-buscarseg').click(function() {
        $('.seguimiento-info').css({
            'display': 'block',
        });
    });
});



