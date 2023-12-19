const filterQueryConstructor = (filtersValues,setFiltersQuery)=>{
    let filtersParams = "?"

    for(let index in filtersValues){
        filtersValues[index] !== ""
        ? filtersParams += `${index}=${filtersValues[index]}&`
        : void(0)
    }

    setFiltersQuery(filtersParams)
}

export {filterQueryConstructor}