import { useState } from 'react'
import { login } from '../util/util'
import { flushSync } from 'react-dom'

export const useLogin = () => {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState(null)
    const [loading, setLoading] = useState(false)

    const changeEmail = (event) => {
        setEmail(prev => {
            return event.target.value
        })
    }

    const changePassword = (event) => {
        setPassword(prev => {
            return event.target.value
        })
    }

    const handleLogin = async (event) => {
        event.preventDefault()
        flushSync(() => {
            setLoading(true)
            setError(null)
        })
        try {
            await login(email, password)
        } catch (error) {
            console.log(error)
            setError({ message: 'Error: Username or password is incorrect' })
        } finally {
            setLoading(false)
        }
    }

    return { email, password, error, loading, changeEmail, changePassword, handleLogin }
}