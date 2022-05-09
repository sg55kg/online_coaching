import logo from './logo.svg';
import './App.css';
import { useEffect } from 'react'
import { getAllMacroCycles, saveMacroCycle } from './api/macroCycles'
import WriteWeek from './components/WriteWeek/WriteWeek';
import Header from './components/Header/Header';

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
    //test()
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
  return (
    <div className="App">
      <Header />
      <WriteWeek />
    </div>
  );
}

export default App;
