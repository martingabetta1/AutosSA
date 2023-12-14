import { useEffect, useState } from 'react'
import CrudTemplate from '../../components/CrudTemplate'
import CreateDialog from '../../components/dialogs/CreateDialog'
import { useCrudData } from '../../contexts/CrudContext/CrudContext';
import { useError } from '../../contexts/Error';
import Api from '../../services/Api'
import dayjs from 'dayjs';

export default function Marca() {

    const title = "Orden de trabajo",
        { CrudContext } = useCrudData(),
        { ErrorContext } = useError()

    const [isLoading, setIsLoading] = useState(true)

    const [, setDialogData] = CrudContext.dialogs.data,
        [, setDialogInputs] = CrudContext.inputs,
        [, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows,
        [columns, setColumns] = CrudContext.crudStructure.columns,
        [filtersQuery] = CrudContext.filters.filtersQuery

    const columnsTemplate = [
        { field: 'id', headerName: 'ID', flex: 1 },
        { field: 'fechaInicio', headerName: 'Fecha inicio', flex: 1 ,
        valueGetter: (params) => params.row.fechaInicio.match(/^(\d{4}-\d{2}-\d{2})T\d{2}:\d{2}:\d{2}.\d{3}\+\d{2}:\d{2}$/)[1].split("-").reverse().join("-")},
        { field: 'fechaFin', headerName: 'Fecha fin', flex: 1,
        valueGetter: (params) => params.row.fechaFin.match(/^(\d{4}-\d{2}-\d{2})T\d{2}:\d{2}:\d{2}.\d{3}\+\d{2}:\d{2}$/)[1].split("-").reverse().join("-") },
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
        {
            field: 'cliente.descripcion',
            headerName: 'Cliente',
            flex: 1,
            valueGetter: (params) => params.row.cliente?.descripcion
        },
        { field: 'comentario', headerName: 'Comentario', flex: 1 },
        { field: 'totalCosto', headerName: 'Costo total', flex: 1 }
    ];
    useEffect(() => {
        setEndpoints({
            create: '/ordenes',
            edit: '/ordenes',
            delete: '/ordenes',
            listServices: '/servicios',
            factura: '/servicios'
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
                type: 'select',
                endpoint: '/vehiculos',
            },
            {
                name: 'tecnico',
                label: 'Tecnico',
                type: 'select',
                endpoint: '/tecnicos',
            },
            {
                name: 'estado',
                label: 'Estado',
                type: 'select',
                endpoint: '/estados'
            },
            {
                name: 'comentario',
                label: 'Comentario',
                type: 'multiline',
                validations: {
                    length: 100,
                    type: 'text'
                }
            },
            {
                name: 'cliente',
                label: 'Cliente',
                type: 'select',
                endpoint: '/clientes',
            },
        ])
        // setRows(rowsTemplate)
        setColumns(columnsTemplate)
        getRegisters()
    }, [])

    const getRegisters = async () => {
        await Api.getQuery('/ordenes',null,filtersQuery)
            .then((res) => {
                setRows(res)
                setIsLoading(false)
            }).catch((error) => {
                ErrorContext.setError(
                    {
                        state: true, message: `Error al tratar de traer los registros de ${title}\n
                ${error.message}`
                    }
                )
            })
    }

    useEffect(()=>{
        getRegisters()
    },[filtersQuery])

    const optionsPopover = true

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
                    optionsPopover={optionsPopover}
                />
            )}
        </div>
    )
}
