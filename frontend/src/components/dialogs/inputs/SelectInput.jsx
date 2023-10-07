import { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import Api from '../../../services/Api'

export default function SelectInput(props) {

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
    props.handleChangehandleInputValueChangeBodyData(props.input.name, newValue)
  }

  return (
    <Box sx={{ minWidth: 120 }}>
      <FormControl fullWidth>
        <InputLabel id={props.input.name}>{props.input.label}</InputLabel>
        <Select
          labelId={props.input.name}
          defaultValue={props.value}
          value={value}
          onChange={(event) => handleValueChange(event.target.value)}
        >
          {options.map((value, key) => {
            return <MenuItem key={key} value={value}>{value}</MenuItem>
          })}
        </Select>
      </FormControl>
    </Box>
  );
}
