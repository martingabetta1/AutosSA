import React, { createContext, useContext, useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import Alert from '@mui/material/Alert';
import IconButton from '@mui/material/IconButton';
import Collapse from '@mui/material/Collapse';
import Button from '@mui/material/Button';
import CloseIcon from '@mui/icons-material/Close';

const ErrorContexto = createContext();

export default function CrudContextProvider({ children }) {

    // Estados
    const [error, setError] = useState({
        state: false,
        message: ''
    })
    const [open, setOpen] = React.useState(true);

    useEffect(() => {
        if (!open) {
            setError({
                state: false,
                message: ''
            })
        }
    }, [open])

    return (
        <ErrorContexto.Provider value={{ error, setError }}>
            {error.state && (
                <Box sx={{ width: '100%', position: 'fixed', zIndex: 99999,margin:'10px 0 0 0 ' }}>
                    <Collapse in={open}>
                        <Alert
                            severity="error"
                            action={
                                <IconButton
                                    aria-label="close"
                                    color="inherit"
                                    size="small"
                                    onClick={() => {
                                        setOpen(false);
                                    }}
                                >
                                    <CloseIcon fontSize="inherit" />
                                </IconButton>
                            }
                            sx={{ mb: 2 }}
                        >
                            {error.message}
                        </Alert>
                    </Collapse>
                </Box>
            )}
            {children}
        </ErrorContexto.Provider>
    );
}


export const useError = () => {
    const ErrorContext = useContext(ErrorContexto);
    return { ErrorContext };
};