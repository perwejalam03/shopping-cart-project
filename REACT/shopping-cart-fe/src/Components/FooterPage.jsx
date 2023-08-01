import React from 'react'
import { Link } from 'react-router-dom'
import "../styles/footerpage.css"
const FooterPage = () => {
  return (
    <div>
      <div className="footer">
      <Link to="">About Us</Link>
      <Link to="">Contact us</Link> 
      <h5>&copy;copyright2023</h5>
      </div>     
    </div>
  )
}

export default FooterPage
