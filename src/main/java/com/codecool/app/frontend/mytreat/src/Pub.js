import { useParams } from "react-router-dom";
import React, { useState, useEffect } from "react";
import api from "./api/api";

const Pub = () => {
  const [pubs, setPubs] = useState([]);

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

  const { pubId } = useParams();
  const pub = pubs.find((pub) => pub.id.toString() === pubId);
  return (
    <div>
      <p>{pub.name}</p>
      <p>{pub.openHours}</p>
      <p>{pub.address}</p>
      <p>{pub.rating}</p>
    </div>
  );
};

export default Pub;
