import React, { createContext, useContext, useState } from 'react';

const CrudContexto = createContext();

export default function CrudContextProvider({ children }) {

    // Estados
    const [bodyData, setBodyData] = useState({}),
        [rows, setRows] = useState([]),
        [openCreateDialog, setOpenCreateDialog] = useState(false),
        [openEditDialog, setOpenEditDialog] = useState(false),
        [openDeleteDialog, setOpenDeleteDialog] = useState(false),
        [dialogData, setDialogData] = useState({}),
        [dialogInputs, setDialogInputs] = useState([]),
        [endpoints, setEndpoints] = useState({})

    // Funciones
    const handleChangeBodyData = (index, newValue) => {
        setBodyData((prevData) => {
            const updatedBodyData = { ...prevData };
            updatedBodyData[index] = newValue;
            return updatedBodyData;
        });
    };

    function handleOpenDialog(type, state, params) {
        switch (type) {
            case "create":
                state ? void(0) : setBodyData({})
                setOpenCreateDialog(state)
                break
            case "edit":
                state ? setBodyData(params) : setBodyData({})
                setOpenEditDialog(state)
                break
            case "delete":
                state ? setBodyData(params) : setBodyData({})
                setOpenDeleteDialog(state)
                break
            default:
                break
        }
    }

    // Objeto exportable para todo el contexto de CRUD
    const CrudData = {
        // Estructura de la tabla del CRUD
        crudStructure: {
            rows: [rows, setRows]
        },
        // Utils de los dialogs
        dialogs: {
            data: [dialogData, setDialogData],
            create: [openCreateDialog, setOpenCreateDialog],
            edit: [openEditDialog, setOpenEditDialog],
            delete: [openDeleteDialog, setOpenDeleteDialog],
            handleOpenDialog
        },
        // Inputs de los dialogs
        inputs: [dialogInputs, setDialogInputs],
        // Datos para realizar las querys
        query: {
            bodyData: {
                data: [bodyData, setBodyData],
                handleChangeBodyData
            },
            endpoints: [endpoints, setEndpoints],
        },
    }

    return (
        <CrudContexto.Provider value={CrudData}>
            {children}
        </CrudContexto.Provider>
    );
}

export const useCrudData = () => {
    const CrudContext = useContext(CrudContexto);
    return { CrudContext };
};