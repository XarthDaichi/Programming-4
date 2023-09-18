/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

class Welcome {
    dom;
    
    state;
    
    constructor() {
        this.state = {};
        this.dom = this.render();
    }
    
    render=()=> {
        const html = `
            <div style='background-color:steelblue'>
                <h1>Welcome</h1>
            </div>
            <div style='background-color:gray'>
                <h2>We are a non-profit training company...</h2>
            </div>
        `;
        var rootContent= document.createElement('div');
        rootContent.id='questions';       
        rootContent.innerHTML=html;
        return rootContent;
    }
}

