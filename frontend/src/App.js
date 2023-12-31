import './App.css';
import "./sass/styles.css";
import { BrowserRouter as Router, Route, Routes, Navigate, Outlet } from "react-router-dom";
import Marca from './pages/Marca';
import Modelo from './pages/Modelo';
import Tecnico from './pages/Tecnico';
import Vehiculo from './pages/Vehiculo';
import Cliente from './pages/Cliente';
import Visita from './pages/Visita';
import Orden from './pages/ordenes/Orden';
import Home from './pages/Home';
import Drawer from './components/Drawer';
import Footer from './components/Footer'
import CrudContextProvider from './contexts/CrudContext/CrudContext'
import ErrorProvider from './contexts/Error'
import Servicio from './pages/ordenes/Servicio';
import { PrincipalLoader } from './global/components/PrincipalLoader'
import { Estadisticas } from './pages/estadisticas/Estadisticas';

function App() {
  return (
    <div className="App">
      <ErrorProvider>
        <CrudContextProvider>
          <PrincipalLoader />
          <Router>
            <Drawer />
            <Routes>
              <Route path={"/"} element={<Home />} />
              <Route path={"/marca"} element={<Marca />} />
              <Route path={"/modelo"} element={<Modelo />} />
              <Route path={"/tecnico"} element={<Tecnico />} />
              <Route path={"/vehiculo"} element={<Vehiculo />} />
              <Route path={"/cliente"} element={<Cliente />} />
              <Route path={"/visita"} element={<Visita />} />
              <Route path={"/orden"} element={<Orden />} />
              <Route path={"/servicio"} element={<Servicio />} />
              <Route path={"/estadisticas"} element={<Estadisticas />} />
            </Routes>
          </Router>
          <Footer />
        </CrudContextProvider>
      </ErrorProvider>
    </div>
  );
}

export default App;
