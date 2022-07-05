import AdminDashboard from '../pages/AdminPortal/AdminDashboard/AdminDashboard'
import ProgramPage from '../pages/AdminPortal/ProgramPage/ProgramPage'
import ChatPage from '../pages/ChatPage/ChatPage'


export const adminRoutes = [
    { path: 'home', element: <AdminDashboard /> },
    { path: 'chat', element: <ChatPage /> },
    { path: 'calendar', element: <ProgramPage /> }
]

