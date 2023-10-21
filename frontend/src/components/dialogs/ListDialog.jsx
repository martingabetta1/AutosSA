import { useEffect, useState } from 'react';
import Button from '@mui/material/Button';
import DialogTitle from '@mui/material/DialogTitle';
import DialogContent from '@mui/material/DialogContent';
import DialogActions from '@mui/material/DialogActions';
import IconButton from '@mui/material/IconButton';
import CloseIcon from '@mui/icons-material/Close';
import DialogsUtils from '../utils/DialogsUtils';
import { useCrudData } from '../../contexts/CrudContext/CrudContext';
import Api from '../../services/Api'
import { useError } from '../../contexts/Error';

export default function DeleteDialog() {
    const { CrudContext } = useCrudData(),
        handleOpenDialog = CrudContext.dialogs.handleOpenDialog,
        [openListDialog] = CrudContext.dialogs.list,
        [dialogData] = CrudContext.dialogs.data,
        [bodyData] = CrudContext.query.bodyData.data,
        [dialogInputs] = CrudContext.inputs

    const handleClose = () => {
        handleOpenDialog("list", false);
    };

    console.log(bodyData);

    return (
        <div>
            <DialogsUtils.Styles.BootstrapDialog
                onClose={handleClose}
                aria-labelledby="delete-dialog"
                open={openListDialog}
                TransitionComponent={DialogsUtils.Functions.Transition}
                keepMounted
            >
                <DialogsUtils.Components.DialogLoader show={openListDialog} />
                <DialogTitle sx={{ m: 0, p: 2 }} id="customized-dialog-title">
                    Listado de servicios
                </DialogTitle>
                <IconButton
                    aria-label="close"
                    onClick={handleClose}
                    sx={{
                        position: 'absolute',
                        right: 8,
                        top: 8,
                        color: (theme) => theme.palette.grey[500],
                    }}
                >
                    <CloseIcon />
                </IconButton>
                <DialogContent dividers>
                    {bodyData.map((value, key) => {
                        return <div style={{ display: "flex", alignItems: "center", justifyContent:"space-evenly", margin: '0 0 20px 0' }}>
                            <div>
                                <b>Tipo de servicio:</b> {value.tipoServicio}
                            </div>
                            <div>
                                <b>Precio:</b> {value.precio}
                            </div>
                        </div>
                    })}
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>
                        Cerrar
                    </Button>
                </DialogActions>
            </DialogsUtils.Styles.BootstrapDialog>
        </div>
    );
}