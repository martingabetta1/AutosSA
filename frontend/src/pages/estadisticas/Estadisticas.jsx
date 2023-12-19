import { useRef } from "react";
import { ModuleEstadisticas } from "./ModuleEstadisticas"
import { useReactToPrint } from 'react-to-print';
import { Button } from "@mui/material";


const Estadisticas = () => {

    const componentsRefs = {
        modelosPorVehiculo: useRef(),
        ordenesPorEstado: useRef(),
        diasPromedioPorTecnico: useRef(),
        gananciasMensuales: useRef()
    }

    const estadisticas = {
        modelosPorVehiculo: {
            title: "Cantidad de ordenes por modelo de vehiculo",
            endpoint: "/estadisticas/modelos-ordenes",
            columns: ["Nombre del modelo", "Cantidad de ordenes asociadas"],
            keysAccess: ["nombreModelo", "cantidadOrdenes"],
            filters: ['fecha', 'tecnico']
        },
        ordenesPorEstado: {
            title: "Cantidad de ordenes en cada estado",
            endpoint: "/estadisticas/estados-ordenes",
            columns: ["Nombre del estado", "Cantidad de ordenes asociadas"],
            keysAccess: ["nombreEstado", "cantidadOrdenes"],
            filters: ['fecha', 'tecnico']
        },
        diasPromedioPorTecnico: {
            title: "Dias promedio de reparación por técnico",
            endpoint: "/estadisticas/promedios-tecnicos",
            columns: ["Nombre de técnico", "Dias promedio"],
            keysAccess: ["nombreTecnico", "diasPromedio"],
            filters: ['fecha', 'tecnico']
        },
        gananciasMensuales: {
            title: "Ganancias por mes",
            endpoint: "/estadisticas/ganancias-mensuales",
            columns: ["Mes", "Ganancia"],
            keysAccess: ["mes", "ganancia"],
            filters: ['fecha', 'tecnico']
        }
    }

    const print = useReactToPrint({
        content: () => componentsRefs.current,
    });
    
    const handlePrint = (attr)=>{
        componentsRefs.current = componentsRefs[attr].current
        print()
    }

    return (
        <>
            <div style={{ padding: "20px 250px" }}>
                <div style={{ marginBottom: "150px" }}>
                    <ModuleEstadisticas ref={componentsRefs.modelosPorVehiculo} components={estadisticas.modelosPorVehiculo} />
                    <Button variant='contained' className="button-print" onClick={()=>handlePrint('modelosPorVehiculo')}>Imprimir estadisticas<img src='/images/print.png' alt='imprimir' className="img-print"/></Button>
                </div>
                <div style={{ marginBottom: "150px" }}>
                    <ModuleEstadisticas ref={componentsRefs.ordenesPorEstado} components={estadisticas.ordenesPorEstado} />
                    <Button variant='contained' className="button-print" onClick={()=>handlePrint('ordenesPorEstado')}>Imprimir estadisticas<img src='/images/print.png' alt='imprimir' className="img-print"/></Button>
                </div>
                <div style={{ marginBottom: "150px" }}>
                    <ModuleEstadisticas ref={componentsRefs.diasPromedioPorTecnico} components={estadisticas.diasPromedioPorTecnico} />
                    <Button variant='contained' className="button-print" onClick={()=>handlePrint('diasPromedioPorTecnico')}>Imprimir estadisticas<img src='/images/print.png' alt='imprimir' className="img-print"/></Button>
                </div>
                <div style={{ marginBottom: "150px" }}>
                    <ModuleEstadisticas ref={componentsRefs.gananciasMensuales} components={estadisticas.gananciasMensuales} />
                    <Button variant='contained' className="button-print" onClick={()=>handlePrint('gananciasMensuales')}>Imprimir estadisticas<img src='/images/print.png' alt='imprimir' className="img-print"/></Button>
                </div>
            </div>
        </>
    )
}

export { Estadisticas }