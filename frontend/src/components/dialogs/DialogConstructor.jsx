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
        handleInputValueChange = CrudContext.query.bodyData.handleInputValueChange

    return (
        <>
            {dialogInputs.map((input, key) => {
                let value = bodyData[input.name]
                switch (input.type) {
                    case 'text':
                        return <TextInput
                            key={key}
                            input={input}
                            handleInputValueChange={handleInputValueChange}
                            value={value}
                        />
                    case 'select':
                        return <SelectInput
                            key={key}
                            input={input}
                            handleInputValueChange={handleInputValueChange}
                            value={value?.id}
                        />
                    case 'date':
                        return <DateInput
                            key={key}
                            input={input}
                            handleInputValueChange={handleInputValueChange}
                            value={value}
                        />
                    default:
                        return void (0)
                }
            })}
            <Validator />
        </>
    )
}

