import { useEffect, useState } from 'react'
import CrudTemplate from '../components/CrudTemplate'
import CreateDialog from '../components/dialogs/CreateDialog'
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import Api from '../services/Api'

export default function Marca() {

    const title = "Marca",
        { CrudContext } = useCrudData()

    const [, setDialogData] = CrudContext.dialogs.data,
        [, setDialogInputs] = CrudContext.inputs,
        [endpoints, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows,
        [columns, setColumns] = CrudContext.crudStructure.columns

    let rowsTemplate = [
        { id: 1, nombre: 'Ford' },
        { id: 2, nombre: 'Fiat' },
        { id: 3, nombre: 'Volkswagen' },
        { id: 4, nombre: 'Yamaha' },
        { id: 5, nombre: 'Zanella' },
        
    ];

    const columnsTemplate = [
        { field: 'id', headerName: 'ID', flex: 1 },
        { field: 'nombre', headerName: 'Nombre', flex: 1 },
    ];

    useEffect(() => {
        setEndpoints({
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
                validations:{
                    length:20,
                    type:'text'
                }
            },
        ])
        // setRows(rowsTemplate)
        setColumns(columnsTemplate)
        getRegisters()
    }, [])



    const getRegisters = async () => {
        await Api.getQuery('/marcas')
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
