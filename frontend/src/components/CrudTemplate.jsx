import { useState, useEffect } from 'react'
import { DataGrid } from '@mui/x-data-grid';
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import { useError } from '../contexts/Error';
import OptionsPopover from './utils/OptionsPopover';
import Button from '@mui/material/Button';
import EditDialog from './dialogs/EditDialog';
import DeleteDialog from './dialogs/DeleteDialog'
import ListDialog from './dialogs/ListDialog'
import RestartDialog from './dialogs/RestartDialog'
import Api from '../services/Api';
import Filters from './Filters'

export default function CrudTemplate(props) {
    // Columnas

    const { CrudContext } = useCrudData(),
        { ErrorContext } = useError(),
        handleOpenDialog = CrudContext.dialogs.handleOpenDialog,
        [openEditDialog] = CrudContext.dialogs.edit,
        [openDeleteDialog] = CrudContext.dialogs.delete,
        [openRestartDialog] = CrudContext.dialogs.restart,
        [openListDialog] = CrudContext.dialogs.list,
        [endpoints] = CrudContext.query.endpoints,
        [, setFiltersQuery] = CrudContext.filters.filtersQuery,
        [showDeleteds, setShowDeleteds] = CrudContext.filters.showDeleteds


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
                {!showDeleteds && (
                    <>
                        {props.optionsPopover && (
                            <OptionsPopover
                                params={params}
                                handleListServices={handleListServices}
                                endpoints={endpoints}
                                errorGenerator={ErrorContext}
                            />
                        )}
                        {!props.optionsPopover && (
                            <div className='crud_accions_box'>
                                <div>
                                    <Button disabled={params.row.estado?.descripcion === "Finalizado" || params.row.ordenTrabajo?.estado.nombre === "Finalizado"} variant="contained" className={`crud_button_edit ${params.row.estado?.descripcion === "Finalizado" || params.row.ordenTrabajo?.estado.nombre === "Finalizado" ? "disabled" : ""}`} onClick={() => { handleOpenDialog("edit", true, params.row) }}>
                                        <img className='crud_button_image' button-type="edit" alt="Edit icon" src="/images/crud/icon-edit.png" />
                                    </Button>
                                </div>
                                <div>
                                    <Button
                                        disabled={params.row.estado?.descripcion === "Finalizado" || params.row.ordenTrabajo?.estado.nombre === "Finalizado"}
                                        variant="contained"
                                        className={`crud_button_delete ${params.row.estado?.descripcion === "Finalizado" || params.row.ordenTrabajo?.estado.nombre === "Finalizado" ? "disabled" : ""}`}
                                        onClick={() => { handleOpenDialog("delete", true, params.row) }}
                                    >
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
                )}
                {showDeleteds && (
                    <div className='crud_accions_box'>
                        <div>
                            <Button disabled={params.row.estado?.descripcion === "Finalizado" || params.row.ordenTrabajo?.estado.nombre === "Finalizado"} variant="contained" className={`crud_button_restart ${params.row.estado?.descripcion === "Finalizado" || params.row.ordenTrabajo?.estado.nombre === "Finalizado" ? "disabled" : ""}`} onClick={() => { handleOpenDialog("restart", true, params.row) }}>
                                <img className='crud_button_image' button-type="restart" alt="Restart icon" src="/images/crud/icon-restart.png" />
                            </Button>
                        </div>
                    </div>
                )}
            </>


        )
    };
    const [tableColumns, setTableColumns] = useState([...props.columns, actionsColumn])

    useEffect(() => {
        setTableColumns([...props.columns, actionsColumn])


    }, [props.columns, showDeleteds])

    useEffect(() => {

        return () => {
            setShowDeleteds(false)
            setFiltersQuery("")
        }
    }, [])

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
                        style={showDeleteds ? { color: "red" } : {}}
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
                    {openRestartDialog && (
                        <RestartDialog />
                    )}
                    {openListDialog && (
                        <ListDialog />
                    )}
                </div>
            </div>
        </div>
    )

}
