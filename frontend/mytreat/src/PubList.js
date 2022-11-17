import React from "react";
import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import api from "./api/api";
import Default_pfp from "./data/images/Default_pfp_rgb.png";

const PubList = () => {
  const [pubs, setPubs] = useState(undefined);

  useEffect(() => {
    const fetchPubs = async () => {
      try {
        const response = await api.get("/pubs");
        setPubs(response.data);
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

    fetchPubs();
  }, []);

  if (pubs === undefined) return "Loading...";

  return (
      <div className="grid">
        {pubs.map(pub =>
            <div className="col-md-4 animated fadeIn" key={pub.id}>
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
                    {(pub.name)}
                  </h5>
                  <p className="card-text">
                    {pub.address}
                  </p>
                </div>
              </div>
            </div>
        )}
      </div>
  )
}

export default PubList;
