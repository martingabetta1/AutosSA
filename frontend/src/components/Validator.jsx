import {useEffect, useState} from 'react'
import { useCrudData }  from '../contexts/CrudContext/CrudContext'

export default function Validator() {

    const {CrudContext} = useCrudData(),
    [inputValues, setInputValues] = CrudContext.validations.inputValues,
    [inputStates, setInputStates] = CrudContext.validations.inputStates,
    [inputFocus, setInputFocus] = CrudContext.validations.inputFocus,
    [dialogInputs] = CrudContext.inputs


  return (
    <>
      
    </>
  )
}
