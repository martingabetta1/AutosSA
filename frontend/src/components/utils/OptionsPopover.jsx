import { Button, Popover } from '@mui/material'
import { useState } from 'react'
import { useCrudData } from '../../contexts/CrudContext/CrudContext';
import { useError } from '../../contexts/Error';
import Api from '../../services/Api';
import PDFGenerator from './PDFGenerator';

export default function OptionsPopover(props) {

    const { CrudContext } = useCrudData(),
        handleOpenDialog = CrudContext.dialogs.handleOpenDialog,
        [endpoints] = CrudContext.query.endpoints

    const [anchorEl, setAnchorEl] = useState(null);

    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    const open = Boolean(anchorEl);
    const id = open ? 'simple-popover' : undefined;


    return (
        <div>
            <Button variant="contained" className='crud_button_options' onClick={handleClick}>
                <img className='crud_button_image' button-type="options" alt="Options icon" src="/images/crud/options.png" />
            </Button>
            <Popover
                id={id}
                className='popover'
                open={open}
                anchorEl={anchorEl}
                onClose={handleClose}
                anchorOrigin={{
                    vertical: 'top',
                    horizontal: 'left',
                }}
            >
                <div className='crud_accions_box crud_accions_box--popover'>
                    <div>
                        <Button disabled={props.params.row.estado?.descripcion === "Finalizado" || props.params.row.ordenTrabajo?.estado.nombre === "Finalizado"} variant="contained" className={`crud_button_edit ${props.params.row.estado?.descripcion === "Finalizado" || props.params.row.ordenTrabajo?.estado.nombre === "Finalizado" ? "disabled" : ""}`} onClick={() => { handleOpenDialog("edit", true, props.params.row) }}>
                            <img className='crud_button_image' button-type="edit" alt="Edit icon" src="/images/crud/icon-edit.png" />
                        </Button>
                    </div>
                    <div>
                        <Button
                            disabled={props.params.row.estado?.descripcion === "Finalizado" || props.params.row.ordenTrabajo?.estado.nombre === "Finalizado"}
                            variant="contained"
                            className={`crud_button_delete ${props.params.row.estado?.descripcion === "Finalizado" || props.params.row.ordenTrabajo?.estado.nombre === "Finalizado" ? "disabled" : ""}`}
                            onClick={() => { handleOpenDialog("delete", true, props.params.row) }}
                        >
                            <img className='crud_button_image' button-type="delete" alt="Delete icon" src="/images/crud/icon-delete.png" />
                        </Button>
                    </div>
                    {endpoints.download && (
                        <div>
                            <Button variant="contained" className='crud_button_download' onClick={() => { Api.downloadQuery(endpoints.dowload, props.params.row.id) }}>
                                <img className='crud_button_image' button-type="download" alt="Download icon" src="/images/crud/icon-download.png" />
                            </Button>
                        </div>
                    )}
                    {endpoints.listServices && (
                        <div>
                            <Button variant="contained" className='crud_button_listServices' onClick={() => { props.handleListServices(props.params.row.id) }}>
                                <img className='crud_button_image' button-type="listServices" alt="List Services icon" src="/images/crud/icon-services.png" />
                            </Button>
                        </div>
                    )}
                    {endpoints.factura && (
                        <div>
                            <Button variant="contained" className='crud_button_factura' onClick={() => { return PDFGenerator(props.params.row, props.params.row.id, props.endpoints, props.errorGenerator) }}>
                                <img className='crud_button_image' button-type="factura" alt="Factura icon" src="/images/crud/icon-factura.png" />
                            </Button>
                        </div>
                    )}
                </div>
            </Popover>
        </div>
    );
}