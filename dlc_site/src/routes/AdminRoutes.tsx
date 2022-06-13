import AdminDashboard from '../pages/AdminPortal/AdminDashboard/AdminDashboard'
import ProgramPage from '../pages/AdminPortal/ProgramPage/ProgramPage'
import ChatPage from '../pages/ChatPage/ChatPage'


export const adminRoutes = [
    { path: '/coach/home', element: <AdminDashboard /> },
    { path: '/coach/chat', element: <ChatPage /> },
    { path: '/coach/calendar', element: <ProgramPage /> }
]

