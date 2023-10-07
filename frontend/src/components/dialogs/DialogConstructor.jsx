import { useEffect, useState } from 'react';
import TextInput from './inputs/TextInput';
import AutocompleteInput from './inputs/AutocompleteInput';
import SelectInput from './inputs/SelectInput';
import DateInput from './inputs/DateInput';
import { useCrudData } from '../../contexts/CrudContext/CrudContext';
import Validator from '../Validator.jsx'

export default function DialogConstructor() {

    const { CrudContext } = useCrudData(),
        [dialogInputs] = CrudContext.inputs,
        [bodyData] = CrudContext.query.bodyData.data,
        handleInputValueChange = CrudContext.query.bodyData.handleInputValueChange,
        [inputStates] = CrudContext.validations.inputStates

    return (
        <>
            {dialogInputs.map((input, key) => {
                let value = bodyData[input.name],
                    state = inputStates[input.name]
                switch (input.type) {
                    case 'text':
                    case 'number':
                    case 'multiline':
                        return <TextInput
                            key={key}
                            input={input}
                            handleInputValueChange={handleInputValueChange}
                            value={value}
                            type={input.type}
                            state={state}
                        />
                    case 'select':
                        return <SelectInput
                            key={key}
                            input={input}
                            handleInputValueChange={handleInputValueChange}
                            value={value?.id}
                            state={state}
                        />
                    case 'date':
                        return <DateInput
                            key={key}
                            input={input}
                            handleInputValueChange={handleInputValueChange}
                            value={value}
                            state={state}
                        />
                    default:
                        return void (0)
                }
            })}
            <Validator />
        </>
    )
}

