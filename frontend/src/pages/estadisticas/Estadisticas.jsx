import { ModuleEstadisticas } from "./ModuleEstadisticas"


const Estadisticas = (props)=>{

    const endpoints = {
        modelosPorVehiculo: "/estadisticas/modelos-cantidad-ordenes"
    }


    return(
        <>
            <ModuleEstadisticas endpoint={endpoints.modelosPorVehiculo} />
        </>
    )
}

export {Estadisticas}