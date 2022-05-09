import axios from 'axios'

export const getAllMacroCycles = () => axios.get('http://localhost:8080/macroCycle/getAll')
export const saveMacroCycle = (obj) => axios.post('http://localhost:8080/macroCycle/add', obj)