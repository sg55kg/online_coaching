import axios from 'axios'

export const getAllDays = () => axios.get('http://localhost:8080/day/getAll')
export const saveDay = (obj) => axios.post('http://localhost:8080/day/add', obj)