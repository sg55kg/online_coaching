import axios from 'axios'

export const getAllExercises = () => axios.get('http://localhost:8080/exercise/getAll')
export const saveExercise = (obj) => axios.post('http://localhost:8080/exercise/add', obj)