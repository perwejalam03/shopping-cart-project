import React from 'react'
import { Navigate } from 'react-router-dom'
const ProtectUser = ({Child}) => {
    let verify=()=>{
        let x=localStorage.getItem("currentUser")
        if (x==null) {
            return false;  
        } else {
            return true;
        }
    }
  return (
    <div>
      {verify() ? <Child/> : <Navigate to="/userlogin"/>}
    </div>
  )
}

export default ProtectUser
