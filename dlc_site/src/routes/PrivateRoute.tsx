import { useAuth } from "../contexts/AuthContext"
import { Routes, Route } from 'react-router-dom'
import { Outlet } from 'react-router-dom'
import { useKeycloak } from "@react-keycloak/web"
import LandingPage from "../pages/LandingPage/LandingPage"


const PrivateRoute: React.FC<{children: React.ReactNode}> = ({ children }) => {

    const { keycloak } = useKeycloak()

    if(keycloak.authenticated) return <Outlet />
    else return <LandingPage />
    
}

export default PrivateRoute