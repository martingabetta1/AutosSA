import { useEffect, useState } from 'react';
import CrudTemplate from '../components/CrudTemplate';
import CreateDialog from '../components/dialogs/CreateDialog';
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import Api from '../services/Api';


export default function Vehiculo() {
  const title = "Vehiculo",
    { CrudContext } = useCrudData()

  const [, setDialogData] = CrudContext.dialogs.data,
    [, setDialogInputs] = CrudContext.inputs,
    [endpoints, setEndpoints] = CrudContext.query.endpoints,
    [rows, setRows] = CrudContext.crudStructure.rows,
    [columns, setColumns] = CrudContext.crudStructure.columns

  let rowsTemplate = [
    {
      id: 1,
      patente: "ABC123",
      modelo: 2,
      anio: 2020,
      kilometros: 15000,
      cliente: 2,
      observaciones: "Buen estado general"
    },
    {
      id: 2,
      patente: "XYZ789",
      modelo: 6,
      anio: 2018,
      kilometros: 22000,
      cliente: 1,
      observaciones: "Necesita cambio de aceite"
    },
    {
      id: 3,
      patente: "DEF456",
      modelo: 3,
      anio: 2019,
      kilometros: 18000,
      cliente: 5,
      observaciones: "Aire acondicionado defectuoso"
    },
    {
      id: 4,
      patente: "GHI789",
      modelo: 4,
      anio: 2022,
      kilometros: 8000,
      cliente: 4,
      observaciones: "Ninguna"
    }
  ];

  const columnsTemplate = [
    { field: 'id', headerName: 'ID', flex: 1 },
    { field: 'patente', headerName: 'Patente', flex: 1 },
    { field: 'modelo', headerName: 'Modelo', flex: 1 },
    { field: 'anio', headerName: 'Año', flex: 1 },
    { field: 'kilometros', headerName: 'Kilómetros', flex: 1 },
    { field: 'cliente', headerName: 'Cliente', flex: 1 },
    { field: 'observaciones', headerName: 'Observaciones', flex: 1 },
  ];

  useEffect(() => {
    setEndpoints({
      fetch: '/vehiculo',
      create: '/vehiculo',
      edit: '/vehiculo',
      delete: '/vehiculo'
    })
    setDialogData({
      title: 'vehiculo'
    })
    setDialogInputs([
      {
        name: 'patente',
        label: 'Patente',
        type: 'text',
        validations: {
          length: 7,
          type:'text'
        }
      },
      {
        name: 'modelo',
        label: 'Modelo',
        type: 'select',
        endpoint:'/modelos',
      },
      {
        name: 'anio',
        label: 'Año',
        type: 'number',
        validations: {
          length: 4,
          type:'number'
        },
      },
      {
        name: 'kilometros',
        label: 'Kilómetros',
        type: 'number',
        validations: {
          length: 9,
          type:'number'
        },
      },
      {
        name: 'cliente',
        label: 'Cliente',
        type: 'select',
        endpoint:'/clientes',
      },
      {
        name: 'observaciones',
        label: 'Observaciones',
        type: 'multiline',
        validations: {
          length:100,
          type:'text'
        },
      },
    ])
    setRows(rowsTemplate)
    setColumns(columnsTemplate)
    // getRegisters()
  }, [])

  const getRegisters = async () => {
    await Api.getQuery('/vehiculo')
      .then((res) => {
        setRows(res)
      }).catch((error) => {
        throw new Error(error.message)
      })
  }
  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <div>
          <h1 className="crud-title">{title}</h1>
        </div>
        <CreateDialog />
      </div>
      <CrudTemplate
        rows={rows}
        columns={columns}
      />
    </div>
  )
}
