import React from "react";
import { Link } from "react-router-dom";


const Nav = ( {currentUser} ) => {

  return (
      <ul>
        <div className="stretchBox"/>

              {
                  currentUser != null ?
                      (
                          <>
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
                          </>
                      ) :
                      (
                          <>
                              <Link to="login">
                                  <li>
                                      <label>MyFriends</label>
                                  </li>
                              </Link>
                              <Link to="login">
                                  <li>
                                      <label>MyPubs</label>
                                  </li>
                              </Link>
                              <Link to="login">
                                  <li>
                                      <label>MyTreats</label>
                                  </li>
                              </Link>
                          </>
                      )
              }





        <div className="stretchBox"/>
      </ul>
  );
};

export default Nav;
