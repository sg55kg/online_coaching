import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import { AuthProvider } from './contexts/AuthContext'
import { useEffect } from 'react'
import { getAllMacroCycles, saveMacroCycle } from './api/macroCycles'
import LandingPage from './pages/LandingPage/LandingPage'
import NotFound from './pages/404/NotFound'
import Login from './pages/Login/Login'
import Signup from './pages/Signup/Signup'
import PrivateRoute from './routes/PrivateRoute'
import AdminPortal from './pages/AdminPortal/AdminPortal'
import AthletePortal from './pages/AthletePortal/AthletePortal'
import { getToken } from './api/auth/getToken'
import { adminRoutes } from './routes/AdminRoutes'

function App() {
  //useEffect(() => {
  //   const test = async () => {
  //     try {
  //     const data = await api.getAllUsers()
  //     console.log(data)
  //     } catch (error) {
  //       console.log(error)
  //     }
  //   }
  //   test()
  // },[])


  useEffect(() => {
    const test = async () => {
      try {
        const res = await getAllMacroCycles()
        console.log(res.data)
      } catch (error) {
        console.log(error)
      }
    }
    
  },[])

  useEffect(() => {
    const test = async () => {
      try {
        const res = await saveMacroCycle({
          startDate: Date.now(),
          totalReps: 5000
        })
        console.log(res)
      } catch (error) {
        console.log(error)
      }
    }
    // test()
  },[])

  useEffect(() => {
    const test = async () => {
      try {
        //const token = await getToken()
        //console.log(token)
      } catch (error) {
        console.log(error)
      }
    }
   // test()
  },[])
  return (
    <Router>
      <AuthProvider>
        <div className="App">
          <Routes>
            <Route path="/" element={<LandingPage />} />
            <Route path="*" element={<NotFound />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />

            <Route path="/coach" element={<AdminPortal />}>
              {adminRoutes.map((route) => {
                return (
                  <Route path={route.path} element={route.element} />
                )
              })}
            </Route>
            
            <Route path="/:athlete" element={<AthletePortal />} />
          </Routes>
        </div>
      </AuthProvider>
    </Router>
  );
}

export default App;
