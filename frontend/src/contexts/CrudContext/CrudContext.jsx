import React, { createContext, useContext, useEffect, useState } from 'react';

const CrudContexto = createContext();

export default function CrudContextProvider({ children }) {

    // Estados
    const [principalLoaderState,setPrincipalLoaderState] = useState(false),
        [bodyData, setBodyData] = useState({}),
        [args, setArgs] = useState({}),
        [rows, setRows] = useState([]),
        [columns, setColums] = useState([]),
        [openCreateDialog, setOpenCreateDialog] = useState(false),
        [openEditDialog, setOpenEditDialog] = useState(false),
        [openDeleteDialog, setOpenDeleteDialog] = useState(false),
        [openListDialog, setOpenListDialog] = useState(false),
        [dialogData, setDialogData] = useState({}),
        [dialogInputs, setDialogInputs] = useState([]),
        [endpoints, setEndpoints] = useState({}),
        [inputValues, setInputValues] = useState({}),
        [inputStates, setInputStates] = useState({}),
        [inputFocus, setInputFocus] = useState(),
        [buttonState, setButtonState] = useState(false),
        [filtersValues,setFiltersValues] = useState({}),
        [filtersQuery,setFiltersQuery] = useState("")


    useEffect(() => {
        setInputValues((prevValues) => {
            let newValues = { ...prevValues, ...bodyData }
            return newValues
        })
    }, [bodyData])

    useEffect(() => {
        handleSetInputValues()
        setArgs({})
    }, [dialogInputs])

    const handleSetInputValues = () => {
        let initialValues = {}

        for (let index in dialogInputs) {
            if (dialogInputs[index].type !== 'file') {
                initialValues[dialogInputs[index].name] = ""
            }
        }
        setInputValues(initialValues)
    };

    // Funciones
    const handleInputValueChange = (inputName, newValue) => {
        setBodyData((prevData) => {
            const updatedBodyData = { ...prevData };
            updatedBodyData[inputName] = newValue;
            return updatedBodyData;
        });
        setInputFocus(inputName)
    };

    const handleSetInputStates = (params) => {
        let newInputStates = {}
        for (let index in params) {
            newInputStates[index] = { state: false, message: "" }
        }
        setInputStates(newInputStates)
    }

    const handleChangeInputStates = (inputFocus, state) => {
        setInputStates((prevStates) => {
            let newState = { ...prevStates }
            newState[inputFocus] = state
            return newState
        })
    }

    const handleSetButtonState = (state) => {
        setButtonState(state)
    }

    const handleOpenDialog = (type, state, params) => {
        switch (type) {
            case "create":
                state ? void (0) : setBodyData({})
                handleSetInputStates()
                setOpenCreateDialog(state)
                break
            case "edit":
                state ? setBodyData(params) : setBodyData({})
                handleSetInputStates(params)
                setOpenEditDialog(state)
                break
            case "delete":
                state ? setBodyData(params) : setBodyData({})
                setOpenDeleteDialog(state)
                break
            case "list":
                state ? setBodyData(params) : setBodyData({})
                setOpenListDialog(state)
                break
            default:
                break
        }
    }

    // Objeto exportable para todo el contexto de CRUD
    const CrudData = {
        // Estructura de la tabla del CRUD
        generals:{
            principalLoaderState: [principalLoaderState,setPrincipalLoaderState] 
        },
        crudStructure: {
            rows: [rows, setRows],
            columns: [columns, setColums]
        },
        // Utils de los dialogs
        dialogs: {
            data: [dialogData, setDialogData],
            create: [openCreateDialog, setOpenCreateDialog],
            edit: [openEditDialog, setOpenEditDialog],
            delete: [openDeleteDialog, setOpenDeleteDialog],
            list: [openListDialog, setOpenListDialog],
            handleOpenDialog
        },
        // Inputs de los dialogs
        inputs: [dialogInputs, setDialogInputs],
        validations: {
            inputValues: [inputValues, setInputValues],
            inputStates: [inputStates, setInputStates],
            inputFocus: [inputFocus, setInputFocus],
            buttonState: [buttonState, setButtonState],
            handleChangeInputStates,
            handleSetButtonState
        },
        // Datos para realizar las querys
        query: {
            bodyData: {
                data: [bodyData, setBodyData],
                handleInputValueChange
            },
            endpoints: [endpoints, setEndpoints],
            args: [args, setArgs]
        },
        filters:{
            filtersValues: [filtersValues,setFiltersValues],
            filtersQuery : [filtersQuery,setFiltersQuery]
        }
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