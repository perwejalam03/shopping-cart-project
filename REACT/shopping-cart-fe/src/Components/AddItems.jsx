import axios from 'axios';
import React, { useState } from 'react'
import Form from 'react-bootstrap/Form';
const AddItems = () => {

  let [name,setName]=useState("")
  let [brand,setBrand]=useState("")
  let [category,setCategory]=useState("")
  let [description,setDescription]=useState("")
  let [price,setPrice]=useState("")
let [image,setImage]=useState("")

const handlesubmit=(e)=>{
  let merchant=JSON.parse(localStorage.getItem("currentMerchant"))
  const product={name,brand,category,description,price,image}
  axios.post(`http://localhost:8080/products/${merchant.id}`,product)
  .then(()=>{
    alert("Product added successfully")})
  .catch(()=>{console.log("something wrong");})
  e.preventDefault();
}
  return (
    <div>
        <form action="" id='form'>
          Category:
          <Form.Select value={category} onChange={(e)=>{setCategory(e.target.value)}}>
            <option>Electronics</option>
            <option>Grocery</option>
            <option>Apperance</option>
            <option>Beauty</option>
            <option>Furniture</option>
          </Form.Select>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Product Name:</Form.Label>
        <Form.Control type="text" placeholder="Enter Product Name" value={name} onChange={(e)=>{setName(e.target.value)}} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Brand</Form.Label>
        <Form.Control type="text" placeholder="Enter brand name" value={brand} onChange={(e)=>{setBrand(e.target.value)}} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Description</Form.Label>
        <Form.Control type="text" placeholder="Enter Description" value={description} onChange={(e)=>{setDescription(e.target.value)}} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Price</Form.Label>
        <Form.Control type="number" placeholder="Enter Price" value={price} onChange={(e)=>{setPrice(e.target.value)}} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Thumbnail Image:</Form.Label>
        <Form.Control type="text" placeholder="Image url" value={image} onChange={(e)=>{setImage(e.target.value)}} />
      </Form.Group>
      <button onClick={handlesubmit} className='btn btn-success'>Add Items</button>
        </form>
    </div>
  )
  }

export default AddItems;
