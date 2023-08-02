import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import LandingPage from './Components/LandingPage'
import UserLogin from './Components/UserLogin'
import MerchantLogin from './Components/MerchantLogin'
import 'bootstrap/dist/css/bootstrap.min.css';
import MerchantRegister from './Components/MerchantRegister'
import MerchantHomePage from './Components/MerchantHomePage'
import UserRegister from './Components/UserRegister'
import UserHomePage from './Components/UserHomePage'
import ErrorPage from './Components/ErrorPage'
import MerchantForgotPassword from './Components/MerchantForgotPassword'
import UserForgotPassword from './Components/UserForgotPassword'
const App = () => {
  return (
    <div>
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<LandingPage/>} />
        <Route path='/userlogin' element={<UserLogin/>} />
        <Route path="/userregister" element={<UserRegister/>} />
        <Route path='/userhome/*' element={<UserHomePage/>} />
        <Route path='/merchantlogin' element={<MerchantLogin/>} />
        <Route path='/merchantregister' element={<MerchantRegister/>}/>
        <Route path='/merchanthome/*' element={<MerchantHomePage/>} />
        <Route path='*' element={<ErrorPage/>} />
        <Route path='/merchantforgotpassward' element={<MerchantForgotPassword/>}/>
        <Route path='/userforgotpassward' element={<UserForgotPassword/>}/>
      </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
