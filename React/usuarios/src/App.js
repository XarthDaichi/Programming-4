import logo from './logo.svg';
import './App.css';
import Users from './Users';

function App() {
  return (
    <div className="App">
      <Header/>
      <Body/>
      <Footer/>
    </div>
  );
}

function Header() {
  return (
    <header className="App-header">
      <img src={logo} className="App-logo" alt="logo" />
      <p>Sistema de Usuarios</p>
    </header>
  );
}

function Body() {
  return (
    <div className="App-body">
      <Users/>
    </div>
  );
}

function Footer() {
  return (
    <div className="App-footer">
      <img src={logo} className="App-logo" alt="logo" />
      <p>Xarthy Production</p>
    </div>
  );
}

export default App;
