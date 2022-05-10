import { Navigate } from "react-router-dom"

export const navigateToSignupPage = () => {
    return (
        <Navigate to="/signup" />
    )
}

export const navigateToLoginPage = () => {
    return (
        <Navigate to="/login" />
    )
}