import { useAuth } from "../contexts/AuthContext"
import { Routes, Route } from 'react-router-dom'

const PrivateRoute = ({ path, element }) => {
    return (
        <Routes>
            <Route path={path} element={element} />
        </Routes>
    )
}

export default PrivateRoute