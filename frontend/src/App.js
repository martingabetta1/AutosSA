import './App.css';
import "./sass/styles.css";
import { BrowserRouter as Router, Route, Routes, Navigate, Outlet } from "react-router-dom";
import Marca from './pages/Marca';
import Modelo from './pages/Modelo';
import Tecnico from './pages/Tecnico';
import Vehiculo from './pages/Vehiculo';
import Cliente from './pages/Cliente';
import Orden from './pages/Orden';
import Home from './pages/Home';
import Drawer from './components/Drawer';
import CrudContextProvider from './contexts/CrudContext'

function App() {
  return (
    <div className="App">
      <CrudContextProvider>
        <Router>
          <Drawer />
          <Routes>
            <Route path={"/"} element={<Home />} />
            <Route path={"/marca"} element={<Marca />} />
            <Route path={"/modelo"} element={<Modelo />} />
            <Route path={"/tecnico"} element={<Tecnico />} />
            <Route path={"/vehiculo"} element={<Vehiculo />} />
            <Route path={"/cliente"} element={<Cliente />} />
            <Route path={"/orden"} element={<Orden />} />
          </Routes>
        </Router>
      </CrudContextProvider>
    </div>
  );
}

export default App;
