/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
class Questions{
  dom;
  modal;
  
  state;  // state variables: entities, entity, mode (Add|Edit)

  constructor(){
    this.state = {'entities': new Array(), 'entity': this.emptyEntity(), 'mode':'A'};
    this.dom=this.render();
    this.modal = new bootstrap.Modal(this.dom.querySelector('#optionsmodal'));
    this.dom.querySelector("#questions #create").addEventListener('click',this.makenew);        
    this.dom.querySelector("#questions #search").addEventListener('click',this.search);
    this.dom.querySelector('#submit').addEventListener('click',this.solve);
  }
  
  render=()=>{
    const html= `
            ${this.renderList()}
            ${this.renderModal()}    
        `;
       var rootContent= document.createElement('div');
       rootContent.id='questions';       
       rootContent.innerHTML=html;
       return rootContent;
  }

   renderList=()=>{
     return `
        <div id="list" class="container">     
            <div class="card bg-light">
                <h4 class="card-title mt-3 text-center">Questions</h4>    
                <div class="card-body mx-auto w-75" >
                    <form id="form">
                        <div class="input-group mb-3">
                            <span class="input-group-text">Topic</span>
                            <input id="topic" type="text" class="form-control">
                          <div class="btn-toolbar">
                            <div class="btn-group me-2"><button type="button" class="btn btn-primary" id="search">Search</button> </div>
                            <div class="btn-group me-2"><button type="button" class="btn btn-primary" id="create">Create</button> </div>                        
                          </div>  
                        </div>
                    </form>

                    <div class="table-responsive " style="max-height: 300px; overflow: auto">
                        <table class="table table-striped table-hover">
                            <thead><tr><th scope="col">Question</th><th scope="col">Topic</th></tr></thead>
                            <tbody id="listbody">
                            </tbody>
                        </table>
                    </div>                 
                </div>
            </div>
        </div>
        `;
   }
   
   renderModal=()=>{
     return `
        <div id="optionsmodal" class="modal fade" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div id="modal-header-content" class="modal-header" >
                    </div>
                    <form id="form-option" >
                   <div id="modal-options-content" class="modal-body">
                   </div>
                   <div class="modal-footer">
                       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="cancel">Cancel</button>
                       <button id="submit" type="button" class="btn btn-primary">Submit</button>
                   </div>               
                   </form>                
                </div>         
            </div>          
        </div>      
        `;     
    }

    showModal= async ()=>{
        // Load entity data into modal form
        this.modal.show();
  }
  
    load=()=>{
        // Save modal form data into entity        
    }
    
    reset=()=>{
        this.state.entity=this.emptyEntity();
    }
    
    emptyEntity=()=>{
        // return an empty entity
    }


  add=()=>{
      // Validate data, load into entity, invoque backend for adding
    this.list();
    this.reset();
    this.modal.hide();
  } 
  
  update=()=>{
    // Validate data, load into entity, invoque backend for updating    
    this.list();
    this.reset();
    this.modal.hide();
  }
  
   validate=()=>{
       // validate data
  }

  list=()=>{
    const request = new Request(`${backend}/questions?username=${globalstate.user.username}`, {method: 'GET', headers: { }});
    (async ()=>{
        const response = await fetch(request);
        if (!response.ok) {errorMessage(response.status);return;}
        var questions = await response.json();
        this.state.entities = questions;
        const listing=this.dom.querySelector("#questions #list #listbody");
        listing.innerHTML='';
        this.state.entities.forEach( q=>{
            const row =document.createElement("tr");
            row.innerHTML=`
                    <td><button id="${q.question}/${q.topic}" class="btn btn-primary" data-id="${q.question}">${q.question}</button></td>
                    <td>${q.topic}</td>`;
            const button = row.querySelector('button');
            button.addEventListener('click', e=>this.showOptions(e));
            listing.appendChild(row); 
        });         
    })();       
  }
  
  showOptions = async (event) => {
      let target = event.target;
        
        if (target.tagName !== 'BUTTON') {
            target = target.parentElement;
        }
        
        const question = target.dataset.id;
        
        const options = await this.renderOptions(question);
        
        const modalHeader = this.dom.querySelector('#modal-header-content');
        modalHeader.innerHTML = `
            <span id="question-span" style='margin-left:4em;font-weight: bold;'>${question}</span>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        `;
        
        const modalContent = this.dom.querySelector('#modal-options-content');
        modalContent.innerHTML = options;
        
        this.modal.show();
  }
  
  renderOptions = async (question_parameter) => {
      const question_answering = this.state.entities.find(q => q.question === question_parameter);
      
      var html = '';
      
      for (const key in question_answering.responses) {
          html +=`
            <div class="form-group">
              <label for="radio${key}">${key}</label>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="radioOptions" id="radio${key}" value="${key}">
              </div>
            </div>
          `;
      }
      return html;
  }
  
  makenew=()=>{
      this.reset();
      this.state.mode='A'; //adding
      this.showModal();
  }
    
  search=()=>{
      var topic = document.querySelector("#questions #topic").value;
      const request = new Request(`${backend}/questions?username=${globalstate.user.username}&topic=${topic}`, {method: 'GET', headers: { }});
    (async ()=>{
        const response = await fetch(request);
        if (!response.ok) {errorMessage(response.status);return;}
        var questions = await response.json();
        this.state.entities = questions;
        var listing=this.dom.querySelector("#questions #list #listbody");
        listing.innerHTML="";
        this.state.entities.forEach( e=>this.row(listing,e));         
    })();  
  }
  
  solve = async () => {
      const option = this.dom.querySelector('input[name="radioOptions"]:checked');
      const question = this.dom.querySelector('#question-span')
      const request = new Request(`${backend}/questions/${globalstate.user.username}/${question.textContent}/${option.value}`, {
          method: 'GET',
          headers: { }
      });
      
      const response = await fetch(request);
      if(!response.ok) {
          errorMessage(response.status);
          return;
      }
      
      var solution = await response.json();
  }
} 
