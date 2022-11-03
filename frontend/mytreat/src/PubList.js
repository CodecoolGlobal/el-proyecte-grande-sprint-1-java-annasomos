import React from "react";
import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import api from "./api/api";

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
    <div>
      {pubs.length === 0 ? "No pubs yet, please add some!" : pubs.map((pub) => (
        <div key={pub.id}>
          <Link to={`/pubs/${pub.id}`}>
            {pub.name} {pub.openHours} {pub.rating} {pub.address}
          </Link>
        </div>
      ))}
    </div>
  );
};

export default PubList;
