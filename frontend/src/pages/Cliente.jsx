import { useEffect, useState } from 'react'
import CrudTemplate from '../components/CrudTemplate'
import CreateDialog from '../components/dialogs/CreateDialog'
import { useCrudData } from '../contexts/CrudContext';
import Api from '../services/Api'

export default function Cliente() {

    const title = "Cliente",
        { CrudContext } = useCrudData()

    const [, setDialogData] = CrudContext.dialogs.data,
        [, setDialogInputs] = CrudContext.inputs,
        [endpoints, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows

    let rowsTemplate = [
        { id: 1, apellido: 'Snow', nombre: 'Jon' },
        { id: 2, apellido: 'Lannister', nombre: 'Cersei' },
        { id: 3, apellido: 'Lannister', nombre: 'Jaime' },
        { id: 4, apellido: 'Stark', nombre: 'Arya' },
        { id: 5, apellido: 'Targaryen', nombre: 'Daenerys' },
        { id: 6, apellido: 'Melisandre', nombre: null },
        { id: 7, apellido: 'Clifford', nombre: 'Ferrara' },
        { id: 8, apellido: 'Frances', nombre: 'Rossini' },
        { id: 9, apellido: 'Roxie', nombre: 'Harvey' }
    ];
    useEffect(() => {
        setEndpoints({
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
        await Api.getQuery(endpoints.create)
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
