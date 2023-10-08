import { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import Api from '../../../services/Api'
import { useCrudData } from '../../../contexts/CrudContext/CrudContext';

export default function SelectInput(props) {

  const [value, setValue] = useState(props.value || 0),
    [options, setOptions] = useState([])

  const getOptions = () => {
    Api.getQuery(props.input.endpoint,{select:true})
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
    setValue(props.value || 0)
  }, [])

  const handleValueChange = (newValue) => {
    const selectedOption = options.find((option) => option.id === newValue);
    setValue(newValue)
    props.handleInputValueChange(props.input.name, selectedOption)
  }

  return (
    <Box sx={{ minWidth: 120 }}>
      <FormControl fullWidth>
        <InputLabel id={props.input.name}>{props.input.label}</InputLabel>
        <Select
          labelId={props.input.name}
          value={value}
          onChange={(event) => handleValueChange(event.target.value)}
          required
        >
          <MenuItem key={0} value={0}>{"--Sin seleccionar--"}</MenuItem>
          {options.map((option, key) => {
            return <MenuItem key={key + 1} value={option?.id}>{option?.descripcion}</MenuItem>
          })}
        </Select>
      </FormControl>
    </Box>
  );
}
