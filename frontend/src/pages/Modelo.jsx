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
    [columns, setColumns] = CrudContext.crudStructure.columns,
    [filtersQuery, setFiltersQuery] = CrudContext.filters.filtersQuery

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
        validations: {
          length: 20,
          type: 'text'
        }
      },
      {
        name: 'marca',
        label: 'Marca',
        type: 'select',
        endpoint: '/marcas'
      },
    ])
    // setRows(rowsTemplate)
    setColumns(columnsTemplate)
    getRegisters()
  }, [])


  const getRegisters = async () => {
    await Api.getQuery('/modelos', null, filtersQuery)
      .then((res) => {
        setRows(res)
      }).catch((error) => {
        throw new Error(error.message)
      })
  }

  useEffect(() => {
    getRegisters()
  }, [filtersQuery])

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
