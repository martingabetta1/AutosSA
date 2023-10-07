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
    [rows, setRows] = CrudContext.crudStructure.rows

  let rowsTemplate = [
    { id: 1, marca: 2, nombre: '206' },
    { id: 2, marca: 5, nombre: 'prisma' },
    { id: 3, marca: 7, nombre: 'onix' },
    { id: 4, marca: 3, nombre: 'golf' },
    { id: 5, marca: 9, nombre: 'gol' },
    { id: 6, marca: 4, nombre: 'sedan' },
    { id: 7, marca: 1, nombre: 'tt' },
    { id: 8, marca: 6, nombre: 'veneno' },
    { id: 9, marca: 10, nombre: 'f100' }
  ];
  useEffect(() => {
    setEndpoints({
      fetch:'/modelo',
      create: '/modelo',
      edit: '/modelo',
      delete: '/modelo'
    })
    setDialogData({
      title: 'modelo'
    })
    setDialogInputs([
      {
        name: 'nombre',
        label: 'Nombre',
        type: 'text'
      },
      {
        name: 'marca',
        label: 'Marca',
        type: 'select',
        endpoint: '/marca'
      },
    ])
    setRows(rowsTemplate)
    // getRegisters()
  }, [])

  const columns = [
    { field: 'id', headerName: 'ID', flex: 1 },
    { field: 'nombre', headerName: 'Nombre', flex: 1 },
    { field: 'marca', headerName: 'Marca', flex: 1 },
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
