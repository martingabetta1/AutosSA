import { forwardRef, useEffect } from "react"
import { Graphic } from "./submodules/Graphic"
import { TableEstadisticas } from "./submodules/TableEstadisticas"
import { FiltersEstadisticas } from "./submodules/FiltersEstadisticas"
import { useState } from "react"
import Api from "../../services/Api"


export const ModuleEstadisticas = forwardRef(({ components }, ref) => {

    const [data, setData] = useState([])

    const [filtersEstadisticas, setFilterEstadisticas] = useState({
        tecnico: '',
        fechaInicio: '',
        fechaFin: ''
    }),
        [filtersEstadisticasQuery, setFilterEstadisticasQuery] = useState('')

    const getData = async () => {
        await Api.getQuery(components.endpoint, null, filtersEstadisticasQuery)
            .then((res) => {
                setData(res)
            })
            .catch(() => {
                throw new Error()
            })
    }

    useEffect(() => {
        getData()
    }, [filtersEstadisticasQuery])

    return (
        <>
            <div style={{ marginBottom: "50px" }} ref={ref}>
                <h1>{components.title}</h1>
                <FiltersEstadisticas filters={components.filters} filtersEstadisticas={[filtersEstadisticas, setFilterEstadisticas]} filtersEstadisticasQuery={[filtersEstadisticasQuery, setFilterEstadisticasQuery]} />
                <TableEstadisticas components={components} data={data} />
                <Graphic components={components} data={data} />
            </div>
        </>
    )
})
