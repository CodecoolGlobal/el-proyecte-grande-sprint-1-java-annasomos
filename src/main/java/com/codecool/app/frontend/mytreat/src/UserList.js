import React from 'react'
import { Link } from 'react-router-dom'
import { useState, useEffect } from 'react';
import api from './api/api';

const UserList = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await api.get("/users");
        setUsers(response.data);
        console.log(response)
      } catch (err) {
        if (err.response) {
          console.log(err.response.data);
          console.log(err.response.status);
          console.log(err.response.headers);
        } else {
          console.log(`Error: ${err.message}`);
        }
      }
    };

    fetchUsers();
  }, []);

  return (
    <div>
      {users.map(user =>
      <div key={user.id}>
        <Link to={`/users/${user.id}`}>{user.name} ({user.email})</Link>
      </div>
      )}
    </div>
  )
}

export default UserList