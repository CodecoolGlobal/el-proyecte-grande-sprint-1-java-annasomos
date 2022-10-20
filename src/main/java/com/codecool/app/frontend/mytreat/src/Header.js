import React from "react";
import { FaSearch } from "react-icons/fa";
import Footer from "./Footer";
import logo from './logo.jpg';
import Nav from "./Nav";

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
