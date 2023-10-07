import { useState } from 'react';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import dayjs from 'dayjs';

export default function DateInput(props) {

    const [value,setValue] = useState(dayjs(props.value) || dayjs())

    const handleChangeValue = (newValue)=>{
        setValue(newValue)
        props.handleInputValueChange(props.input.name,newValue)
    }

    return (
        <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker
                label={props.input.label}
                value={value}
                onChange={(event) => handleChangeValue(event.target.value)}
            />
        </LocalizationProvider>
    );
}