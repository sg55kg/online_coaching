const express = require('express')
const cors = require('cors')
const userRoutes = require('./routes/userRoutes')

const app = express()
app.use(cors())
app.use(express.urlencoded({extended: true}));
app.use(express.json())

app.use('/users', userRoutes)

const PORT = 3000

app.listen(PORT, () => {
    console.log(`Running on port: ${PORT}`)
})