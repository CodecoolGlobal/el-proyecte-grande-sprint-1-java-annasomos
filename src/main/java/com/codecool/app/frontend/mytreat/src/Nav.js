import React from "react";
import { Link } from "react-router-dom";

const Nav = () => {
  return (
      <ul>
        <div className="stretchBox"/>
        <Link to="my-friends">
          <li>
            <a>MyFriends</a>
          </li>
        </Link>
        <Link to="/pubs">
          <li>
            <a>MyPubs</a>
          </li>
        </Link>
        <Link to="/mytreats">
          <li>
            <a>MyTreats</a>
          </li>
        </Link>
        <div className="stretchBox"/>
      </ul>
  );
};

export default Nav;
