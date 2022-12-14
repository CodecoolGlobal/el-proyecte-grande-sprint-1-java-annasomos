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
  const [optionList, setOptionList] = useState([]);
  const [selectedOption, setSelectedOption] = useState(null);
  /*
  const options = [
    { value: 'chocolate', label: 'Chocolate' },
    { value: 'strawberry', label: 'Strawberry' },
    { value: 'vanilla', label: 'Vanilla' },
  ];
  */
  const [options, setOptions] = useState([]);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await api.get("/users");
        allUsers = response.data.filter((user) => user.id !== JSON.parse(localStorage.getItem("currentUser")).id)
        setAllUsers(allUsers);

        allUsers.map((user) => {
          if (allUsers.length > options.length) {
            options.push({
              value: user.userName,
              label: user.userName
            })
          }
        })

        //console.log(options)
        //console.log("Options")
        //console.log(response.data)
      } catch (err) {
        if (err.response) {
        } else {
          console.log(`Error: ${err.message}`);
        }
      }
    };
    fetchUsers();




  }, []);



  useEffect(() => {
    const filteredResults = allUsers.filter((user) =>
        ((user.userName).toLowerCase()).includes(search.toLowerCase()));

    if(search.length === 0) {
      setFilteredUsers([])
    }else{
      setFilteredUsers(filteredResults);
    }
  }, [search]);

  function handleSelect() {
    //setSelectedOptions(data);
    console.log("Handle select")
  }
  return (
      <>
          <div className="dropdown-container">
            <Select
                defaultValue={selectedOption}
                onChange={setSelectedOption}
                options={options}
            />
          </div>
        <form className="searchForm" onSubmit={(e) => e.preventDefault()}>
          <label htmlFor="search">Search users</label>
          <input
              id="search"
              type="text"
              placeholder="Search Users"
              value={search}
              onChange={(e) => setSearch(e.target.value)}
          />
        </form>
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