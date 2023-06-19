import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Details from './pages/Details';
import Home from './pages/Home';
import { Pacientes } from './pages/Pacientes';
import { Turnos } from './pages/Turnos';


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/details/:id" element={<Details />} />
        <Route path="/pacientes" element={<Pacientes />} />
        <Route path="/turnos" element={<Turnos />} />
        <Route path="*" element={<h1>Not Found</h1>} />
      </Routes>
    </Router>
  );
}

export default App;
