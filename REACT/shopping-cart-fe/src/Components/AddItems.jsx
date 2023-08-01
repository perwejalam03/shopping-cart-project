import React from 'react'
import Form from 'react-bootstrap/Form';
const AddItems = () => {
  return (
    <div>
        <form action="" id='form'>
          Category:
          <select name="category" id="">
            <option value="">Mobile</option>
            <option value="">Laptop</option>
            <option value="">TV</option>
            <option value="">Grocery</option>
            <option value="">Watch</option>
          </select>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Product Name:</Form.Label>
        <Form.Control type="text" placeholder="Enter Product Name" value={""} onChange={()=>{}} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>M.R.P</Form.Label>
        <Form.Control type="number" placeholder="Enter Price" value={""} onChange={()=>{}} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Discount Price</Form.Label>
        <Form.Control type="number" placeholder="Enter Discount Price" value={""} onChange={()=>{}} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Thumbnail Image:</Form.Label>
        <Form.Control type="text" placeholder="Image url" value={""} onChange={()=>{}} />
      </Form.Group>
        </form>
    </div>
  )
}

export default AddItems
