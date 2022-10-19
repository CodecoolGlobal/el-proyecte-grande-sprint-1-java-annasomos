import React from 'react'

const List = ({listData}) => {
  return (
    <ul>
      {listData.map((data) => (
        <li>
          <div>
            {data.name}
            {data.address}
            {data.rating}
            {data.openHours}
          </div>
        </li>
      ))}
    </ul>
  )
}

export default List
