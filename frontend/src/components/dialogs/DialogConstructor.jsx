import { useEffect, useState } from 'react';
import TextInput from './inputs/TextInput';
import AutocompleteInput from './inputs/AutocompleteInput';
import SelectInput from './inputs/SelectInput';
import { useCrudData } from '../../contexts/CrudContext';

export default function DialogConstructor() {

    const { CrudContext } = useCrudData(),
        [dialogInputs] = CrudContext.inputs,
        [bodyData] = CrudContext.query.bodyData.data,
        handleChangeBodyData = CrudContext.query.bodyData.handleChangeBodyData

    return (
        <>
            {dialogInputs.map((input, key) => {
                let value = bodyData[input.name]
                switch (input.type) {
                    case 'text':
                        return <TextInput
                            key={key}
                            input={input}
                            handleChangeBodyData={handleChangeBodyData}
                            value={value}
                        />
                    case 'autocomplete':
                        return <AutocompleteInput
                            key={key}
                            input={input}
                            handleChangeBodyData={handleChangeBodyData}
                            value={value.id}
                        />
                    case 'select':
                        return <SelectInput
                            key={key}
                            input={input}
                            handleChangeBodyData={handleChangeBodyData}
                            value={value.id}
                        />
                    default:
                        return void (0)
                }
            })}
        </>
    )
}

