import axios from 'axios'

export const getAllMicroCycles = () => axios.get('http://localhost:8080/microCycle/getAll')
export const saveMicroCycle = (obj) => axios.post('http://localhost:8080/microCycle/add', obj)