import { useEffect, useState } from 'react'
import CrudTemplate from '../../components/CrudTemplate'
import CreateDialog from '../../components/dialogs/CreateDialog'
import { useCrudData } from '../../contexts/CrudContext/CrudContext';
import Api from '../../services/Api'

export default function Servicio() {
    const title = "Servicio",
        { CrudContext } = useCrudData()

    const [isLoading, setIsLoading] = useState(true)

    const [, setDialogData] = CrudContext.dialogs.data,
        [, setDialogInputs] = CrudContext.inputs,
        [endpoints, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows,
        [columns, setColumns] = CrudContext.crudStructure.columns

    const columnsTemplate = [
        { field: 'id', headerName: 'ID', flex: 1 },
        { field: 'tipoServicio', headerName: 'Tipo de servicio', flex: 1 },
        { field: 'precio', headerName: 'Precio', flex: 1 },
        {
            field: 'ordenTrabajo_descripcion',
            headerName: 'Orden',
            flex: 1,
            valueGetter: (params) => params.row.ordenTrabajo?.descripcion
        },
        {
            field: 'ordenTrabajo_id',
            headerName: 'Orden',
            flex: 1,
            valueGetter: (params) => params.row.ordenTrabajo?.id
        },
    ];


    useEffect(() => {
        setEndpoints({
            create: '/servicios',
            edit: '/servicios',
            delete: '/servicios'
        })
        setDialogData({
            title: 'servicio'
        })
        setDialogInputs([
            {
                name: 'tipoServicio',
                label: 'Tipo de servicio',
                type: 'text',
                validations: {
                    length: 30,
                    type: 'text'
                }
            },
            {
                name: 'precio',
                label: 'Precio',
                type: 'number',
                validations: {
                    length: 30,
                    type: 'text'
                }
            },
            {
                name: 'ordenTrabajo',
                label: 'Orden',
                type: 'select',
                endpoint: '/ordenes',
            },
        ])
        setColumns(columnsTemplate)
        getRegisters()
        setIsLoading(false)
    }, [])



    const getRegisters = async () => {
        await Api.getQuery('/servicios')
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
            {!isLoading && (
                <CrudTemplate
                    rows={rows}
                    columns={columns}
                />
            )}
        </div>
    )
}
