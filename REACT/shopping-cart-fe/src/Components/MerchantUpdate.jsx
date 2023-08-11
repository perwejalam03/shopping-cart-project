import axios from 'axios'
import React, { useState } from 'react'
import Form from 'react-bootstrap/Form';
import "../styles/merchantregister.css"
const MerchantUpdate = () => {
  const [name,setName]=useState("")
  const [phone,setPhone]=useState("")
  const [email,setEmail]=useState("")
  const [password,setPassword]=useState("")
  const [gst,setGst]=useState("")
  const [gender,setGender]=useState("")


  const handleupdate=(e)=>{
    const merchant={name,phone,email,password,gst,gender}
    axios.put("http://localhost:8080/merchants",merchant)
    .then((response)=>{
        setName(response.data.name)
        setGender(response.data.gender)
        setPassword(response.data.password)
        setGst(response.data.gst)
        setPhone(response.data.phone)
      alert("Data updated successfully")
      console.log("Data has been registered");})
    .catch(()=>{
        alert("Data is not updated")
        console.log("something wrong");})
    e.preventDefault();
  }

  return (
    <div>
      <form action="" id='form'>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Name:</Form.Label>
        <Form.Control type="text" placeholder="Enter your Name" value={name}  onChange={(e)=>setName(e.target.value)}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Phone Number:</Form.Label>
        <Form.Control type="tel" pattern='[789][0-9]{10}' placeholder="Enter your phone number" value={phone}  onChange={(e)=>setPhone(e.target.value)}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Email</Form.Label>
        <Form.Control type="Email" placeholder="Enter your email" value={email}  onChange={(e)=>setEmail(e.target.value)}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Enter Password" value={password}  onChange={(e)=>setPassword(e.target.value)} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>GST</Form.Label>
        <Form.Control type="text" placeholder="Enter your GST" value={gst}  onChange={(e)=>setGst(e.target.value)} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Gender:</Form.Label>
        <Form.Check type="radio" label="Male" name="gender" value="male" checked={gender === 'male'} onChange={(e) => setGender(e.target.value)}/>
          <Form.Check input type="radio" label="Female" name="gender" value="female" checked={gender === 'female'} onChange={(e) => setGender(e.target.value)}/>
          <Form.Check type="radio" label="Others" name="gender" value="other" checked={gender === 'other'} onChange={(e) => setGender(e.target.value)}/>
      </Form.Group>
        <button type="submit" onClick={handleupdate} className='btn btn-success px-4 mx-5'>Update</button>
      </form>
    </div>
  )
}

export default MerchantUpdate