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
    [rows, setRows] = CrudContext.crudStructure.rows,
    [columns, setColumns] = CrudContext.crudStructure.columns

  let rowsTemplate = [
    { id: 1, apellido: 'García', nombre: 'Ana', documento: '12345678-A', telefono: '555-1234', direccion: 'Calle 123, Ciudad' },
    { id: 2, apellido: 'López', nombre: 'Juan', documento: '23456789-B', telefono: '555-5678', direccion: 'Avenida 456, Pueblo' },
    { id: 3, apellido: 'Martínez', nombre: 'María', documento: '34567890-C', telefono: '555-9876', direccion: 'Calle Principal, Villa' },
    { id: 4, apellido: 'Pérez', nombre: 'Luis', documento: '45678901-D', telefono: '555-4321', direccion: 'Calle Secundaria, Ciudad' },
    { id: 5, apellido: 'Rodríguez', nombre: 'Elena', documento: '56789012-E', telefono: '555-8765', direccion: 'Avenida Norte, Pueblo' },
    { id: 6, apellido: 'Fernández', nombre: 'Javier', documento: '67890123-F', telefono: '555-2468', direccion: 'Calle Este, Villa' },
    { id: 7, apellido: 'González', nombre: 'Laura', documento: '78901234-G', telefono: '555-1357', direccion: 'Calle Oeste, Ciudad' },
    { id: 8, apellido: 'Sánchez', nombre: 'Miguel', documento: '89012345-H', telefono: '555-8642', direccion: 'Avenida Sur, Pueblo' },
    { id: 9, apellido: 'Ramírez', nombre: 'Isabel', documento: '90123456-I', telefono: '555-3690', direccion: 'Calle Residencial, Villa' }
  ];

  const columnsTemplate = [
    { field: 'id', headerName: 'ID', flex: 1 },
    { field: 'nombre', headerName: 'Nombre', flex: 1 },
    { field: 'apellido', headerName: 'Apellido', flex: 1 },
    { field: 'documento', headerName: 'Documento', flex: 1 },
    { field: 'telefono', headerName: 'Telefono', flex: 1 },
    { field: 'direccion', headerName: 'Direccion', flex: 1 },
  ];

  useEffect(() => {
    setEndpoints({
      fetch: '/tecnico',
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
      {
        name: 'documento',
        label: 'Documento',
        type: 'text'
      },
      {
        name: 'telefono',
        label: 'Telefono',
        type: 'text'
      },
      {
        name: 'direccion',
        label: 'Direccion',
        type: 'text'
      },
    ])
    setRows(rowsTemplate)
    setColumns(columnsTemplate)
    // getRegisters()
  }, [])

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

