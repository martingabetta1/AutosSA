import { useEffect, useState } from 'react'
import CrudTemplate from '../components/CrudTemplate'
import CreateDialog from '../components/dialogs/CreateDialog'
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import Api from '../services/Api'

export default function Modelo() {

  const title = "Modelo",
    { CrudContext } = useCrudData()

  const [, setDialogData] = CrudContext.dialogs.data,
    [, setDialogInputs] = CrudContext.inputs,
    [endpoints, setEndpoints] = CrudContext.query.endpoints,
    [rows, setRows] = CrudContext.crudStructure.rows,
    [columns, setColumns] = CrudContext.crudStructure.columns

  let rowsTemplate = [
    { id: 1, marca: { id: 101, descripcion: 'Marca1' }, nombre: '206' },
    { id: 2, marca: { id: 102, descripcion: 'Marca2' }, nombre: 'prisma' },
    { id: 3, marca: { id: 103, descripcion: 'Marca3' }, nombre: 'onix' },
    { id: 4, marca: { id: 104, descripcion: 'Marca4' }, nombre: 'golf' },
    { id: 5, marca: { id: 105, descripcion: 'Marca5' }, nombre: 'gol' },
    { id: 6, marca: { id: 106, descripcion: 'Marca6' }, nombre: 'sedan' },
    { id: 7, marca: { id: 107, descripcion: 'Marca7' }, nombre: 'tt' },
    { id: 8, marca: { id: 108, descripcion: 'Marca8' }, nombre: 'veneno' },
    { id: 9, marca: { id: 109, descripcion: 'Marca9' }, nombre: 'f100' }
  ];

  const columnsTemplate = [
    { field: 'id', headerName: 'ID', flex: 1 },
    { field: 'nombre', headerName: 'Nombre', flex: 1 },
    {
      field: 'marca.descripcion',
      headerName: 'Marca',
      flex: 1,
      valueGetter: (params) => params.row.marca?.descripcion
    },
  ];

  useEffect(() => {
    setEndpoints({
      fetch: '/modelos',
      create: '/modelos',
      edit: '/modelos',
      delete: '/modelos'
    })
    setDialogData({
      title: 'modelo'
    })
    setDialogInputs([
      {
        name: 'nombre',
        label: 'Nombre',
        type: 'text',
        validations:{
          length:20,
          type:'text'
        }
      },
      {
        name: 'marca',
        label: 'Marca',
        type: 'select',
        endpoint: '/marca'
      },
      {
        name: 'date',
        label: 'Date',
        type: 'date',
      },
    ])
    setRows(rowsTemplate)
    setColumns(columnsTemplate)
    // getRegisters()
  }, [])


  const getRegisters = async () => {
    await Api.getQuery('/modelos')
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
