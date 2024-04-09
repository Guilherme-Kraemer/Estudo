const mySwiper = new Swiper('.swiper' , {
    effect: 'coverflow',
    grabCursor: true,
    centeredSlides: true,
    loop:true,
    autoplay: true,
    slidesPerView: '2',
    coverflowEffect: {
        rotate: 50,
        strech: 0,
        depth: 300,
        modifier: 1,
        slideShadows: true
    },
    pagination: {
        el: '.swiper-pagination' ,
        clickable: true
    }
});