import axios from 'axios'
import React, { useState } from 'react'
import Form from 'react-bootstrap/Form';
import "../styles/merchantregister.css"
const UserRegister = () => {
    const [name,setName]=useState("")
    const [phone,setPhone]=useState("")
    const [email,setEmail]=useState("")
    const [status,setStatus]=useState("")
    const [password,setPassword]=useState("")
    const [gender,setGender]=useState("")
  
    const handleRegister=(e)=>{
      const merchant={name,phone,email,status,password,gender}
      axios.post("http://localhost:3000/users",merchant)
      .then(()=>{
        alert("Data added successfully")
        console.log("Data has been registered");})
      .catch(()=>{console.log("something wrong");})
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
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control type="email" placeholder="Enter your email" value={email}  onChange={(e)=>setEmail(e.target.value)} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Status</Form.Label>
        <Form.Control input type="text" value={status}  onChange={(e)=>setStatus(e.target.value)} placeholder="Enter Status" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Enter Password" value={password}  onChange={(e)=>setPassword(e.target.value)} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Gender:</Form.Label>
        <Form.Check type="radio" label="Male" name="gender" value="male" checked={gender === 'male'} onChange={(e) => setGender(e.target.value)}/>
          <Form.Check input type="radio" label="Female" name="gender" value="female" checked={gender === 'female'} onChange={(e) => setGender(e.target.value)}/>
          <Form.Check type="radio" label="Others" name="gender" value="other" checked={gender === 'other'} onChange={(e) => setGender(e.target.value)}/>
      </Form.Group>
        <button type="submit" onClick={handleRegister} className='btn btn-success px-4 mx-5'>Register</button>
      </form>
    </div>
  )
}

export default UserRegister
