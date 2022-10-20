import "./App.css";
import Home from "./Home";
import User from "./User";
import LogIn from './LogIn';
import Registration from './Registration';
import AddFriend from './AddFriend';
import UserList from "./UserList";
import {Routes, Route} from 'react-router-dom';

function App() {

  return (
    <div className="App">
        <Routes>
          <Route index element={<Home/>}/>
          <Route path='/my-friends' element={<UserList />}/>
          <Route path='/users/:userId' element={<User />}/>
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
