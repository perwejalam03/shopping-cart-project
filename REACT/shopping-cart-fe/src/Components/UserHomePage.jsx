import React from 'react'
import { Route, Routes } from 'react-router-dom'
import UserDashBoard from './UserDashBoard'
import Navbar from './Navbar'
import FooterPage from './FooterPage'
import UserUpdate from './UserUpdate'
import AddToCart from './AddToCart'
import AddToWishList from './AddToWishList'

const UserHomePage = () => {
  return (
    <div>
      <Navbar/>
      <Routes>
        <Route path='/' element={<UserDashBoard/>}/>
        <Route path='/userupdate' element={<UserUpdate/>}/>
        <Route path='/addtocart' element={<AddToCart/>}/>
        <Route path='addtowishList' element={<AddToWishList/>}/>
      </Routes>
      <FooterPage/>
    </div>
  )
}

export default UserHomePage
