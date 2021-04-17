'use strict';

//Projects
const productBar = document.querySelector('.product__bar');
const productContainer = document.querySelector('.product__container');
const products = document.querySelectorAll('.card');
productBar.addEventListener('click', (e) => {
const filter = e.target.dataset.filter || e.target.parentNode.dataset.filter;
const usersearch = e.target.dataset.usersearch || e.target.parentNode.dataset.usersearch;
if (filter == null) {
  return;
}

const selected = document.querySelector('.nav-link selected');
if (selected != null) {
  selected.classList.remove('selected');
}
e.target.classList.add('selected');

productContainer.classList.add('anim-out');
setTimeout(() => {
  products.forEach((product) => {
    if (filter === '*' || filter === product.dataset.type || usersearch === product.dataset.searching) {
      product.classList.remove('invisible');
    }else {
      product.classList.add('invisible');
    }
  });
  productContainer.classList.remove('anim-out');
}, 300);
});