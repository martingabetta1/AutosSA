import CircularProgress from '@mui/material/CircularProgress';
import { useCrudData } from '../../contexts/CrudContext/CrudContext';

const PrincipalLoader = ({ state }) => {

    const { CrudContext } = useCrudData()

    const [principalLoaderState] = CrudContext.generals.principalLoaderState

    return (
        <>
            {principalLoaderState && (
                <div className='principal-loader'><CircularProgress /></div>
            )}
        </>
    )
}

export { PrincipalLoader }