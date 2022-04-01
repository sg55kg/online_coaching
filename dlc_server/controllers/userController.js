import User from '../models/userModel.js'
import mongoose from 'mongoose'

export const createUser = async (req, res) => {
    const user = req.body
    const newUser = new User(user)

    try {
        await newUser.save()
        res.status(201).json(newUser)
    } catch (error) {
        res.status(400).json({ error: 'An error has occured. '})
    }
}

export const updateUser = async (req, res) => {

}

export const deleteUser = async (req, res) => {

}

export const getUsers = async (req, res) => {

}

export const getUser = async (req, res) => {
    
}