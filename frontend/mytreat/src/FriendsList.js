import React from 'react'
import { useState, useEffect } from 'react';
import api from './api/api';
import Default_pfp from './data/images/Default_pfp_rgb.png'
import "./data/card.css";

const FriendsList = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await api.get("/users");
        setUsers(response.data);
        console.log(response.data)
      } catch (err) {
        if (err.response) {
        } else {
          console.log(`Error: ${err.message}`);
        }
      }
    };

    fetchUsers();
  }, []);

  return (
    <div className="grid">
      {users.map(user =>
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
  )
}

export default FriendsList