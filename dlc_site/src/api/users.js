import axios from 'axios'

export const getAllUsers = () => axios.get('http://localhost:27017/api/users')
export const getUser = (id) => axios.get(`mongodb://localhost:27017/api/users/${id}`)
export const updateUser = (id, updatedUser) => axios.put(`mongodb://localhost:27017/api/users/${id}`, updatedUser)
export const deleteUser = (id) => axios.delete(`mongodb://localhost:27017/api/users/${id}`)