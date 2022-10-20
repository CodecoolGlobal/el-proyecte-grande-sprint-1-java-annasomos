import React from "react";
import { Link } from "react-router-dom";

const Nav = () => {
  return (
      <ul>
        <div className="stretchBox"/>
        <Link to="my-friends">
          <li>
            <label>MyFriends</label>
          </li>
        </Link>
        <Link to="/pubs">
          <li>
            <label>MyPubs</label>
          </li>
        </Link>
        <Link to="/mytreats">
          <li>
            <label>MyTreats</label>
          </li>
        </Link>
        <div className="stretchBox"/>
      </ul>
  );
};

export default Nav;
