import React from 'react'
import { Navigate } from 'react-router-dom'
const Protect = ({Child}) => {
    let verify=()=>{
        let x=localStorage.getItem("currentMerchant")
        if (x==null) {
            return false;  
        } else {
            return true;
        }
    }
  return (
    <div>
      {verify() ? <Child/> : <Navigate to="/merchantlogin"/>}
    </div>
  )
}

export default Protect
