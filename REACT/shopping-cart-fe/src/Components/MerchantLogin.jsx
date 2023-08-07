import Form from 'react-bootstrap/Form';
import "../styles/merchantlogin.css"
import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios'
const MerchantLogin = () => {
  const [email,setEmail]=useState("")
  const [password,setPassword]=useState("")

  const navigate=useNavigate()
  const handlesignin=(e)=>{
    axios.post(`http://localhost:8080/merchants/verify-login?email=${email}&password=${password}`)
    .then((res)=>{
        console.log(res.data.data);
        localStorage.setItem("currentMerchant",JSON.stringify(res.data.data))
        navigate('/merchanthome')
    })
    .catch(()=>{
      alert("Invaliid user name")
    })
    e.preventDefault();
  }
  return (
    <div>
       <div className="input_group1">
     <form action="">
      <h2>Merchant Login</h2>
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
    <Link to='/merchantregister'><button className='btn btn-outline-danger'>Sign Up</button></Link><br/>
    <Link to='/merchantforgotpassward'>Forgot Password?</Link>
     </form>
     </div>
    </div>
  )
}

export default MerchantLogin
