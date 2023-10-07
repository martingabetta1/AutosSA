import { useEffect, useState } from 'react'
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import Api from '../../../services/Api'

export default function AutocompleteInput(props) {

    const [value, setValue] = useState(),
        [options, setOptions] = useState([])

    const getOptions = () => {
        Api.getQuery(props.input.endpoint)
            .then((res) => {
                setOptions(res)
            }).catch((error) => {
                throw new Error(error.message)
            })
    }

    useEffect(() => {
        // getOptions()
      }, [])

    useEffect(() => {
        setValue(props.value)
    }, [props.value])

    const handleValueChange = (newValue) => {
        setValue(newValue)
        props.handleInputValueChange(props.input.name, newValue)
    }

    return (
        <div>
            <Autocomplete
                disablePortal
                options={options}
                defaultValue={value}
                value={value}
                sx={{ width: 300 }}
                renderInput={(params) => <TextField {...params} label={props.input.label} />}
                onChange={(event) => handleValueChange(event.target.value)}
            />
        </div>
    )
}
