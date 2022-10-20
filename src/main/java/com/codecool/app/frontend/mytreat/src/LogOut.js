import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const LogOut = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const logOut = () => {
      localStorage.setItem("currentUser", null);
      navigate("/");
    };
    logOut();
  }, []);
  return;
};

export default LogOut;
