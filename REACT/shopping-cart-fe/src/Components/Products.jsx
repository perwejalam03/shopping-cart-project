import axios from "axios";
import React from "react"
import { useEffect, useState } from "react";
import "../styles/products.css"

const Products = () => {
    let [products,setProducts]=useState([])
  let merchant = JSON.parse(localStorage.getItem("currentMerchant"));
  useEffect(() => {
    let fetchData = () => {
      axios.get(`http://localhost:8080/products/${merchant.id}`)
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
    <div>
        {products.map((x)=>{
            return(
               <div className="display">
                <div className="image">
                  <img src={x.image} alt="" />
                </div>
                <div className="details">
                  <h1>{x.brand}</h1>
                  <span>Flat INR 2000 Off on ICICI CreditCartd</span>
                  <h2>{x.name}</h2>
                  <p>MRP Price:<strike>{x.price}</strike></p>
                  <button className="btn btn-danger py-0 px-5">DEAL OF THE DAY</button>
                  <p>Discount Price:<h3 id="discount">{x.price-(x.price * 12/100)}</h3></p>
                </div>
               </div>
            )
        })}
    </div>
 )
};

export default Products;
