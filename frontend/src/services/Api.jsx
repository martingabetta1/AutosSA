import axios from 'axios'

const domain = 'http://localhost:8080'

async function getQuery(endpoint, params = null) {
    try {
        const res = await axios.get(`${domain}${endpoint}`, {
            params
        })

        return res.data
    } catch (error) {
        throw new Error(error.message)
    } finally {
        console.log("Petición realizada")
    }
}

async function postQuery(endpoint, body, params = null, args = {}) {
    let res
    try {
        if (!args.multipart) {
            res = await axios.post(`${domain}${endpoint}`, { ...body }, {
                params
            })
        } else {
            const formData = new FormData();
            for (const key in body) {
                formData.append(key, body[key]);
            }

            res = await axios.post(`${domain}${endpoint}`, formData, {
                params,
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            });
        }
        return res
    } catch (error) {
        throw new Error(error.message)
    } finally {
        console.log("Petición realizada")
    }

}

async function putQuery(endpoint, body, params = null,args = {}) {
    let res
    try {
        if (!args.multipart) {
            res = await axios.put(`${domain}${endpoint}/actualizar/${body.id}`, { ...body }, {
                params
            })
        } else {
            const formData = new FormData();
            for (const key in body) {
                formData.append(key, body[key]);
            }

            res = await axios.put(`${domain}${endpoint}/actualizar/${body.id}`, formData, {
                params,
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            });
        }
        return res
    } catch (error) {
        throw new Error(error.message)
    } finally {
        console.log("Petición realizada")
    }
}

async function deleteQuery(endpoint, id, params = null) {
    try {
        const res = await axios.post(`${domain}${endpoint}/eliminar/${id}`, {
            params: {
                params
            }
        })

        return res
    } catch (error) {
        throw new Error(error.message)
    } finally {
        console.log("Petición realizada")
    }
}

async function downloadQuery(endpoint, id, params = null) {
    try {
        const res = await axios.get(`${domain}${endpoint}/descargar/${id}`, {
            params: {
                params
            }
        })

        return res
    } catch (error) {
        throw new Error(error.message)
    } finally {
        console.log("Petición realizada")
    }
}

const Api = {
    getQuery,
    postQuery,
    putQuery,
    deleteQuery,
    downloadQuery,
}

export default Api

