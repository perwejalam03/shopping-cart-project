import React from 'react'
import { Route, Routes } from 'react-router-dom'
import UserDashBoard from './UserDashBoard'
import Navbar from './Navbar'
import FooterPage from './FooterPage'
import UserUpdate from './UserUpdate'

const UserHomePage = () => {
  return (
    <div>
      <Navbar/>
      <Routes>
        <Route path='/' element={<UserDashBoard/>}/>
        <Route path='/userupdate' element={<UserUpdate/>}/>
      </Routes>
      <FooterPage/>
    </div>
  )
}

export default UserHomePage
