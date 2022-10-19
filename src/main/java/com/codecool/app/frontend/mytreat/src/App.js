import "./App.css";
import Home from "./Home";
import Header from "./Header";
import Layout from "./Layout";
import LogIn from "./LogIn";
import Registration from "./Registration";
import AddFriend from "./AddFriend";
import { Routes, Route, useNavigate } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route index element={<Home />} />
        {/*<Route path='/friends' element={<Users/>}/>
          <Route path='/user/:userId' element={<User/>}/>
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
