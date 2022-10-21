import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import api from "./api/api";

const Pub = () => {
  const [pub, setPub] = useState(undefined);
  const { pubId } = useParams();

  useEffect(() => {
    const fetchPubs = async () => {
      try {
        const response = await api.get("/pubs");
        const pubs = response.data;
        const thisPub = pubs.find((pub) => pub.id.toString() === pubId);
        setPub(thisPub);
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
  }, [pubId]);

  if(pub === undefined) return "LOADING"

  return (
    <div>
      <h2>{pub.name}</h2>
      <p>{pub.openHours}</p>
      <p>{pub.address}</p>
      <p>{pub.rating}</p>
    </div>
  );
};

export default Pub;
