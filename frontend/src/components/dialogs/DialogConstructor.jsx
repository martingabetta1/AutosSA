import { useEffect, useState } from 'react';
import TextInput from './inputs/TextInput';
import AutocompleteInput from './inputs/AutocompleteInput';
import SelectInput from './inputs/SelectInput';
import { useCrudData } from '../../contexts/CrudContext/CrudContext';
import Validator from '../Validator.jsx'

export default function DialogConstructor() {

    const { CrudContext } = useCrudData(),
        [dialogInputs] = CrudContext.inputs,
        [bodyData] = CrudContext.query.bodyData.data,
        handleInputValueChange = CrudContext.query.bodyData.handleInputValueChange

    return (
        <>
            {dialogInputs.map((input, key) => {
                let value = bodyData[input.name]
                switch (input.type) {
                    case 'text':
                    case 'number':
                    case 'multiline':
                        return <TextInput
                            key={key}
                            input={input}
                            handleInputValueChange={handleInputValueChange}
                            value={value}
                            isNumber={input.type === 'number'}
                            isMultiline={input.type === 'multiline'}
                        />
                    case 'autocomplete':
                        return <AutocompleteInput
                            key={key}
                            input={input}
                            handleInputValueChange={handleInputValueChange}
                            value={value?.id}
                        />
                    case 'select':
                        return <SelectInput
                            key={key}
                            input={input}
                            handleInputValueChange={handleInputValueChange}
                            value={value?.id}
                        />
                    default:
                        return void (0)
                }
            })}
            <Validator />
        </>
    )
}

