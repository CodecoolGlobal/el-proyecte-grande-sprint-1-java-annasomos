import React from 'react'
import { useState, useEffect } from 'react';
import api from './api/api';
import Default_pfp from './data/images/Default_pfp_rgb.png'
import "./data/card.css";
import Select from 'react-select';

const FriendsList = () => {
  let [allUsers, setAllUsers] = useState([]);
  const [filteredUsers, setFilteredUsers] = useState([]);
  const [search, setSearch] = useState('');
  const [selectedFriends, setSelectedFriends] = useState([]);
  let [friendsList, setFriendsList] = useState([]);
  let [options, setOptions] = useState([]);
  const currentUserId = JSON.parse(localStorage.getItem("currentUser")).id;


  const [selected, setSelected] = useState([]);


  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await api.get("/users");
        allUsers = response.data.filter(
            (user) => user.id !== JSON.parse(localStorage.getItem("currentUser")).id
        )
        setAllUsers(allUsers);


        createOptions()


      } catch (err) {
        if (err.response) {
        } else {
          console.log(`Error: ${err.message}`);
        }
      }
    };
    fetchUsers();
  }, []);

  const handleClear = () => {
    setSelected([]);
  }

  const createOptions = () => {
    options = [];
    //setOptions([])

    allUsers.map((user) => {
      if (allUsers.length > options.length) {
        options.push({
          value: user,
          label: user.userName
        })
      }
    })
    setOptions(options)
  }

  useEffect(() => {
    const filteredResults = allUsers.filter((user) =>
        ((user.userName).toLowerCase()).includes(search.toLowerCase()));

    if(search.length === 0) {
      setFilteredUsers([])
    }else{
      setFilteredUsers(filteredResults);
    }
  }, [search]);


  const handleChange = (event) => {
    //let friendsList = [];
    event.map((friend) => {
      friendsList.push(friend.value)
    })
    setSelectedFriends(friendsList);
    setFriendsList(friendsList);
    console.log(friendsList)
    setSelected([])
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(selected)
    const friendId = selected[0].value.id; //selectedFriends[0].id;
    try {
      const response = await api.post(
          "user/add-friend?id=" + currentUserId + "&friends_id=" + friendId);


      allUsers = allUsers.filter((user) =>
        user.id !== friendId
      )
      setAllUsers(allUsers)
      //setSelectedFriends([])
      //setFriendsList([]);
      //friendsList = [];
      handleClear();
      createOptions();
    } catch (err) {
      console.log(`Error: ${err.message}`);
    }
    listFriends();
  }

  const listFriends = async () => {
    try {
      const response = await api.get(
          "user/get-my-friends-by-user-id?user_id=" + currentUserId);
      //console.log(response.data)
      setFilteredUsers(response.data)
    } catch (err) {
      console.log(`Error: ${err.message}`);
    }

  }


  return (
      <>
          <div className="dropdown-container">
            <button onClick={listFriends}>List</button>
            <button onClick={handleClear}>Clear</button>

            <form onSubmit={handleSubmit}>
              <Select
                  className="select-friends"
                  value={selected}
                  onChange={setSelected}
                  options={options}
                  isMulti
              />
              <button type="submit">Submit</button>
            </form>
          </div>
{/*        <form className="searchForm" onSubmit={(e) => e.preventDefault()}>
          <label htmlFor="search">Search users</label>
          <input
              id="search"
              type="text"
              placeholder="Search Users"
              value={search}
              onChange={(e) => setSearch(e.target.value)}
          />
        </form>*/}
        <div className="grid">
          {filteredUsers.map(user =>
              <div className="col-md-4 animated fadeIn" key={user.id}>
                <div className="card">
                  <div className="card-body">
                    <div className="avatar">
                      <img
                          src={Default_pfp}
                          className="card-img-top"
                          alt="img"
                      />
                    </div>
                    <h5 className="card-title">
                      {(user.firstName) +
                          " " +
                          (user.lastName)}
                    </h5>
                    <p className="card-text">
                      {user.userName}
                      <br />
                      {user.email}
                    </p>
                  </div>
                </div>
              </div>
          )}
        </div>
      </>
  )
}

export default FriendsList