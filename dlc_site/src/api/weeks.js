import axios from 'axios'

export const getAllWeeks = () => axios.get('http://localhost:8080/week/getAll')
export const saveWeek = (obj) => axios.post('http://localhost:8080/week/add', obj)