import * as React from 'react';
import Accordion from '@mui/material/Accordion';
import AccordionSummary from '@mui/material/AccordionSummary';
import AccordionDetails from '@mui/material/AccordionDetails';
import Typography from '@mui/material/Typography';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import { TextField } from '@mui/material';
import { useMemo } from 'react';
import { useCallback } from 'react';
import {filterQueryConstructor} from '../functions/filterQueryConstructor'
import { useEffect } from 'react';

export default function Filters() {

    const { CrudContext } = useCrudData(),
        [columns] = CrudContext.crudStructure.columns,
        [filtersValues,setFiltersValues] = CrudContext.filters.filtersValues,
        [,setFiltersQuery] = CrudContext.filters.filtersQuery

    useEffect(()=>{
        setFiltersValues(()=>{
            let initialObject = {}
            columns.map((field, key)=>{
                initialObject[field.field] = ""
            })
            return initialObject
        })
    },[])

    const generateFilters = useMemo(() => {
        return columns.map((field, key) => {
            return <div key={key}><TextField variant="standard" label={field.headerName} onChange={(event)=>handleFilterValueChange(field.field,event.target.value)}/></div>
        })
    }, [columns,filtersValues])

    const handleFilterValueChange = (field,value) =>{
        setFiltersValues((prevState)=>{
            let newState = {...prevState}
            newState[field] = value
            filterQueryConstructor(newState,setFiltersQuery)
            return newState
        })
    }

    return (
        <div>
            <Accordion>
                <AccordionSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel1a-content"
                    id="panel1a-header"
                >
                    <Typography>Filtros</Typography>
                </AccordionSummary>
                <AccordionDetails>
                    <div style={{display:"flex",justifyContent:"space-around"}}>
                        {generateFilters}
                        <TextField variant="standard" label={"nada"} style={{opacity:0}}/>
                    </div>
                </AccordionDetails>
            </Accordion>
        </div>
    );
}