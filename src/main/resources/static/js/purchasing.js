$('.payment-card').on('click', function(e) {
    $('.payment-card-activated').not(this).removeClass('payment-card-activated');
    if (!$(this).hasClass("add-card")) {
        $(this).toggleClass('payment-card-activated');
    }
});