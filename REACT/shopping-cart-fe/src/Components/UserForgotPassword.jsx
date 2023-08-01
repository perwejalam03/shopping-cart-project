import React from 'react'
import axios from 'axios'
import { useState } from 'react'
import Form from 'react-bootstrap/Form';
const UserForgotPassword = () => {
    let [email,setEmail]=useState("")
    let handleclick=()=>{
      axios.get(`http://localhost:8080/users/forgot-password?email=${email}`)
      .then(()=>{alert(`OTP has benn sent to your ${email}`)})
      .catch(()=>{alert("please enter the valid email")})
  }
  return (
    <div>
      <form action="">
      <Form>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control type="email" placeholder="Enter email" value={email} onChange={(e)=>{setEmail(e.target.value)}} />
      </Form.Group>
    </Form>
    <button onClick={handleclick} className='btn btn-outline-success px-5'>Submit</button>
      </form>
    </div>
  )
}

export default UserForgotPassword
