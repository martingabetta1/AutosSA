import { useEffect, useState } from 'react'
import CrudTemplate from '../components/CrudTemplate'
import CreateDialog from '../components/dialogs/CreateDialog'
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import Api from '../services/Api'

export default function Tecnico() {

  const title = "Técnico",
    { CrudContext } = useCrudData()

  const [isLoading, setIsLoading] = useState(true)

  const [, setDialogData] = CrudContext.dialogs.data,
    [, setDialogInputs] = CrudContext.inputs,
    [endpoints, setEndpoints] = CrudContext.query.endpoints,
    [rows, setRows] = CrudContext.crudStructure.rows,
    [columns, setColumns] = CrudContext.crudStructure.columns,
    [filtersQuery, setFiltersQuery] = CrudContext.filters.filtersQuery


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
      fetch: '/tecnicos',
      create: '/tecnicos',
      edit: '/tecnicos',
      delete: '/tecnicos'
    })
    setDialogData({
      title: 'tecnico'
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
        name: 'apellido',
        label: 'Apellido',
        type: 'text',
        validations: {
          length: 20,
          type: 'text'
        }
      },
      {
        name: 'documento',
        label: 'Documento',
        type: 'text',
        validations: {
          length: 20,
          type: 'number'
        }
      },
      {
        name: 'telefono',
        label: 'Telefono',
        type: 'text',
        validations: {
          length: 20,
          type: 'number'
        }
      },
      {
        name: 'direccion',
        label: 'Direccion',
        type: 'text',
        validations: {
          length: 20,
          type: 'text'
        }
      },
    ])
    // setRows(rowsTemplate)
    setColumns(columnsTemplate)
    getRegisters()
    setIsLoading(false)
  }, [])

  const getRegisters = async () => {
    await Api.getQuery('/tecnicos', null, filtersQuery)
      .then((res) => {
        setRows(res)
        // hola
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
      {!isLoading && (
        <CrudTemplate
          rows={rows}
          columns={columns}
        />
      )}
    </div>
  )
}

