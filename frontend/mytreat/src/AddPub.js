import React from "react";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "./api/api";

const AddPub = () => {
    const [pubs, setPubs] = useState([]);
    const [name, setPubName] = useState("");
    const [address, setAddress] = useState("");
    const navigate = useNavigate();

    useEffect(() => {
        const fetchPubs = async () => {
            try {
                const response = await api.get("/pubs");
                setPubs(response.data);
            }catch(err) {
                if(err.response) {
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

    const handleSubmit = async (e) => {
        e.preventDefault();
        const newPub = {
            name: name,
            address: address,
        };

        try {
            const response = await api.post("pub/new", newPub);
            const allPubs = [...pubs, response.data];
            setPubs(allPubs);
            setPubName("");
            setAddress("");
            navigate("/pubs");
        }catch(err) {
            console.log(`Error: ${err.message}`);
        }
    }

    return (
    <>
      <h2>Add new pub</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="name">Pub name:</label>
        <input
          id="name"
          type="text"
          required
          value={name}
          onChange={(e) => setPubName(e.target.value)}
        />
        <label htmlFor="address">Address:</label>
        <input
          id="address"
          type="text"
          required
          value={address}
          onChange={(e) => setAddress(e.target.value)}
        />
        <button type="submit">Submit</button>
      </form>
    </>
  );
};

export default AddPub;
