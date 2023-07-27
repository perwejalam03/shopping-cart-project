import React from "react";
import "../styles/errorpage.css";

const ErrorPage = () => {
  return (
    <div className="error-page-container">
      <h1 className="error-heading">Bad Request</h1>
      <p className="error-message">404 Page Not Found</p>
    </div>
  );
};

export default ErrorPage;
