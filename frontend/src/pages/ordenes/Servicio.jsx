import { useEffect, useState } from 'react'
import CrudTemplate from '../../components/CrudTemplate'
import CreateDialog from '../../components/dialogs/CreateDialog'
import { useCrudData } from '../../contexts/CrudContext/CrudContext';
import Api from '../../services/Api'

export default function Servicio(){
    const title = "Servicio",
        { CrudContext } = useCrudData()

    const [, setDialogData] = CrudContext.dialogs.data,
        [, setDialogInputs] = CrudContext.inputs,
        [endpoints, setEndpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows,
        [columns, setColumns] = CrudContext.crudStructure.columns

    const columnsTemplate = [
        { field: 'id', headerName: 'ID', flex: 1 },
        { field: 'nombre', headerName: 'Nombre', flex: 1 },
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
                name: 'nombre',
                label: 'Nombre',
                type: 'text',
                validations:{
                    length:30,
                    type:'text'
                }
            },
        ])
        setColumns(columnsTemplate)
        getRegisters()
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
            <CrudTemplate
                rows={rows}
                columns={columns}
            />
        </div>
    )
}
