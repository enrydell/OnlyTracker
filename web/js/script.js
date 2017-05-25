/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$('#typeForm span').each(function() {
    $(this).click(function() {
        $(this).addClass('textActive');
        $(this).siblings().removeClass('textActive');
            if($(this).hasClass('cadastro')) {
            var form = $(this).parent().siblings('.cadastroForm');
            form.siblings('.loginForm').animate({margin: '50px 0px 0px 220px'});
            form.animate({margin: '15px 0px 0px 0px'});
        } else {
            var form = $(this).parent().siblings('.loginForm');
            form.siblings('.cadastroForm').animate({margin: '15px 0px 0px -220px'});
            form.animate({margin: '50px 0px 0px 0px'});
        }
    });
});

$('.menuButton').click(function() {
    $(this).parent('header').siblings('.container').animate({left: "150px"});
    $(this).parent('header').animate({left: "150px"});
    $(this).parent('header').siblings('.menu').animate({left: "0px"}); 
});

$('.menuClose').click(function() {
	$(this).parent().parent().parent('.menu').animate({left: "-150px"});
    $(this).parent().parent().parent('.menu').siblings('header').animate({left: "0px"});
    $(this).parent().parent().parent('.menu').siblings('.container').animate({left: "0px"}); 
});