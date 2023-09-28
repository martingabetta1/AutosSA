import { useState, useEffect } from 'react'
import { DataGrid } from '@mui/x-data-grid';
import Button from '@mui/material/Button';

export default function CrudTemplate(props) {
    const [tableColumns, setTableColumns] = useState(props.columns)
    const [actionsColumn, setActionColumn] = useState({
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
                <Button variant="contained" className='crud_button_edit' onClick={()=>{handleOpenDialog("edit")}}>
                    <img className='crud_button_image' button-type="edit" alt="Edit icon" src="/images/crud/icon-edit.png"/>
                </Button>
                </div>
                <div>
                <Button variant="contained" className='crud_button_delete' onClick={()=>{handleOpenDialog("delete")}}>
                    <img className='crud_button_image' button-type="delete" alt="Delete icon" src="/images/crud/icon-delete.png" />
                </Button>
                </div>
            </div>
        )
    });

    const [openEditDialog, setOpenEditDialog] = useState(false),
        [openDeleteDialog, setOpenDeleteDialog] = useState(false)
   
    useEffect(() => {
        constructColumns(props.columns)
    }, [])

    const constructColumns = (tableColumns)=>{
        setTableColumns(tableColumns)
        setTableColumns((previousList) => [
            ...previousList,
            actionsColumn
        ]);
    }

    const handleOpenDialog = (type)=>{
        switch(type){
            case "edit":
                setOpenEditDialog(true)
                break
            case "delete":
                setOpenDeleteDialog(true)
                break
            default:
                break
        }
    }

    return (
        <div className='crud-template-container'>
            <h1 className="crud-title">{props.title}</h1>
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
                </div>
            </div>
        </div>
    )
}
