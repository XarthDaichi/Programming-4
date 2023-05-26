function renderPais(c,lista){
    cldiv=document.createElement("div"); // Country Left Div
    cldiv.className="cldiv";

    clp=document.createElement("p");
    clp.appendChild(document.createTextNode(c.name));
    clp.className="clp";

    climg= document.createElement("img");
    climg.setAttribute("src",c.flag);
    climg.className="climg";

    cldiv.append(clp,climg);

    crdiv=document.createElement("div");  //Country Right Div
    crdiv.className="crdiv";
    crdiv.innerHTML=`
            Capital: ${c.capital}<br>
            Población: ${c.population}<br>
            Area: ${c.area}<br>
            Latitud: ${c.latlng[0]}<br>
            longitud: ${c.latlng[1]}
            `;

    cdiv=document.createElement("div"); // Country Div
    cdiv.className="cdiv";        
    cdiv.append(cldiv,crdiv);  

    lista.appendChild(cdiv);
}
function listar(cs){
    l=document.getElementById('lista');
    cs.forEach( p=>renderPais(p,l));
};
 
listar(countries);


