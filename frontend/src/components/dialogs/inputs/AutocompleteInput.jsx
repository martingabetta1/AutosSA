import { useEffect, useState } from 'react'
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';

export default function AutocompleteInput(props) {

    const [value, setValue] = useState()

    useEffect(() => {
        setValue(props.value)
    }, [props.value])

    const handleValueChange = (newValue) => {
        setValue(newValue)
        props.handleChangeBodyData(props.input.name, newValue)
    }

    return (
        <div>
            <Autocomplete
                disablePortal
                options={[]}
                defaultValue={value}
                value={value}
                sx={{ width: 300 }}
                renderInput={(params) => <TextField {...params} label={props.input.label} />}
                onChange={(event)=>handleValueChange(event.target.value)}
            />
        </div>
    )
}
