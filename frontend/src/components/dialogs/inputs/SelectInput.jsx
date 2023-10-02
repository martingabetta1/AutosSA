import { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

export default function SelectInput(props) {

  const [value, setValue] = useState()

  useEffect(() => {
    setValue(props.value)
  }, [props.value])

  const handleValueChange = (newValue) => {
    setValue(newValue)
    props.handleChangeBodyData(props.input.name, newValue)
  }

  return (
    <Box sx={{ minWidth: 120 }}>
      <FormControl fullWidth>
        <InputLabel id={props.input.name}>Age</InputLabel>
        <Select
          labelId={props.input.name}
          defaultValue={props.value}
          value={value}
          label="Age"
          onChange={(event) => handleValueChange(event.target.value)}
        >
          <MenuItem value={10}>Ten</MenuItem>
          <MenuItem value={20}>Twenty</MenuItem>
          <MenuItem value={30}>Thirty</MenuItem>
        </Select>
      </FormControl>
    </Box>
  );
}
