import React from 'react'

const AddFriend = () => {
    return(
        <form>
          <label>
            <p>Friend code:</p>
            <input type="text" />
          </label>
          <label>
            <p>Your friend code:</p>
            <p>1234-5678-4321</p>
          </label>
          <div>
            <button type="submit">Submit</button>
          </div>
        </form>
      )
}

export default AddFriend
