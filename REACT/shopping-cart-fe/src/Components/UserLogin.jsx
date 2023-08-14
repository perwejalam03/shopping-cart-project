import React, { useState } from 'react'
import Form from 'react-bootstrap/Form';
import "../styles/userlogin.css"
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
const UserLogin = () => {
  const [email,setEmail]=useState("")
  const [password,setPassword]=useState("")

  const navigate=useNavigate()
  const handlesignin=(e)=>{
    axios.post(`http://localhost:8080/users/verify-login?email=${email}&password=${password}`)
    .then((res)=>{
      console.log(res.data.data);
      localStorage.setItem("currentUser",JSON.stringify(res.data.data))
        navigate('/userhome')
    })
    .catch(()=>{
      alert("Invaliid user name")
    })
    e.preventDefault();
  }

  
  return (
    <div>
       <div className="input_group">
     <form action="">
      <h2>User Login</h2>
     <Form>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control type="email" placeholder="Enter email" value={email} onChange={(e)=>{setEmail(e.target.value)}} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Password" value={password} onChange={(e)=>{setPassword(e.target.value)}} />
      </Form.Group>
    </Form>
    <button onClick={handlesignin} className='btn btn-outline-primary'>Sign in</button>
    <Link to='/userregister'><button className='btn btn-outline-danger'>Sign Up</button></Link><br/>
    <Link to='/userforgotpassward'>Forgot Password?</Link>
     </form>
     </div>
    </div>
  );
}

export default UserLogin
