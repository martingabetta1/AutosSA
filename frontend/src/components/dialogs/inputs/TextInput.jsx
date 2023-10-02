import { useEffect, useState } from 'react';
import TextField from '@mui/material/TextField';

export default function TextInput(props) {

    const[value,setValue] = useState()

    useEffect(()=>{
        setValue(props.value)
    },[props.value])

    const handleValueChange = (newValue)=>{
        setValue(newValue)
        props.handleChangeBodyData(props.input.name, newValue)
    }
    

    return (
        <>
            <TextField
                label={props.input.label}
                variant="outlined"
                value={value || ""}
                onChange={(event) => handleValueChange(event.target.value)}
            />
        </>
    )
}
