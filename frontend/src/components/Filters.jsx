import * as React from 'react';
import Accordion from '@mui/material/Accordion';
import AccordionSummary from '@mui/material/AccordionSummary';
import AccordionDetails from '@mui/material/AccordionDetails';
import Typography from '@mui/material/Typography';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import { FormControl, InputLabel, MenuItem, Select, TextField } from '@mui/material';
import { useMemo } from 'react';
import { filterQueryConstructor } from '../functions/filterQueryConstructor'
import { useEffect } from 'react';

export default function Filters() {

    const { CrudContext } = useCrudData(),
        [columns] = CrudContext.crudStructure.columns,
        [filtersValues, setFiltersValues] = CrudContext.filters.filtersValues,
        [, setFiltersQuery] = CrudContext.filters.filtersQuery,
        [showDeleteds,setShowDeleteds] = CrudContext.filters.showDeleteds

    useEffect(() => {
        setFiltersValues(() => {
            let initialObject = {}
            columns.map((field, key) => {
                initialObject[field.field.replace(/\.\w+$/, '')] = ""
            })
            return initialObject
        })
    }, [])

    const generateFilters = useMemo(() => {
        return columns.map((field, key) => {
            return <div key={key}><TextField variant="standard" label={field.headerName} onChange={(event) => handleFilterValueChange(field.field.replace(/\.\w+$/, ''), event.target.value)} /></div>
        })
    }, [columns, filtersValues])

    const handleFilterValueChange = (field, value) => {
        setFiltersValues((prevState) => {
            let newState = { ...prevState }
            newState[field] = value
            filterQueryConstructor(newState, setFiltersQuery)
            return newState
        })
    }


    const isFiltersNotEmpty = useMemo(() => {
        for (let filter in filtersValues) {
            if (filtersValues[filter] !== "") {
                return false
            }
        }
        return true
    }, [filtersValues])

    return (
        <div>
            <Accordion>
                <AccordionSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel1a-content"
                    id="panel1a-header"
                >
                    <Typography>Filtros</Typography>&nbsp;&nbsp;
                    {!isFiltersNotEmpty && (<Typography style={{ color: "blue" }}>(Hay filtros colocados)</Typography>)}
                </AccordionSummary>
                <AccordionDetails>
                    <div style={{ display: "flex", justifyContent: "space-around" }}>
                        {generateFilters}
                        <div key={"select"}>
                            <FormControl fullWidth>
                                <InputLabel>Visualización de registros</InputLabel>
                                <Select
                                    style={showDeleteds ? {color:"red"} : {color:"blue"}}
                                    value={showDeleteds}
                                    label="Age"
                                    onChange={(event)=>setShowDeleteds(event.target.value)}
                                >
                                    <MenuItem value={false}>Mostrar habilitados</MenuItem>
                                    <MenuItem value={true}>Mostrar eliminados</MenuItem>
                                </Select>
                            </FormControl>
                        </div>
                    </div>
                </AccordionDetails>
            </Accordion>
        </div>
    );
}