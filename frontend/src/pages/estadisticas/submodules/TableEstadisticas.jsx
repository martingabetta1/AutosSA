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

const TableEstadisticas = ({ endpoint }) => {

  const [rows, setRows] = useState([])


  const getData = async () => {
    await Api.getQuery(endpoint,null,null)
      .then((res) => {
        setRows(res)
      })
      .catch(() => {
        throw new Error()
      })
  }

  const constructRows = useMemo(()=>{
    return rows.map((row) => (
      <TableRow
        key={row.name}
        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
      >
        <TableCell component="th" scope="row">
          {row.name}
        </TableCell>
        <TableCell align="right">{row.calories}</TableCell>
      </TableRow>
    ))
  },[rows])

  useEffect(() => {
    getData()
  }, [endpoint])

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell>Dessert (100g serving)</TableCell>
            <TableCell align="right">Calories</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {constructRows}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export { TableEstadisticas }