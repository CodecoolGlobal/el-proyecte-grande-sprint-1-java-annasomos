import React from "react";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const LogOut = () => {
  const navigate = useNavigate();

  useEffect(() => {
    localStorage.setItem("currentUser", null);
    navigate("/");
  }, []);
  return;
};

export default LogOut;
