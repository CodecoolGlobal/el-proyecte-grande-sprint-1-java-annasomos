import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const LogOut = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const logOut = () => {
      localStorage.removeItem("currentUser");
      navigate("/");
    };
    logOut();
  }, []);

};

export default LogOut;
