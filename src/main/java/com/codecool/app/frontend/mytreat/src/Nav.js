import React from "react";
import { Link } from "react-router-dom";

const Nav = () => {
  return (
    <nav>
      <Link to="#myfriends">
        <p>MyFriends</p>
      </Link>
      <Link to="#pubs">
        <p>MyPubs</p>
      </Link>
      <Link to="#mytreats">
        <p>MyTreats</p>
      </Link>
    </nav>
  );
};

export default Nav;
