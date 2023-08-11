import axios from "axios";
import React from "react"
import { useEffect, useState } from "react";
// import "../styles/products.css"
import "../styles/userdashboard.css"
import FavoriteIcon from '@mui/icons-material/Favorite';

const UserDashBoard = () => {
    let [products,setProducts]=useState([])
  useEffect(() => {
    let fetchData = () => {
      axios.get("http://localhost:8080/products")
        .then((res) => {
          console.log(res.data.data);
          setProducts(res.data.data)
        })
        .catch(() => {
          alert("Not a good request");
        });
    };
    fetchData();
  },[]);
 return(
    <div className="view1">
        {products.map((x)=>{
            return(
               <div className="mobile1">
                <div className="display1">
                <div className="image1">
                  <img src={x.image} alt="" />
                </div>
                <hr />
                <div className="details1">
                  <h1>{x.brand}</h1>
                  <span>Flat INR 2000 Off on ICICI CreditCard</span>
                  <h2>{x.name}</h2>
                  <p>MRP Price:<strike>{x.price}</strike></p>
                  <button className="btn btn-danger py-0 px-5">DEAL OF THE DAY</button>
                  <p>Discount Price:<h3 id="discount">{x.price-(x.price * 12/100)}</h3></p>
                  <button className="btn btn-success b1">Add item</button>  <FavoriteIcon/>
                </div>
               </div>
               </div>
            )
        })}
    </div>
 )
};

export default UserDashBoard;
