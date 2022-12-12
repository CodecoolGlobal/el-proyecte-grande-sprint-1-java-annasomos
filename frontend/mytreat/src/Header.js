import React from "react";
import { FaSearch } from "react-icons/fa";
import logo from './logo.jpg';
import Nav from "./Nav";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <header>
      <ul>
        <li>
          <img
            style={{ width: 400, height: 400 }} src={logo} alt="Logo"
          />
        </li>
        <li>
          <Link to="/login">Login</Link>
        </li>
        <li>
          <Link to="/registration">Register</Link>
        </li>
        <li>
          <div>
            <input type="text" placeholder=" Search..." className="search"/>
            <FaSearch className="searchIcon"/>
          </div>
        </li>
      </ul>
      <Nav />
    </header>
  );
};

export default Header;
