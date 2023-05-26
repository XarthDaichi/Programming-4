l1 = new Array();
p={cedula:'001',nombre:'juan'};
l1.push(p);
p={cedula:'002',nombre:'maria'};
l1.push(p);
serial = JSON.stringify(l1);
console.log(serial);  

l2=JSON.parse(serial);
l2.forEach( (p)=> {console.log(p.nombre);} );