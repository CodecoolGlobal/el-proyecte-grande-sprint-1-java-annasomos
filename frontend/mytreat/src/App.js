import React from "react";
import "./App.css";
import Home from "./Home";
import User from "./User";
import LogIn from "./LogIn";
import Registration from "./Registration";
import AddFriend from "./AddFriend";
import UserList from "./UserList";
import Pub from "./Pub";
import PubList from "./PubList";
import { Routes, Route } from "react-router-dom";
import LogOut from "./LogOut";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="/my-friends" element={<UserList />} />
          <Route path="/users/:userId" element={<User />} />
          <Route path="/pubs" element={<PubList />} />
          <Route path="/pubs/:pubId" element={<Pub />} />
        </Route>
        <Route path="/login" element={<LogIn />} />
        <Route path="/registration" element={<Registration />} />
        <Route path="/add-friend" element={<AddFriend />} />
        <Route path="/logout" element={<LogOut />} />
      </Routes>
    </div>
  );
}

export default App;