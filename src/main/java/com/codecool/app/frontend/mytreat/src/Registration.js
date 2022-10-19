import React from 'react'

const Registration = () => {
    return(
        <form>
          <label>
            <p>Friend code:</p>
            <input type="text" />
          </label>
          <label>
            <p>Your friend code:</p>
            <p></p>
          </label>
          <div>
            <button type="submit">Submit</button>
          </div>
        </form>
      )
}

export default Registration
