import React from 'react'
import MerchantNavbar from './MerchantNavbar'
import MerchantDashBoard from './MerchantDashBoard'
import {Routes,Route} from "react-router-dom"
import FooterPage from './FooterPage'
import AddItems from './AddItems'
import MerchantUpdate from './MerchantUpdate'
import Products from './Products'
const MerchantHomePage = () => {
  return (
    <div>
      <MerchantNavbar/>
      <Routes>
        <Route path="/" element={<MerchantDashBoard/>}/>
        <Route path="/additems" element={<AddItems/>}/>
        <Route path='/products' element={<Products/>}/>
        <Route path="/editprofile" element={<MerchantUpdate/>}/>
      </Routes>
      <FooterPage/>
    </div>
  )
}

export default MerchantHomePage
