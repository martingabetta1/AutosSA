import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Api from '../../../services/Api'
import { useState } from 'react';
import { useEffect } from 'react';
import { useMemo } from 'react';

const TableEstadisticas = ({ components, data }) => {


  const constructRows = useMemo(() => {
    return data.map((row, key) => (
      <TableRow
        key={key}
        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
      >
        <TableCell component="th" scope="row">
          {row[components.keysAccess[0]]}
        </TableCell>
        <TableCell align="right">{row[components.keysAccess[1]]}</TableCell>
      </TableRow>
    ))
  }, [data])

  return (
    <>
      <h3 style={{display:"table",color:"grey"}}>Tabla de estadisticas</h3>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
          <TableHead>
            <TableRow>
              <TableCell style={{background:"#CDCDCD",borderRight:"1px solid #8A8A8A"}}>{components.columns[0]}</TableCell>
              <TableCell style={{background:"#CDCDCD"}}>{components.columns[1]}</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {constructRows}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
}

export { TableEstadisticas }