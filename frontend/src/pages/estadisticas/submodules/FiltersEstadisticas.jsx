import { FormControl, InputLabel, MenuItem, Select } from "@mui/material"
import { useEffect, useMemo, useState } from "react"
import Api from "../../../services/Api"
import { useError } from "../../../contexts/Error"
import { FilterEstadisticaTecnico, FilterEstadisticaFecha } from "./filters"


const FiltersEstadisticas = ({ filters,filtersEstadisticas,filtersEstadisticasQuery, }) => {




    return (
        <>
            {filters.includes('tecnico') && (
                <FilterEstadisticaTecnico
                    filtersEstadisticas={filtersEstadisticas}
                    filtersEstadisticasQuery={filtersEstadisticasQuery}
                />
            )}
            {filters.includes('fecha') && (
                <FilterEstadisticaFecha
                    filtersEstadisticas={filtersEstadisticas}
                    filtersEstadisticasQuery={filtersEstadisticasQuery}
                />
            )}
        </>
    )
}


export { FiltersEstadisticas }