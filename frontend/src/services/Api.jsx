const axios = require('axios'),
    domain = process.env.BASE_URL

async function getQuery(endpoint,params = null) {
    try {
        const res = await axios.get(`${domain}${endpoint}/`, {
            params: {
                params
            }
        })

        return res
    }catch(error){
        throw new Error(error.message)
    }finally{
        console.log("Petición realizada")
    }
}

async function postQuery(endpoint,body,params = null) {
    try {
        const res = await axios.post(`${domain}${endpoint}/`,{body}, {
            params: {
                params
            }
        })
        return res
    }catch(error){
        throw new Error(error.message)
    }finally{
        console.log("Petición realizada")
    }
}

async function putQuery(endpoint,body,params = null) {
    try {
        const res = await axios.put(`${domain}${endpoint}/${body.id}/`,{body}, {
            params: {
                params
            }
        })

        return res
    }catch(error){
        throw new Error(error.message)
    }finally{
        console.log("Petición realizada")
    }
}

async function deleteQuery(endpoint,id,params = null) {
    try {
        const res = await axios.delete(`${domain}${endpoint}/${id}/`, {
            params: {
                params
            }
        })

        return res
    }catch(error){
        throw new Error(error.message)
    }finally{
        console.log("Petición realizada")
    }
}

const Api = {
    getQuery,
    postQuery,
    putQuery
}

export default Api

