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
        [rows, setRows] = CrudContext.crudStructure.rows,
        [columns, setColumns] = CrudContext.crudStructure.columns

    let rowsTemplate = [
        { id: 1, apellido: "Snow", nombre: "Jon", telefono: "555-1234", direccion: "Winterfell, North", email: "jon.snow@example.com", localidad: "Winterfell" },
        { id: 2, apellido: "Lannister", nombre: "Cersei", telefono: "555-5678", direccion: "King's Landing, Westeros", email: "cersei.lannister@example.com", localidad: "King's Landing" },
        { id: 3, apellido: "Lannister", nombre: "Jaime", telefono: "555-9876", direccion: "Casterly Rock, Westeros", email: "jaime.lannister@example.com", localidad: "Casterly Rock" },
        { id: 4, apellido: "Stark", nombre: "Arya", telefono: "555-4321", direccion: "Winterfell, North", email: "arya.stark@example.com", localidad: "Winterfell" },
        { id: 5, apellido: "Targaryen", nombre: "Daenerys", telefono: "555-8765", direccion: "Dragonstone, Westeros", email: "daenerys.targaryen@example.com", localidad: "Dragonstone" },
        { id: 6, apellido: "Melisandre", nombre: null, telefono: "555-2468", direccion: "Shadowlands", email: "melisandre@example.com", localidad: "Shadowlands" },
        { id: 7, apellido: "Clifford", nombre: "Ferrara", telefono: "555-1357", direccion: "Riverrun, Westeros", email: "ferrara.clifford@example.com", localidad: "Riverrun" },
        { id: 8, apellido: "Frances", nombre: "Rossini", telefono: "555-8642", direccion: "Milan, Italy", email: "rossini@example.com", localidad: "Milan" },
        { id: 9, apellido: "Roxie", nombre: "Harvey", telefono: "555-3690", direccion: "Chicago, USA", email: "harvey.roxie@example.com", localidad: "Chicago" }
    ];

    const columnsTemplate = [
        { field: 'id', headerName: 'ID', flex: 1 },
        { field: 'nombre', headerName: 'Nombre', flex: 1 },
        { field: 'apellido', headerName: 'Apellido', flex: 1 },
        { field: 'telefono', headerName: 'Telefono', flex: 1 },
        { field: 'localidad', headerName: 'Localidad', flex: 1 },
        { field: 'direccion', headerName: 'Direccion', flex: 1 },
        { field: 'email', headerName: 'Email', flex: 1 },
    ];

    useEffect(() => {
        setEndpoints({
            fetch: '/cliente',
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
                    length: 10,
                    type: "number"
                }
            },
            {
                name: 'localidad',
                label: 'Localidad',
                type: 'text',
                validations: {
                    length: 10,
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
                name: 'email',
                label: 'Email',
                type: 'text',
                validations: {
                    length: 30,
                    type: "email"
                }
            },
        ])
        setRows(rowsTemplate)
        setColumns(columnsTemplate)
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
