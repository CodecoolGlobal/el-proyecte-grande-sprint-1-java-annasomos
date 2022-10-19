import "./App.css";
import { Routes, Route } from "react-router-dom";
import Home from "./Home";
import Header from "./Header";
import Layout from "./Layout";

function App() {
  return (
    <div className="App">
      <Routes path="/">
        <Route index element={<Home />} />
      </Routes>
      {/* <Routes>
        <Route path='/' element={<Layout/>}>
          <Route index element={<Home/>}/>
          <Route path='/friends' element={<Users/>}/>
          <Route path='/user/:userId' element={<User/>}/>
          <Route path='/pubs' element={<Pubs/>}/>
          <Route path='/pubs/:pubId' element={<Pub/>}/>
          <Route path='/login' element={<LogIn/>}/>
          <Route path='/registration' element={<Registration/>}/>
          <Route path='/add-friend' element={<AddFriend/>}/>
        </Route>
      </Routes> */}
    </div>
  );
}

export default App;
