import { Outlet } from 'react-router-dom'
import AdminBody from '../../components/AdminBody/AdminBody'
import AdminNav from '../../components/AdminNav/AdminNav'
import Header from '../../components/Header/Header'
import { AdminProvider } from '../../contexts/AdminContext'

const AdminPortal = () => {
    return (
        <div>
            <AdminProvider>
                <Header />
                <AdminNav />
                <AdminBody />
            </AdminProvider>
        </div>
    )
}

export default AdminPortal