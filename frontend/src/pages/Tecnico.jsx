import { useEffect, useState } from 'react'
import CrudTemplate from '../components/CrudTemplate'
import CreateDialog from '../components/dialogs/CreateDialog'
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import Api from '../services/Api'

export default function Tecnico() {

  const title = "Técnico",
    { CrudContext } = useCrudData()

  const [, setDialogData] = CrudContext.dialogs.data,
    [, setDialogInputs] = CrudContext.inputs,
    [endpoints, setEndpoints] = CrudContext.query.endpoints,
    [rows, setRows] = CrudContext.crudStructure.rows

  let rowsTemplate = [
    { id: 1, apellido: 'García', nombre: 'Ana' },
    { id: 2, apellido: 'López', nombre: 'Juan' },
    { id: 3, apellido: 'Martínez', nombre: 'María' },
    { id: 4, apellido: 'Pérez', nombre: 'Luis' },
    { id: 5, apellido: 'Rodríguez', nombre: 'Elena' },
    { id: 6, apellido: 'Fernández', nombre: 'Javier' },
    { id: 7, apellido: 'González', nombre: 'Laura' },
    { id: 8, apellido: 'Sánchez', nombre: 'Miguel' },
    { id: 9, apellido: 'Ramírez', nombre: 'Isabel' }
  ];


  useEffect(() => {
    setEndpoints({
      fetch:'/tecnico',
      create: '/tecnico',
      edit: '/tecnico',
      delete: '/tecnico'
    })
    setDialogData({
      title: 'tecnico'
    })
    setDialogInputs([
      {
        name: 'nombre',
        label: 'Nombre',
        type: 'text'
      },
      {
        name: 'apellido',
        label: 'Apellido',
        type: 'text'
      },
    ])
    setRows(rowsTemplate)
    // getRegisters()
  }, [])

  const columns = [
    { field: 'id', headerName: 'ID', flex: 1 },
    { field: 'nombre', headerName: 'Nombre', flex: 1 },
    { field: 'apellido', headerName: 'Apellido', flex: 1 },
  ];

  const getRegisters = async () => {
    await Api.getQuery(endpoints.fetch)
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

