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
        [, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows,
        [columns, setColumns] = CrudContext.crudStructure.columns

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
                endpoint:'/clientes'
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
        // setRows(rowsTemplate)
        setColumns(columnsTemplate)
        getRegisters()
    }, [])

    const getRegisters = async () => {
        await Api.getQuery('/visitas')
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
