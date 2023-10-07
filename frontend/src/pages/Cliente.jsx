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
        [endpoints, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows

    let rowsTemplate = [
        { id: 1, apellido: 'Snow', nombre: 'Jon', telefono: '555-1234' },
        { id: 2, apellido: 'Lannister', nombre: 'Cersei', telefono: '555-5678' },
        { id: 3, apellido: 'Lannister', nombre: 'Jaime', telefono: '555-9876' },
        { id: 4, apellido: 'Stark', nombre: 'Arya', telefono: '555-4321' },
        { id: 5, apellido: 'Targaryen', nombre: 'Daenerys', telefono: '555-8765' },
        { id: 6, apellido: 'Melisandre', nombre: null, telefono: '555-2468' },
        { id: 7, apellido: 'Clifford', nombre: 'Ferrara', telefono: '555-1357' },
        { id: 8, apellido: 'Frances', nombre: 'Rossini', telefono: '555-8642' },
        { id: 9, apellido: 'Roxie', nombre: 'Harvey', telefono: '555-3690' }
    ];
    useEffect(() => {
        setEndpoints({
            fetch:'/cliente',
            create: '/cliente',
            edit: '/cliente',
            delete: '/cliente'
        })
        setDialogData({
            title: 'cliente'
        })
        setDialogInputs([
            {
                name: 'nombre',
                label: 'Nombre',
                type: 'text',
                validations:{
                    length:10
                }
            },
            {
                name: 'apellido',
                label: 'Apellido',
                type: 'text',
                validations:{
                    length:10
                }
            },
            {
                name: 'telefono',
                label: 'Telefono',
                type: 'text',
                validations:{
                    length:10
                }
            },
        ])
        setRows(rowsTemplate)
        // getRegisters()
    }, [])

    const columns = [
        { field: 'id', headerName: 'ID', flex: 1 },
        { field: 'nombre', headerName: 'Nombre', flex: 1 },
        { field: 'apellido', headerName: 'Apellido', flex: 1 },
        { field: 'telefono', headerName: 'Telefono', flex: 1 },
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
