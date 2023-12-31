import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import "../styles/usernavbar.css"
const Navbar = () => {
    let [sub,setSub]=useState(false);
  return (
    <div>
        <div className="nav">
            <div className="logo">
                <img src="https://mir-s3-cdn-cf.behance.net/projects/404/b8bd62174560251.Y3JvcCw5MDAsNzAzLDAsOTg.jpg" alt="" />
            </div>
            <div className="options">
                <div className="wishlist">
                    <Link to='/userhome/addtoCart'><h3>Add to Kart</h3></Link>
                    <Link to='/userhome/addtowishlist'><h3>Wishlist</h3></Link>
                    <Link to='/userhome/rateProduct'><h3>Rate Product</h3></Link>
                    <Link to='/userhome/placeOrder'><h3>Place Order</h3></Link>
                </div>
                <div className="search">
                    <input type="text" placeholder='Search for Products, Brands and More' />
                    <button className='btn btn-info'>Serach</button>
                </div>
                <div onClick={()=>{setSub(!sub)}} className="profile">
                    <img src="https://media.istockphoto.com/id/1300845620/vector/user-icon-flat-isolated-on-white-background-user-symbol-vector-illustration.jpg?s=612x612&w=0&k=20&c=yBeyba0hUkh14_jgv1OKqIH0CCSWU_4ckRkAoy2p73o=" alt="" />
                   {sub && <div className="d1">
                   <Link to='/userhome/userupdate' id='l1'>Edit Profile</Link>
                    <Link to='' id='l2'>Check Order</Link>
                    <Link to='' id=''>Add Address</Link>
                    <Link to='' id='l3'>Update Address</Link>
                    <Link to='/' id='l4'>Logout</Link>
                   </div>}
                </div>
            </div>
            <div className="hambarger">
                <img src="https://www.svgrepo.com/show/506800/burger-menu.svg" alt="" />
            </div>
        </div>
    </div>
  )
}

export default Navbar
