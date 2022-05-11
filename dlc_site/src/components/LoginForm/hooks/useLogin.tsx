import React, { MouseEventHandler, useState } from 'react'
import { login } from '../util/util'
import { flushSync } from 'react-dom'

interface Error {
    message: string
}

export const useLogin = () => {
    const [email, setEmail] = useState<string>('')
    const [password, setPassword] = useState<string>('')
    const [error, setError] = useState<Error | null>(null)
    const [loading, setLoading] = useState<boolean>(false)

    const changeEmail = (event: React.ChangeEvent<HTMLInputElement>): void => {
        setEmail(prev => {
            return event.target.value
        })
    }

    const changePassword = (event: React.ChangeEvent<HTMLInputElement>): void => {
        setPassword(prev => {
            return event.target.value
        })
    }

    const handleLogin = async (event: React.MouseEvent<HTMLButtonElement>): Promise<any> => {
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