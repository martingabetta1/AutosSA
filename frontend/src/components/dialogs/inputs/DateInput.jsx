import { useEffect, useState } from 'react';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import dayjs from 'dayjs';

export default function DateInput(props) {

    const [value,setValue] = useState(dayjs(props.value) || dayjs())

    const handleChangeValue = (newDate)=>{
        setValue(newDate)
        props.handleInputValueChange(props.input.name,newDate)
    }

    useEffect(()=>{
        props.handleInputValueChange(props.input.name,value)
    },[])

    return (
        <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker
                label={props.input.label}
                value={value}
                onChange={handleChangeValue}
            />
        </LocalizationProvider>
    );
}