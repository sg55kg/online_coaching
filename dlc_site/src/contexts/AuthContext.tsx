import { useState, useContext, createContext, useEffect } from 'react'
import { ReactKeycloakProvider } from '@react-keycloak/web'
import keycloak from '../api/config/Keycloak'

interface IAuthContext {
    currentUser: any,
    children?: React.ReactNode
}

const defaultState = {
    currentUser: null
}

export const AuthContext = createContext<IAuthContext>(defaultState)

export const useAuth = () => {
    return useContext(AuthContext)
}

export const AuthProvider: React.FC<{children: React.ReactNode}> = ({ children }) => {
    const [currentUser, setCurrentUser] = useState<any>(null)

    useEffect(() => { 
        let flag = true
        if(flag && keycloak.authenticated) {
            console.log(keycloak.idTokenParsed)
            console.log(keycloak.hasRealmRole('coach'))
            setCurrentUser(keycloak.idTokenParsed)
        }
        return () => { 
            flag = false
        }
    },[keycloak.authenticated])

    const value = {
        currentUser
    }

    return (
        <ReactKeycloakProvider authClient={keycloak}>
            <AuthContext.Provider value={value}>
                {children}
            </AuthContext.Provider>
        </ReactKeycloakProvider>   
    )
}