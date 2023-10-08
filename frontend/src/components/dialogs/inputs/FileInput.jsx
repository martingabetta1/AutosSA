import { FormControl } from "@mui/base"
import { useState } from "react";
import { styled } from '@mui/material/styles';
import Button from '@mui/material/Button';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';

const VisuallyHiddenInput = styled('input')({
    clip: 'rect(0 0 0 0)',
    clipPath: 'inset(50%)',
    height: 1,
    overflow: 'hidden',
    position: 'absolute',
    bottom: 0,
    left: 0,
    whiteSpace: 'nowrap',
    width: 1,
  });

export default function FileInput(props){
    const [value, setValue] = useState();

    const handleChangeValue = (newValue)=>{
        setValue(newValue)
        props.handleInputValueChange(props.input.name,newValue)
    }

    return(
        <FormControl>
            <Button component="label"
            variant="contained"
            startIcon={<CloudUploadIcon />}
            onClick={(event)=> handleChangeValue(event.target.value)}
            >
                {props.input.label}
            <VisuallyHiddenInput
            type="file"
            value={value}
            />
            </Button>
        </FormControl>
    );
}