import axios from 'axios'
import React, { useState } from 'react'
import Form from 'react-bootstrap/Form';
import "../styles/merchantregister.css"
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
const UserUpdate = () => {
    let user=JSON.parse(localStorage.getItem("currentUser"))
  const [name,setName]=useState(user.name);
  const [phone,setPhone]=useState(user.phone)
  const [email]=useState(user.email)
  const [password,setPassword]=useState(user.password)
  const [gender,setGender]=useState(user.gender)
  const id=user.id;
    const status=user.status;

  const handleupdate=(e)=>{
    const user={id,name,phone,email,password,gender,status}
    axios.put("http://localhost:8080/users",user)
    .then((response)=>{
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
        <Form.Control type="Email" placeholder="Enter your email" value={email}  onChange={()=>{
            toast.success("Cant Update User Email")
        }}/>
            <ToastContainer/>

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
        <button type="submit" onClick={handleupdate} className='btn btn-success px-4 mx-5'>Update</button>
      </form>
    </div>
  )
}

export default UserUpdate
