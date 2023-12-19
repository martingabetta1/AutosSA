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

export default function RestartDialog() {
    const { CrudContext } = useCrudData(),
        { ErrorContext } = useError(),
        handleOpenDialog = CrudContext.dialogs.handleOpenDialog,
        [openRestartDialog] = CrudContext.dialogs.restart,
        [dialogData] = CrudContext.dialogs.data,
        [bodyData] = CrudContext.query.bodyData.data,
        [endpoints] = CrudContext.query.endpoints,
        [dialogInputs] = CrudContext.inputs

    const handleClose = () => {
        handleOpenDialog("restart", false);
    };

    const handleDelete = async () => {
        await Api.deleteQuery(endpoints.restart, bodyData.id)
            .then((res) => {
                window.location.reload()
            }).catch((error) => {
                ErrorContext.setError(
                    {
                        state: true, message: `Error al tratar de eliminar el registro\n
                ${error.message}`
                    }
                )
            })
    }


    return (
        <div>
            <DialogsUtils.Styles.BootstrapDialog
                onClose={handleClose}
                aria-labelledby="delete-dialog"
                open={openRestartDialog}
                TransitionComponent={DialogsUtils.Functions.Transition}
                keepMounted
            >
                <DialogsUtils.Components.DialogLoader show={openRestartDialog} />
                <DialogTitle sx={{ m: 0, p: 2 }} id="customized-dialog-title">
                    Reestablecer {dialogData.title}
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
                    <div className="deleteDialog-label" style={{ margin: '0 0 20px 0' }}>
                        ¿Está seguro/a que desea reestablecer el siguiente registro?
                    </div>
                    <li key={0}><b>ID:</b> {bodyData.id}</li>

                    {dialogInputs.map((input, key) => {
                        return typeof bodyData[input.name] === "object"
                            ? <li key={key + 1}><b>{input.label}:</b> {bodyData[input.name].descripcion}</li>
                            : <li key={key + 1}><b>{input.label}:</b> {bodyData[input.name]}</li>
                    })}

                </DialogContent>
                <DialogActions>
                    <Button variant='contained' onClick={handleDelete}>
                        Reestablecer
                    </Button>
                    <Button onClick={handleClose}>
                        Cancelar
                    </Button>
                </DialogActions>
            </DialogsUtils.Styles.BootstrapDialog>
        </div>
    );
}