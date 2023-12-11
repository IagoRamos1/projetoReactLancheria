import Home from '../src/Home.js';
import './App.css';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

function App() {
  return (
  <Router>
    <Routes>
      <Route path="/home" element={<Home />} />
    </Routes>
  </Router>
  );  
}

export default App;
