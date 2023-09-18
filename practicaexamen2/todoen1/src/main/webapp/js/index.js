var backend = "http://localhost:8080/todoen1/api";

var globalstate = {user:null};

var app;

function loaded(){
    app = new App();
    document.querySelector('#root').replaceChildren(app.dom);
}

document.addEventListener("DOMContentLoaded", loaded);

function errorMessage(code){
    alert(`Error. Status: ${code}`);
}