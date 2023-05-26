
var datos = require('./datos.json');

function paises_y_capitales() {
    datos.forEach((p) => {
        txt = '';
        txt += p.name + '-' + p.capital;
        console.log(txt);
    } );
}

function paises_y_codigos() {
    datos.forEach((p) => {
        txt = '';
        txt += p.alpha2Code + '-' + p.name + '-' + p.translations["fr"];
        console.log(txt);
    });
}

function mayor_y_menor() {
    temp_list = new Array();
    var returning_object = {};
    const min = Math.min(...datos.map(p => p.area));
    const max = Math.max(...datos.map(p => p.area));
    
    datos.forEach((p) => {
        if (p.area == max) {
            returning_object.mayor = {nombre : p.name, extension : p.area};
        }
        if (p.area == min) {
            returning_object.menor = {nombre : p.name, extension : p.area};
        }
    });

    return returning_object;
}

paises_y_capitales();

paises_y_codigos();

console.log(mayor_y_menor());