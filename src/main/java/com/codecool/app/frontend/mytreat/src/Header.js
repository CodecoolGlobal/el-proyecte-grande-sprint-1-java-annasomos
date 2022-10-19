import React from "react";
import { FaSearch } from "react-icons/fa";
import Footer from "./Footer";
import Nav from "./Nav";

const Header = () => {
  return (
    <header>
      <p>MyTreat</p>
      <div>
        <input type="text" placeholder="Search..." />
        <FaSearch />
      </div>
      <Nav />
    </header>
  );
};

export default Header;
