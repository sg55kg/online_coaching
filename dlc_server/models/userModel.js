import mongoose from 'mongoose'
const { Schema } = mongoose

const userSchema = new Schema({
    token: String,
    name: String,
    email: String,
    snatch: Number,
    cleanAndJerk: Number,
    backSquat: Number,
    frontSquat: Number,
    deadlift: Number,
    snatchDeadlift: Number,
    press: Number,
    row: Number
})

export const User = mongoose.model('User', userSchema)
