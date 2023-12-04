import { useEffect, useState } from 'react'
import CrudTemplate from '../components/CrudTemplate'
import CreateDialog from '../components/dialogs/CreateDialog'
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import Api from '../services/Api'

export default function Cliente() {

    const title = "Cliente",
        { CrudContext } = useCrudData()

    const [, setDialogData] = CrudContext.dialogs.data,
        [, setDialogInputs] = CrudContext.inputs,
        [,setEndpoints] = CrudContext.query.endpoints,
        [,setArgs] = CrudContext.query.args,
        [rows, setRows] = CrudContext.crudStructure.rows,
        [columns, setColumns] = CrudContext.crudStructure.columns,
        [filtersQuery,setFiltersQuery] = CrudContext.filters.filtersQuery

    const columnsTemplate = [
        { field: 'id', headerName: 'ID', flex: 1 },
        { field: 'nombre', headerName: 'Nombre', flex: 1 },
        { field: 'apellido', headerName: 'Apellido', flex: 1 },
        { field: 'telefono', headerName: 'Telefono', flex: 1 },
        { field: 'localidad', headerName: 'Localidad', flex: 1 },
        { field: 'direccion', headerName: 'Direccion', flex: 1 },
        { field: 'mail', headerName: 'Mail', flex: 1 },
    ];

    useEffect(() => {
        setEndpoints({
            fetch: '/clientes',
            create: '/clientes',
            edit: '/clientes',
            delete: '/clientes',
            download:'/clientes'
        })
        setArgs({
            multipart:true
        })
        setDialogData({
            title: 'cliente'
        })
        setDialogInputs([
            {
                name: 'nombre',
                label: 'Nombre',
                type: 'text',
                validations: {
                    length: 10,
                    type: "text"
                }
            },
            {
                name: 'apellido',
                label: 'Apellido',
                type: 'text',
                validations: {
                    length: 10,
                    type: "text"
                }
            },
            {
                name: 'telefono',
                label: 'Telefono',
                type: 'text',
                validations: {
                    length: 15,
                    type: "number"
                }
            },
            {
                name: 'localidad',
                label: 'Localidad',
                type: 'text',
                validations: {
                    length: 50,
                    type: "text"
                }
            },
            {
                name: 'direccion',
                label: 'Direccion',
                type: 'text',
                validations: {
                    length: 20,
                    type: "text"
                }
            },
            {
                name: 'mail',
                label: 'Mail',
                type: 'text',
                validations: {
                    length: 30,
                    type: "email"
                }
            },
            {
                name: 'frenteLicencia',
                label: 'Frente de licencia',
                type: 'file',
            },
            {
                name: 'dorsoLicencia',
                label: 'Dorso de licencia',
                type: 'file',
            },
        ])
        getRegisters()
        setColumns(columnsTemplate)
    }, [])

    const getRegisters = async () => {
        await Api.getQuery('/clientes',null,filtersQuery)
            .then((res) => {
                setRows(res)
            }).catch((error) => {
                throw new Error(error.message)
            })
    }

    useEffect(()=>{
        getRegisters()
    },[filtersQuery])

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
