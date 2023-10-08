import { useEffect, useState } from 'react'
import CrudTemplate from '../components/CrudTemplate'
import CreateDialog from '../components/dialogs/CreateDialog'
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import Api from '../services/Api'
import dayjs from 'dayjs';

export default function Cliente() {

    const title = "Visita",
        { CrudContext } = useCrudData()

    const [, setDialogData] = CrudContext.dialogs.data,
        [, setDialogInputs] = CrudContext.inputs,
        [endpoints, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows,
        [columns, setColumns] = CrudContext.crudStructure.columns

    let rowsTemplate = [
        {
            id: 1,
            cliente: { id: 101, descripcion: 'Cliente 1' },
            fechaVisita: dayjs('2023-01-10')
        },
        {
            id: 2,
            cliente: { id: 102, descripcion: 'Cliente 2' },
            fechaVisita: dayjs('2023-01-6')
        },
        {
            id: 3,
            cliente: { id: 103, descripcion: 'Cliente 3' },
            fechaVisita: dayjs('2023-01-10')
        },
        {
            id: 4,
            cliente: { id: 104, descripcion: 'Cliente 4' },
            fechaVisita: dayjs('2023-02-20')
        },
        {
            id: 5,
            cliente: { id: 105, descripcion: 'Cliente 5' },
            fechaVisita: dayjs('2023-03-15')
        }
    ];

    const columnsTemplate = [
        { field: 'id', headerName: 'ID', flex: 1 },
        {
            field: 'cliente.descripcion',
            headerName: 'Cliente',
            flex: 1,
            valueGetter: (params) => params.row.cliente?.descripcion
        },
        { field: 'fechaVisita', headerName: 'Fecha de visita', flex: 1 },
    ];

    useEffect(() => {
        setEndpoints({
            fetch: '/visitas',
            create: '/visitas',
            edit: '/visitas',
            delete: '/visitas'
        })
        setDialogData({
            title: 'visita'
        })
        setDialogInputs([
            {
                name: 'cliente',
                label: 'Cliente',
                type: 'select',
                validations: {
                    length: 20,
                    type: "select"
                }
            },
            {
                name: 'fechaVisita',
                label: 'Fecha de visita',
                type: 'date',
                validations: {
                    length: 20,
                    type: "date"
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
