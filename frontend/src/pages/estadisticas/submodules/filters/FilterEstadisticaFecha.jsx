import { DatePicker, LocalizationProvider } from "@mui/x-date-pickers"
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs"
import dayjs from "dayjs";
import { useCrudData } from "../../../../contexts/CrudContext/CrudContext";
import { filterQueryConstructor } from "../../../../functions/filterQueryConstructor";


const FilterEstadisticaFecha = ({filtersEstadisticas,filtersEstadisticasQuery}) => {


    const handleChange = (value,key) => {
        let newValue = dayjs(value).format('DD-MM-YYYY')
        filtersEstadisticas[1]((prevState)=>{
            let newState = { ...prevState }
            newState[key] = newValue
            filterQueryConstructor(newState, filtersEstadisticasQuery[1])
            return newState
        })

    }

    return (
        <>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
                <div style={{ display: 'flex', justifyContent: 'center' }}>
                    <div><DatePicker label='Fecha inicio' onChange={(event) => handleChange(event, 'fechaInicio')} /></div>
                    <div><DatePicker label='Fecha fin' onChange={(event) => handleChange(event, 'fechaFin')} /></div>
                </div>
            </LocalizationProvider>
        </>
    )
}

export { FilterEstadisticaFecha }