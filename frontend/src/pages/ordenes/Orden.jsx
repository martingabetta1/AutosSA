import { useEffect, useState } from 'react'
import CrudTemplate from '../../components/CrudTemplate'
import CreateDialog from '../../components/dialogs/CreateDialog'
import { useCrudData } from '../../contexts/CrudContext/CrudContext';
import Api from '../../services/Api'

export default function Marca() {

    const title = "Orden de trabajo",
        { CrudContext } = useCrudData()

    const [, setDialogData] = CrudContext.dialogs.data,
        [, setDialogInputs] = CrudContext.inputs,
        [endpoints, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows

    let rowsTemplate = [
        {
            id:1,
            nroOrden: 1,
            fechaInicio: new Date('2023-01-10'),
            fechaFin: new Date('2023-01-15'),
            vehiculo: 1,
            tecnico: 1,
            estado: 1,
            comentario: 'El vehículo necesita un cambio de aceite urgente.',
            cliente: 1
        },
        {
            id:2,
            nroOrden: 2,
            fechaInicio: new Date('2023-02-05'),
            fechaFin: new Date('2023-02-10'),
            vehiculo: 2,
            tecnico: 2,
            estado: 2,
            comentario: 'El vehículo está en buenas condiciones.',
            cliente: 2
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
                type: 'autocomplete'
            },
            {
                name: 'tecnico',
                label: 'Tecnico',
                type: 'autocomplete'
            },
            {
                name: 'estado',
                label: 'Estado',
                type: 'autocomplete'
            },
            {
                name: 'comentario',
                label: 'Comentario',
                type: 'text',
                multiline:true
            },
            {
                name: 'cliente',
                label: 'Cliente',
                type: 'autocomplete'
            },
        ])
        setRows(rowsTemplate)
        // getRegisters()
    }, [])

    const columns = [
        { field: 'id', headerName: 'ID', flex: 1 },
        { field: 'fechaInicio', headerName: 'Fecha inicio', flex: 1 },
        { field: 'fechaFin', headerName: 'Fecha fin', flex: 1 },
        { field: 'vehiculo', headerName: 'Vehiculo', flex: 1 },
        { field: 'tecnico', headerName: 'Tecnico', flex: 1 },
        { field: 'estado', headerName: 'Estado', flex: 1 },
        { field: 'comentario', headerName: 'Comentario', flex: 1 },
        { field: 'cliente', headerName: 'Cliente', flex: 1 },
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
