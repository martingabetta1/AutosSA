import { useEffect, useState } from 'react'
import CrudTemplate from '../../components/CrudTemplate'
import CreateDialog from '../../components/dialogs/CreateDialog'
import { useCrudData } from '../../contexts/CrudContext/CrudContext';
import Api from '../../services/Api'
import dayjs from 'dayjs';

export default function Marca() {

    const title = "Orden de trabajo",
        { CrudContext } = useCrudData()

    const [, setDialogData] = CrudContext.dialogs.data,
        [, setDialogInputs] = CrudContext.inputs,
        [endpoints, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows,
        [columns, setColumns] = CrudContext.crudStructure.columns

    let rowsTemplate = [
        {
            id: 1,
            nroOrden: 1,
            fechaInicio: dayjs('2023-01-10'),
            fechaFin: dayjs('2023-01-15'),
            vehiculo: {id:1,descripcion:"Onix"},
            tecnico: {id:1,descripcion:"Pedro"},
            estado: {id:1,descripcion:"En espera"},
            comentario: 'El vehículo necesita un cambio de aceite urgente.',
            cliente: {id:1,descripcion:"Menganito"}
        },
        {
            id: 2,
            nroOrden: 2,
            fechaInicio: dayjs('2023-02-05'),
            fechaFin: dayjs('2023-02-10'),
            vehiculo: {id:2,descripcion:"Ford"},
            tecnico: {id:2,descripcion:"Juan"},
            estado: {id:2,descripcion:"En curso"},
            comentario: 'El vehículo está en buenas condiciones.',
            cliente: {id:2,descripcion:"Fulanito"}
        },

    ];

    const columnsTemplate = [
        { field: 'id', headerName: 'ID', flex: 1 },
        { field: 'fechaInicio', headerName: 'Fecha inicio', flex: 1 },
        { field: 'fechaFin', headerName: 'Fecha fin', flex: 1 },
        {
            field: 'vehiculo.descripcion',
            headerName: 'Vehiculo',
            flex: 1,
            valueGetter: (params) => params.row.vehiculo?.descripcion
        },
        {
            field: 'tecnico.descripcion',
            headerName: 'Tecnico',
            flex: 1,
            valueGetter: (params) => params.row.tecnico?.descripcion
        },
        {
            field: 'estado.descripcion',
            headerName: 'Estado',
            flex: 1,
            valueGetter: (params) => params.row.estado?.descripcion
        },
        { field: 'comentario', headerName: 'Comentario', flex: 1 },
        {
            field: 'cliente.descripcion',
            headerName: 'Cliente',
            flex: 1,
            valueGetter: (params) => params.row.cliente?.descripcion
        },
    ];
    useEffect(() => {
        setEndpoints({
            create: '/orden',
            edit: '/orden',
            delete: '/orden'
        })
        setDialogData({
            title: 'orden'
        })
        setDialogInputs([
            {
                name: 'fechaInicio',
                label: 'Fecha de inicio',
                type: 'date'
            },
            {
                name: 'fechaFin',
                label: 'Fecha de fin',
                type: 'date'
            },
            {
                name: 'vehiculo',
                label: 'Vehiculo',
                type: 'select'
            },
            {
                name: 'tecnico',
                label: 'Tecnico',
                type: 'select'
            },
            {
                name: 'estado',
                label: 'Estado',
                type: 'select'
            },
            {
                name: 'comentario',
                label: 'Comentario',
                type: 'text',
                multiline: true
            },
            {
                name: 'cliente',
                label: 'Cliente',
                type: 'select'
            },
        ])
        setRows(rowsTemplate)
        setColumns(columnsTemplate)
        // getRegisters()
    }, [])

   

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
