import React, {useState} from "react";
import { FaSearch } from "react-icons/fa";
import logo from './logo.jpg';
import Nav from "./Nav";
import { Link } from "react-router-dom";
import { useEffect } from "react";

const Header = () => {
  const [currentUser, setCurrentUser] = useState({});

  useEffect(() => {
    setCurrentUser(localStorage.getItem("currentUser"));
  }, [localStorage.getItem("currentUser")])
  return (
    <header>
      <ul>
        <li>
          <img
            style={{ width: 400, height: 400 }} src={logo} alt="Logo"
          />
        </li>

        {
          currentUser != null ?
              (
                  <li>
                    <Link to="/logout">LogOut</Link>
                  </li>
              ) :
              (
                  <>
                    <li>
                      <Link to="/login">Login</Link>
                    </li>
                    <li>
                      <Link to="/registration">Register</Link>
                    </li>
                  </>
              )
        }

        <li>
          <div>
            <input type="text" placeholder=" Search..." className="search"/>
            <FaSearch className="searchIcon"/>
          </div>
        </li>
      </ul>
      <Nav currentUser={currentUser} />
    </header>
  );
};

export default Header;
