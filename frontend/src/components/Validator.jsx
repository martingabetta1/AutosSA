import { useEffect, useState } from 'react'
import { useCrudData } from '../contexts/CrudContext/CrudContext'

export default function Validator() {

  const { CrudContext } = useCrudData(),
    [inputValues, setInputValues] = CrudContext.validations.inputValues,
    [inputStates, setInputStates] = CrudContext.validations.inputStates,
    [inputFocus, setInputFocus] = CrudContext.validations.inputFocus,
    handleSetButtonState = CrudContext.validations.handleSetButtonState,
    handleChangeInputStates = CrudContext.validations.handleChangeInputStates,
    [dialogInputs] = CrudContext.inputs,
    inputFocusObject = dialogInputs.find(input => input.name === inputFocus)

  useEffect(() => {
    if (inputValues[inputFocus]) {
      checkValidations()
    }
  }, [inputValues[inputFocus]])

  useEffect(() => {
    if (inputValues[inputFocus]) {
      checkValidations()
    }
  }, [inputFocus])

  useEffect(() => {
    checkButtonState()
  }, [inputValues])

  const typeValidation = () => {
    let inputTypeAllowed = inputFocusObject.validations?.type
    switch (inputTypeAllowed) {
      case "number":
        return !/^[0-9]+$/.test(inputValues[inputFocus])
          ? { state: true, message: `El campo SOLO acepta valores numericos como entrada` }
          : { state: false, message: `` }
      case "notNumbers":
        return !/^[^0-9]+$/.test(inputValues[inputFocus])
          ? { state: true, message: `El campo NO acepta valores numericos como entrada` }
          : { state: false, message: `` }
      case "email":
        return !/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/.test(inputValues[inputFocus])
          ? { state: true, message: `La entrada debe ser un correo electrónico` }
          : { state: false, message: `` }
      default:
        return { state: false, message: `` }
    }
  }

  const lengthValidator = () => {
    let inputLenghtAllowed = inputFocusObject?.validations?.length
    return inputLenghtAllowed < inputValues[inputFocus].length
      ? { state: true, message: `El campo supera el limite de los ${inputLenghtAllowed} caracteres` }
      : { state: false, message: `` }
  }

  const invalidEntries = () => {
    const invalidEntriesRegex = {
      notDoubleSpace: {
        regex: /  /,
        message: 'No está permitido el ingreso de dos espacios juntos'
      }
    }
    for (let index in invalidEntriesRegex) {
      if (invalidEntriesRegex[index].regex.test(inputValues[inputFocus])) {
        return { state: true, message: invalidEntriesRegex[index].message }
      }
    }
    return { state: false, message: `` }
  }

  const checkButtonState = () => {
    for (let index in inputStates) {
      if (inputStates[index].state) {
        handleSetButtonState(true)
        return
      }
    }
    for (let index in inputValues) {
      if (inputValues[index] === "" || inputValues[index] === undefined) {
        handleSetButtonState(true)
        return
      }
    }

    handleSetButtonState(false)
  }

  const checkValidations = () => {
    const validations = [lengthValidator(), typeValidation(), invalidEntries()];

    for (const validation of validations) {
      if (validation.state) {
        handleChangeInputStates(inputFocus, validation);
        return true;
      }
    }

    handleChangeInputStates(inputFocus, { state: false, message: "" });
    return false;
  };

}
