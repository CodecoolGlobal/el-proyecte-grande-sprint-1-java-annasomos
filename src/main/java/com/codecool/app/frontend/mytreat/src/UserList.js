import React from 'react'
import { Link } from 'react-router-dom'

const UserList = ({users}) => {
  return (
    <div>
      {users.map(user => 
      <div>
        <Link to={`/users/${user.id}`}>{user.name} ({user.email})</Link>
      </div>)}
    </div>
  )
}

export default UserList