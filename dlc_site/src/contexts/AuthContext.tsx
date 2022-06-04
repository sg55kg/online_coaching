import { useState, useContext, createContext } from 'react'

interface IAuthContext {
    currentUser: any,
}

const defaultState = {
    currentUser: null
}

export const AuthContext = createContext<IAuthContext>(defaultState)

export const useAuth = () => {
    return useContext(AuthContext)
}

export const AuthProvider: React.FC<any> = ({ children }) => {

    const value = {
        currentUser: null
    }

    return (
        <AuthContext.Provider value={value}>
            {children}
        </AuthContext.Provider>
    )
}