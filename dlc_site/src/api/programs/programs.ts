import axios, { AxiosRequestHeaders } from 'axios'

export const createProgram: (token: string, program: Object) => Promise<void> = async (token, program) => {
    try {
        const res = await axios.post('http://localhost:8081/data/macroCycle/add', 
            {
                data: program
            }, 
            {
                headers: { 
                    Authorization: `Bearer ${token}`,
                    'Content-Type': 'application/json' 
                }
            })
        return res.data
    } catch (error) {
        console.log(error)
    }   
}

export const deleteProgram: (token: AxiosRequestHeaders, programId: Number) => Promise<void> = async (token, programId) => {
    try {
        //await axios.delete('http://localhost:8081/data/macroCycle/')
    } catch (error) {
        
    }
}