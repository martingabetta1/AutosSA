import { ModuleEstadisticas } from "./ModuleEstadisticas"


const Estadisticas = () => {

    const estadisticas = {
        modelosPorVehiculo: {
            title: "Cantidad de ordenes por modelo de vehiculo",
            endpoint: "/estadisticas/modelos-ordenes",
            columns: ["Nombre del modelo", "Cantidad de ordenes asociadas"],
            keysAccess: ["nombreModelo", "cantidadOrdenes"],
            filters:['fecha','tecnico']
        },
        ordenesPorEstado: {
            title: "Cantidad de ordenes en cada estado",
            endpoint: "/estadisticas/estados-ordenes",
            columns: ["Nombre del estado", "Cantidad de ordenes asociadas"],
            keysAccess: ["nombreEstado", "cantidadOrdenes"],
            filters:['fecha','tecnico']
        },
        diasPromedioPorTecnico: {
            title: "Dias promedio de reparación por técnico",
            endpoint: "/estadisticas/promedios-tecnicos",
            columns: ["Nombre de técnico", "Dias promedio"],
            keysAccess: ["nombreTecnico", "diasPromedio"],
            filters:['fecha','tecnico']
        },
        gananciasMensuales: {
            title: "Ganancias por mes",
            endpoint: "/estadisticas/ganancias-mensuales",
            columns: ["Mes", "Ganancia"],
            keysAccess: ["mes", "ganancia"],
            filters:['fecha','tecnico']
        }
    }

    return (
        <>
            <div style={{padding:"20px 250px"}}>
                <ModuleEstadisticas components={estadisticas.modelosPorVehiculo} />
                <ModuleEstadisticas components={estadisticas.ordenesPorEstado} />
                <ModuleEstadisticas components={estadisticas.diasPromedioPorTecnico} />
                <ModuleEstadisticas components={estadisticas.gananciasMensuales} />
            </div>
        </>
    )
}

export { Estadisticas }