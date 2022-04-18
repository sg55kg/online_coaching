import logo from './logo.svg';
import './App.css';
import { useEffect } from 'react'
import * as api from './api/users'
import WriteWeek from './components/WriteWeek';
import Header from './components/Header';

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
  return (
    <div className="App">
      <Header />
      <WriteWeek />
    </div>
  );
}

export default App;
