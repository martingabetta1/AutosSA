import Button from '@mui/material/Button';

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
            <Button variant="contained" className='crud_button_edit' onClick={()=>{}}>
                <img className='crud_button_image' button-type="edit" alt="Edit icon" src="/images/crud/icon-edit.png"/>
            </Button>
            </div>
            <div>
            <Button variant="contained" className='crud_button_delete' onClick={()=>{}}>
                <img className='crud_button_image' button-type="delete" alt="Delete icon" src="/images/crud/icon-delete.png" />
            </Button>
            </div>
        </div>
    )
};

const CrudUtils = {
    actionsColumn
}

export default CrudUtils