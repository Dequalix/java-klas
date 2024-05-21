let yearSpan = document.querySelector('#copyright-year');
let currentDate = new Date();
yearSpan.innerText = currentDate.getFullYear();

function addTrip(){
    let template = document.querySelector('#trip-template').content;
    let clone = document.importNode(template, true);

    clone.querySelector('.city').innerText = 'Amsterdam';
    clone.querySelector('.date').innerText = '4/8/2014';
    clone.querySelector('.review').innerText = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum';
    clone.querySelector('.rating').innerText = '8';
    console.log(template);

    document.querySelector('#container ul').appendChild(clone);
}