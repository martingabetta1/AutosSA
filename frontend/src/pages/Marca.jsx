import { useEffect, useState } from 'react'
import CrudTemplate from '../components/CrudTemplate'
import CreateDialog from '../components/dialogs/CreateDialog'
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import Api from '../services/Api'

export default function Marca() {

    const [isLoading, setIsLoading] = useState(true)

    const title = "Marca",
        { CrudContext } = useCrudData()

    const [, setDialogData] = CrudContext.dialogs.data,
        [, setDialogInputs] = CrudContext.inputs,
        [endpoints, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows,
        [columns, setColumns] = CrudContext.crudStructure.columns,
        [filtersQuery,setFiltersQuery] = CrudContext.filters.filtersQuery

    const columnsTemplate = [
        { field: 'id', headerName: 'ID', flex: 1 },
        { field: 'nombre', headerName: 'Nombre', flex: 1 },
        {
            field: 'impuesto.descripcion',
            headerName: 'Impuesto',
            flex: 1,
            valueGetter: (params) => params.row.impuesto?.descripcion
        },
    ];

    useEffect(() => {
        setEndpoints({
            fetch:'/marcas',
            create: '/marcas',
            edit: '/marcas',
            delete: '/marcas'
        })
        setDialogData({
            title: 'marca'
        })
        setDialogInputs([
            {
                name: 'nombre',
                label: 'Nombre',
                type: 'text',
                validations: {
                    length: 20,
                    type: 'text'
                }
            },
            {
                name: 'impuesto',
                label: 'Impuesto',
                type: 'select',
                endpoint: '/impuestos',
            },
        ])
        // setRows(rowsTemplate)
        setColumns(columnsTemplate)
        getRegisters()
    }, [])



    const getRegisters = async () => {
        await Api.getQuery('/marcas',null,filtersQuery)
            .then((res) => {
                setRows(res)
                setIsLoading(false)
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
            {!isLoading && (
                <CrudTemplate
                    rows={rows}
                    columns={columns}
                />
            )}

        </div>
    )
}
