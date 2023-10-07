import { useEffect, useState } from 'react';
import TextField from '@mui/material/TextField';
import { useCrudData } from '../../../contexts/CrudContext/CrudContext';


export default function TextInput(props) {

    const [value, setValue] = useState()

    useEffect(() => {
        setValue(props.value)
    }, [props.value])

    
    const handleValueChange = (newValue)=>{
        props.isNumber ? newValue = parseInt(newValue) : void (0)
        setValue(newValue)
        props.handleInputValueChange(props.input.name, newValue)
    }

    return (
        <>
            <TextField
                label={props.input.label}
                variant="outlined"

                //multilinea
                multiline={props.isMultiline}
                rows={4}
                
                value={value || ""}
                onChange={(event) => handleValueChange(event.target.value)}
            />
        </>
    )  
}
