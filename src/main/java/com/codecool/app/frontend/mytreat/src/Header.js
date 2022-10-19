import React from "react";
import { FaSearch } from "react-icons/fa";
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
