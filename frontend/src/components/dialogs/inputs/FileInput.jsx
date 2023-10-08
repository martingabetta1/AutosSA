import React, { useState } from 'react';
import Button from '@mui/material/Button';
import FormControl from '@mui/material/FormControl';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import Input from '@mui/material/Input'; // Importa el componente Input

export default function FileInput(props) {
  const [value, setValue] = useState();
    
  const handleChangeValue = (event) => {
    const newValue = event.target.files[0]; // Obtén el archivo seleccionado
    setValue(newValue);
    props.handleInputValueChange(props.input.name, newValue);
  };

  return (
    <FormControl>
      <input
        type="file"
        accept={'image/*, application/pdf'} 
        onChange={handleChangeValue}
        style={{ display: 'none' }}
        id={props.input.name}
      />
      <label htmlFor={props.input.name}>
        <Button
          component="span"
          variant="contained"
          startIcon={<CloudUploadIcon />}
        >
          {props.input.label}
        </Button>
      </label>
      <Input 
        value={value ? value.name : ''}
        readOnly
      />
    </FormControl>
  );
}
