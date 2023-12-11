import { useState, useEffect } from 'react'
import { DataGrid } from '@mui/x-data-grid';
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import { useError } from '../contexts/Error';
import OptionsPopover from './utils/OptionsPopover';
import Button from '@mui/material/Button';
import EditDialog from './dialogs/EditDialog';
import DeleteDialog from './dialogs/DeleteDialog'
import ListDialog from './dialogs/ListDialog'
import Api from '../services/Api';
import Filters from './Filters'

export default function CrudTemplate(props) {
    // Columnas

    const { CrudContext } = useCrudData(),
        { ErrorContext } = useError(),
        handleOpenDialog = CrudContext.dialogs.handleOpenDialog,
        [openEditDialog] = CrudContext.dialogs.edit,
        [openDeleteDialog] = CrudContext.dialogs.delete,
        [openListDialog] = CrudContext.dialogs.list,
        [endpoints] = CrudContext.query.endpoints,
        [rows, setRows] = CrudContext.crudStructure.rows,
        [filtersQuery, setFiltersQuery] = CrudContext.filters.filtersQuery


    const actionsColumn = {
        field: 'acc',
        headerName: 'Acciones',
        description: 'Acciones',
        sortable: false,
        flex: 1,
        align: 'center',
        headerAlign: 'center',
        renderCell: (params) => (
            <>
                {props.optionsPopover && (
                    <OptionsPopover
                        params={params}
                        handleListServices={handleListServices}
                        endpoints = {endpoints}
                        errorGenerator = {ErrorContext}
                    />
                )}
                {!props.optionsPopover && (
                    <div className='crud_accions_box'>
                        <div>
                            <Button disabled={params.row.estado?.descripcion === "Finalizado"} variant="contained" className={`crud_button_edit ${params.row.estado?.descripcion === "Finalizado" ? "disabled" : ""}`} onClick={() => { handleOpenDialog("edit", true, params.row) }}>
                                <img className='crud_button_image' button-type="edit" alt="Edit icon" src="/images/crud/icon-edit.png" />
                            </Button>
                        </div>
                        <div>
                            <Button variant="contained" className='crud_button_delete' onClick={() => { handleOpenDialog("delete", true, params.row) }}>
                                <img className='crud_button_image' button-type="delete" alt="Delete icon" src="/images/crud/icon-delete.png" />
                            </Button>
                        </div>
                        {endpoints.download && (
                            <div>
                                <Button variant="contained" className='crud_button_download' onClick={() => { Api.downloadQuery(endpoints.dowload, params.row.id) }}>
                                    <img className='crud_button_image' button-type="download" alt="Download icon" src="/images/crud/icon-download.png" />
                                </Button>
                            </div>
                        )}
                        {endpoints.listServices && (
                            <div>
                                <Button variant="contained" className='crud_button_listServices' onClick={() => { handleListServices(params.row.id) }}>
                                    <img className='crud_button_image' button-type="listServices" alt="List Services icon" src="/images/crud/icon-services.png" />
                                </Button>
                            </div>
                        )}
                        {endpoints.factura && (
                            <div>
                                <Button variant="contained" className='crud_button_factura' onClick={() => { }}>
                                    <img className='crud_button_image' button-type="factura" alt="Factura icon" src="/images/crud/icon-factura.png" />
                                </Button>
                            </div>
                        )}
                    </div>
                )}
            </>
        )
    };
    const [tableColumns, setTableColumns] = useState([...props.columns, actionsColumn])

    useEffect(() => {
        setTableColumns([...props.columns, actionsColumn])
    }, [props.columns])

    const handleListServices = (idOrden) => {
        Api.listServicesQuery(endpoints.listServices, { idOrden })
            .then((response) => {
                handleOpenDialog("list", true, response.data)
            })
            .catch((error) => {
                ErrorContext.setError(
                    {
                        state: true, message: `Error al intentar listar los registros\n
                ${error.message}`
                    }
                )
            })
    }

    return (
        <div className='crud-template-container'>
            <div>
                <div>
                    <Filters />
                    <DataGrid
                        rows={props.rows}
                        columns={tableColumns}
                        disableRowSelectionOnClick={true}
                        initialState={{
                            pagination: {
                                paginationModel: { page: 0, pageSize: 100 },
                            },
                        }}
                        pageSizeOptions={[100]}
                        checkboxSelection
                    />
                    {openEditDialog && (
                        <EditDialog />
                    )}
                    {openDeleteDialog && (
                        <DeleteDialog />
                    )}
                    {openListDialog && (
                        <ListDialog />
                    )}
                </div>
            </div>
        </div>
    )

}
