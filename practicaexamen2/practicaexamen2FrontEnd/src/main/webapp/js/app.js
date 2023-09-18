class App{
  dom;
  modal; // login modal
  
  state;  // state variables: if any
  
  questions;
  welcome;

  constructor(){
    this.state={};
    this.dom=this.render(); 
    this.modal = new bootstrap.Modal(this.dom.querySelector('#app>#modal'));
    this.dom.querySelector('#app>#modal #apply').addEventListener('click',e=>this.login());
    this.welcome = new Welcome();
    this.renderBodyFiller();
    this.renderMenuItems();
    this.questions = new Questions();
  }
  
  render=()=>{
    const html= `
            ${this.renderMenu()}
            ${this.renderBody()} 
            ${this.renderFooter()}
            ${this.renderModal()}
        `;
       var rootContent= document.createElement('div');
       rootContent.id='app';
       rootContent.innerHTML=html;
       return rootContent;
  }
  
   renderMenu=()=>{
    return `
        <nav id="menu" class="navbar navbar-expand-lg p-0 navbar-dark bg-dark">
          <div class="container-fluid">
            <a class="navbar-brand  font-italic font-weight-light  text-info" href="#">
                Questions
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menuCollapse">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div id="menuCollapse" class="collapse navbar-collapse" >
              <ul class="navbar-nav me-auto mb-2 mb-lg-0" id='menuItems'>
              </ul>
            </div>
          </div>
        </nav>
        `;
  }
  
   renderBody=()=>{
    return `
        <div id="body">   
        </div>          
    `;
  }

   renderFooter=()=>{
    return `
        <footer id="footer" class="bg-dark text-white mt-4 w-100 fixed-bottom">
            <div class="container-fluid py-2">

                <div class="row">
                    <div class="col-md-2"><h5>Total Soft Inc.</h5></div>
                    <div class="col-md-7"><h4>
                        <i class="fab fa-twitter"></i>
                        <i class="fab fa-facebook"></i>
                        <i class="fab fa-instagram"></i></h4>
                    </div>
                    <div class="col-md-3 text-right small align-self-end">©2023 Tsf, Inc.</div>
                </div>
            </div>
        </footer> 
    `;
  }    

   renderModal=()=>{
    return `
        <div id="modal" class="modal fade" tabindex="-1">
           <div class="modal-dialog">
               <div class="modal-content">
                   <div class="modal-header" >
                       <span style='margin-left:4em;font-weight: bold;'>Login</span> 
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                   </div>
                   <form id="form" >
                   <div class="modal-body">
                       <div class="input-group mb-3">
                           <span class="input-group-text">Id</span>
                           <input type="text" class="form-control" id="username" name="username">
                       </div>  
                       <div class="input-group mb-3">
                           <span class="input-group-text">clave</span>
                           <input type="password" class="form-control" id="password" name="password">
                       </div>      
                   </div>
                   <div class="modal-footer">
                       <button id="apply" type="button" class="btn btn-primary" id="apply">Login</button>
                   </div>
                   <div class="input-group">
                       <span style="font-style: italic; margin-left: 2em;">No tiene cuenta? ... </span>
                       <a id="register" class="btn btn-info btn-block" style="margin-bottom: 15px; background-color: white; color:red; border:1px solid red" href="#">Registrese aquí</a>
                   </div>                
                   </form>                 
               </div>         
           </div>          
       </div>   
    `;
  }

   renderBodyFiller=()=>{
    this.welcomeShow();
  } 

    renderMenuItems=()=>{
        var html='';
        html+=`
        <li class="nav-item">
            <a class="nav-link" id="welcome" href="#"> <span><img class="img-circle" id="img_logo" src="images/information.png" style="max-width: 50px; max-height: 50px" alt="welcome"></span></a>
        </li>
        `;
        if(globalstate.user===null){
            html+=`
              <li class="nav-item">
                  <a class="nav-link" id="login" href="#" data-bs-toggle="modal"> <span><img class="img-circle" id="img_logo" src="images/powergreen.png" style="max-width: 50px; max-height: 50px" alt="login"></span></a>
              </li>
            `;
        }else{
            html+=`
                <li class="nav-item">
                    <a class="nav-link" id="questions" href="#"> <span><img class="img-circle" id="img_logo" src="images/question.png" style="max-width: 50px; max-height: 50px" alt="question"></i></span></a>
                </li>
            `;
            html+=`
              <li class="nav-item">
                  <a class="nav-link" id="logout" href="#" data-bs-toggle="modal"> <span><img class="img-circle" id="img_logo" src="images/powerred.png" style="max-width: 50px; max-height: 50px" alt="logout"></span></a>
              </li>
            `;
        };
        this.dom.querySelector('#app>#menu #menuItems').replaceChildren();
        this.dom.querySelector('#app>#menu #menuItems').innerHTML=html;
        this.dom.querySelector("#app>#menu #menuItems #welcome")?.addEventListener('click', e=>this.welcomeShow());
        this.dom.querySelector("#app>#menu #menuItems #questions")?.addEventListener('click',e=>this.questionsShow());   
        this.dom.querySelector("#app>#menu #menuItems #login")?.addEventListener('click',e=>this.modal.show());  
        this.dom.querySelector("#app>#menu #menuItems #logout")?.addEventListener('click',e=>this.logout());
        if(globalstate.user!==null){
            this.questionsShow()
        }
    }
    
    welcomeShow=()=> {
        this.dom.querySelector('#app>#body').replaceChildren(this.welcome.dom);
        this.welcome.render();
    }

    questionsShow=()=>{
        this.dom.querySelector('#app>#body').replaceChildren(this.questions.dom);
        this.questions.list();
    }
    
    login= async ()=>{
        const candidate = Object.fromEntries( (new FormData(this.dom.querySelector("#form"))).entries());
        candidate.questions = [];
        
        const userRequest = new Request(`${backend}/login`,{
            method:'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(candidate)
        })
        
        try{
            
            const response = await fetch(userRequest);
            
            if(!response.ok){
                const error = await response.text();
                console.log("LOGIN ERROR - "+error);
                return;
            }
            
            console.log("LOGIN SUCCESSFUL");
            const user = await response.json();
            globalstate.user = user;
            
            this.modal.hide();
            this.renderMenuItems();
            this.clearLoginModal();
        }catch(err){
            console.error(err);
        }
    }
    
    clearLoginModal = ()=>{
        this.dom.querySelector('#form #id').value = '';
        this.dom.querySelector('#form #password').value = '';
    }
    
    
    logout= async ()=>{
        globalstate.user=null;
        this.dom.querySelector('#app>#body').replaceChildren();
        this.renderBodyFiller();
        this.renderMenuItems();         
        const request = new Request(`${backend}/login`, {method: 'DELETE', headers: { }});
        const response = await fetch(request);
        
        if(!response.ok){
            console.log(`LOGOUT ERROR - ${response.status}`);
        }
        this.clearLoginModal();
    }
    
} 
