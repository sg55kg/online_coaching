import { useState } from 'react'
import { Outlet, Routes, Route } from 'react-router-dom'
import AdminBody from '../../components/AdminBody/AdminBody'
import AdminNav from '../../components/AdminNav/AdminNav'
import Header from '../../components/Header/Header'
import { AdminProvider } from '../../contexts/AdminContext'

const AdminPortal = () => {
    const [viewNav, setViewNav] = useState<boolean>(false)
    return (
        <div>
            <AdminProvider>
                <Header viewNav={viewNav} setViewNav={setViewNav} />
                <div style={{ display: 'flex' }}>
                    <AdminNav viewNav={viewNav} setViewNav={setViewNav} />
                    <AdminBody />
                </div>
            </AdminProvider>
        </div>
    )
}

export default AdminPortal