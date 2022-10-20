import React from "react";
import {Outlet} from 'react-router-dom';
import Home from "./Home";

const Content = () => {
  return(
    <Outlet/>
  )
};

export default Content;
