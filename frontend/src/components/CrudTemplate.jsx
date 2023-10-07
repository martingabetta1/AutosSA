import { useState, useEffect } from 'react'
import { DataGrid } from '@mui/x-data-grid';
import { useCrudData } from '../contexts/CrudContext/CrudContext';
import Button from '@mui/material/Button';
import EditDialog from './dialogs/EditDialog';
import DeleteDialog from './dialogs/DeleteDialog'

export default function CrudTemplate(props) {
    // Columnas

    const { CrudContext } = useCrudData(),
        handleOpenDialog = CrudContext.dialogs.handleOpenDialog,
        [openEditDialog] = CrudContext.dialogs.edit,
        [openDeleteDialog] = CrudContext.dialogs.delete

    const actionsColumn = {
        field: 'acc',
        headerName: 'Acciones',
        description: 'Acciones',
        sortable: false,
        flex: 1,
        align: 'center',
        headerAlign: 'center',
        renderCell: (params) => (
            <div className='crud_accions_box'>
                <div>
                    <Button variant="contained" className='crud_button_edit' onClick={() => { handleOpenDialog("edit",true,params.row) }}>
                        <img className='crud_button_image' button-type="edit" alt="Edit icon" src="/images/crud/icon-edit.png" />
                    </Button>
                </div>
                <div>
                    <Button variant="contained" className='crud_button_delete' onClick={() => { handleOpenDialog("delete",true,params.row) }}>
                        <img className='crud_button_image' button-type="delete" alt="Delete icon" src="/images/crud/icon-delete.png" />
                    </Button>
                </div>
            </div>
        )
    };
    const [tableColumns, setTableColumns] = useState([...props.columns, actionsColumn])

    return (
        <div className='crud-template-container'>
            <div>
                <div>
                    <DataGrid
                        rows={props.rows}
                        columns={tableColumns}
                        disableRowSelectionOnClick={true}
                        initialState={{
                            pagination: {
                                paginationModel: { page: 0, pageSize: 5 },
                            },
                        }}
                        pageSizeOptions={[5, 10]}
                        checkboxSelection
                    />
                    {openEditDialog && (
                        <EditDialog />
                    )}
                    {openDeleteDialog && (
                        <DeleteDialog />
                    )}
                </div>
            </div>
        </div>
    )
}
