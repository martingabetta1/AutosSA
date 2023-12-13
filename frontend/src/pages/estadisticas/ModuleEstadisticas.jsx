import { useEffect } from "react"
import { Graphic } from "./submodules/Graphic"
import { TableEstadisticas } from "./submodules/TableEstadisticas"
import { useState } from "react"
import Api from "../../services/Api"


const ModuleEstadisticas = ({ components }) => {

    const [data, setData] = useState([])

    const getData = async () => {
        await Api.getQuery(components.endpoint, null, "")
            .then((res) => {
                setData(res)
            })
            .catch(() => {
                throw new Error()
            })
    }

    useEffect(() => {
        getData()
    }, [])

    return (
        <>
            <div style={{marginBottom:"150px"}}>
                <h1>{components.title}</h1>
                <TableEstadisticas components={components} data={data} />
                <Graphic components={components} data={data} />
            </div>
        </>
    )
}

export { ModuleEstadisticas }