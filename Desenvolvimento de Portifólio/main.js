
var menuItem = document.querySelectorAll('.item-menu')

function selectlink(){
  menuItem.forEach((item) =>
    item.classList.remove('ativo')
  )
  this.classList.add('ativo')
}

menuItem.forEach((item) =>
  item.addEventListener('click', selectlink)
)

//Expandir o menu

var btnExp = document.querySelector('#btn-exp')
var menuSide = document.querySelector('.menu-lateral')

btnExp.addEventListener('click', function(){
  menuSide.classList.toggle('expandir')
})

const mySwiper = new Swiper('.swiper' , {
  effect: 'coverflow',
  grabCursor: true,
  centeredSlides: true,
  loop:true,
  autoplay: true,
  slidesPerView: '2',
  speed: 1000,
  coverflowEffect: {
      rotate: 5,
      strech: 50,
      depth: 100,
      modifier: 1,
      slideShadows: true
  }
});