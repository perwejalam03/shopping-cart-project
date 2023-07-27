import React from 'react'
import { Link } from 'react-router-dom'
import "../styles/navbar.css"
const Navbar = () => {
  return (
    <div>
        <div className="nav">
            <div className="logo">
                <img src="https://mir-s3-cdn-cf.behance.net/projects/404/b8bd62174560251.Y3JvcCw5MDAsNzAzLDAsOTg.jpg" alt="" />
            </div>
            <div className="options">
                <div className="wishlist">
                    <Link to=''><h3>Wishlist</h3></Link>
                </div>
                <div className="search">
                    <input type="text" placeholder='Search for Products, Brands and More' />
                    <button className='btn btn-info'>Serach</button>
                </div>
                <div className="profile">
                    <img src="https://media.istockphoto.com/id/1300845620/vector/user-icon-flat-isolated-on-white-background-user-symbol-vector-illustration.jpg?s=612x612&w=0&k=20&c=yBeyba0hUkh14_jgv1OKqIH0CCSWU_4ckRkAoy2p73o=" alt="" />
                </div>
            </div>
        </div>
    </div>
  )
}

export default Navbar
