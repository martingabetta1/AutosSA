import { TableEstadisticas } from "./submodules/TableEstadisticas"


const ModuleEstadisticas = ({endpoint})=>{


    return(
        <>
            <h1>Cantidad de ordenes por modelo de vehiculo</h1>
            <TableEstadisticas endpoint={endpoint}/>
        </>
    )
}

export {ModuleEstadisticas}