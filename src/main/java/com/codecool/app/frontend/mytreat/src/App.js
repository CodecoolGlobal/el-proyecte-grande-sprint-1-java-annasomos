import "./App.css";
import Home from "./Home";
import Header from "./Header";
import Layout from "./Layout";
import User from "./User";
import LogIn from './LogIn';
import Registration from './Registration';
import AddFriend from './AddFriend';
import UserList from "./UserList";
import {useState, useEffect} from 'react';
import {Routes, Route, useNavigate} from 'react-router-dom';

function App() {

  const [users, setUsers] = useState([
    {
      id: 1,
      name: "Anna",
      email: "annasomoss@gmail.com"
    },
    {
      id: 2,
      name: "AnnaPanna",
      email: "annasomoss@gmail.com"
    },
    {
      id: 3,
      name: "AnnaPannaKiralylany",
      email: "annasomoss@gmail.com"
    }
  ]);

  return (
    <div className="App">
        <Routes>
          <Route index element={<Home/>}/>
          <Route path='/my-friends' element={<UserList users={users}/>}/>
          <Route path='/users/:userId' element={<User users={users}/>}/>
          {/*
          <Route path='/pubs' element={<Pubs/>}/>
          <Route path='/pubs/:pubId' element={<Pub/>}/> */}
        <Route path="/login" element={<LogIn />} />
        <Route path="/registration" element={<Registration />} />
        <Route path="/add-friend" element={<AddFriend />} />
      </Routes>
    </div>
  );
}

export default App;
