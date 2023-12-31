import { useEffect, useState } from 'react';
import Button from '@mui/material/Button';
import DialogTitle from '@mui/material/DialogTitle';
import DialogContent from '@mui/material/DialogContent';
import DialogActions from '@mui/material/DialogActions';
import IconButton from '@mui/material/IconButton';
import CloseIcon from '@mui/icons-material/Close';
import DialogsUtils from '../utils/DialogsUtils';
import { useCrudData } from '../../contexts/CrudContext/CrudContext';
import { useError } from '../../contexts/Error';
import DialogConstructor from './DialogConstructor';
import Api from '../../services/Api'

export default function CreateDialog() {
    const { CrudContext } = useCrudData(),
        { ErrorContext } = useError(),
        handleOpenDialog = CrudContext.dialogs.handleOpenDialog,
        [openCreateDialog] = CrudContext.dialogs.create,
        [dialogData] = CrudContext.dialogs.data,
        [bodyData] = CrudContext.query.bodyData.data,
        [args] = CrudContext.query.args,
        [endpoints] = CrudContext.query.endpoints,
        [buttonState] = CrudContext.validations.buttonState

    const handleClose = () => {
        handleOpenDialog("create", false);
    };

    const handleCreate = async () => {
        await Api.postQuery(endpoints.create, bodyData, null, args)
            .then((res) => {
                window.location.reload()
            }).catch((error) => {
                ErrorContext.setError(
                    {
                        state: true, message: `Error al tratar de editar el registro\n
                ${error.message}`
                    }
                )
            })
    }

    return (
        <>
            <div style={{ display: 'flex', justifyContent: 'flex-end' }}>
                <div style={{ margin: '0 10px 0 0' }}>
                    <Button variant='contained' onClick={() => handleOpenDialog("create", true)}>Agregar {dialogData.title}</Button>
                </div>
            </div>
            <DialogsUtils.Styles.BootstrapDialog
                onClose={handleClose}
                aria-labelledby="create-dialog"
                open={openCreateDialog}
                TransitionComponent={DialogsUtils.Functions.Transition}
                keepMounted
            >
                <DialogTitle sx={{ m: 0, p: 2 }} id="customized-dialog-title">
                    Agregar {dialogData.title}
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
                    <DialogsUtils.Styles.InputStyles>
                        <DialogConstructor />
                    </DialogsUtils.Styles.InputStyles>
                </DialogContent>
                <DialogActions>
                    <Button variant='contained' onClick={handleCreate} disabled={buttonState}>
                        Agregar
                    </Button>
                    <Button onClick={handleClose}>
                        Cancelar
                    </Button>
                </DialogActions>
            </DialogsUtils.Styles.BootstrapDialog>
        </>
    );
}