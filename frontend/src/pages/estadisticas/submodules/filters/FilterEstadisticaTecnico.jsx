import { useEffect, useState } from "react"
import { useError } from "../../../../contexts/Error"
import { FormControl, InputLabel, MenuItem, Select } from "@mui/material"
import Api from "../../../../services/Api"
import { filterQueryConstructor } from "../../../../functions/filterQueryConstructor"


const FilterEstadisticaTecnico = ({filtersEstadisticas,filtersEstadisticasQuery}) => {

    const [tecnicos, setTecnicos] = useState([])

    const { ErrorContext } = useError()

    const getTecnicos = () => {
        Api.getQuery('/tecnicos', { select: true })
            .then((res) => {
                setTecnicos(res)
            })
            .catch((error) => {
                ErrorContext.setError(
                    {
                        state: true, message: `Error al intentar listar los tecnicos\n
                ${error.message}`
                    }
                )
            })
    }

    const handleChange = (value,key) => {
        let newValue = value === 'n' ? '' : value
        filtersEstadisticas[1]((prevState)=>{
            let newState = { ...prevState }
            newState[key] = newValue
            filterQueryConstructor(newState, filtersEstadisticasQuery[1])
            return newState
        })
    }

    const generateFilter = () => {
        return <FormControl fullWidth>
            <InputLabel>Técnico</InputLabel>
            <Select
                value={filtersEstadisticas[0].tecnico === 0 ? 0 : filtersEstadisticas[0].tecnico || 'n'}
                onChange={(event) => handleChange(event.target.value,'tecnico')}
            >
                <MenuItem key = {'n'} value={'n'}>-- Sin Seleccionar --</MenuItem>
                {
                    tecnicos.map((value, key) => {
                        return <MenuItem key = {value.id} value={value.id}>{value.descripcion}</MenuItem>
                    })
                }

            </Select>
        </FormControl>
    }

    useEffect(() => {
        getTecnicos()
    }, [])

    useEffect(() => {
        generateFilter()
    }, [tecnicos])


    return (
        <>
            {generateFilter()}
        </>
    )
}

export { FilterEstadisticaTecnico }