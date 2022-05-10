import { useState, useContext, createContext } from 'react'

export const AuthContext = createContext('')

export const useAuth = () => {
    useContext(AuthContext)
}

export const AuthProvider = ({ children }) => {

    const value = {}

    return (
        <AuthContext.Provider value={value}>
            {children}
        </AuthContext.Provider>
    )
}