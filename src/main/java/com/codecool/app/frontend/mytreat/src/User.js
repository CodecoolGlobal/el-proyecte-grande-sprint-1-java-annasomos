import React from 'react'
import { useParams } from 'react-router-dom'


const User = ({users}) => {
  const { userId } = useParams();
  const user = users.find(user => user.id.toString() === userId);
  return (
    <div>
      <h2>{user.name}</h2>
      <p>{user.email}</p>
    </div>
  )
}

export default User