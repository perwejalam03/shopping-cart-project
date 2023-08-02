import React from 'react'
import MerchantNavbar from './MerchantNavbar'
import MerchantDashBoard from './MerchantDashBoard'
import {Routes,Route} from "react-router-dom"
import FooterPage from './FooterPage'
import AddItems from './AddItems'
const MerchantHomePage = () => {
  return (
    <div>
      <MerchantNavbar/>
      <Routes>
        <Route path="/" element={<MerchantDashBoard/>}/>
        <Route path="/additems" element={<AddItems/>}/>
      </Routes>
      <FooterPage/>
    </div>
  )
}

export default MerchantHomePage
