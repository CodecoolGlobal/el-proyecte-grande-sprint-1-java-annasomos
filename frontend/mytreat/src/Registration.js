import React from "react";
import api from "./api/api";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { useEffect } from "react";

const Registration = () => {
  const [users, setUsers] = useState([]);
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await api.get("/users");
        setUsers(response.data);
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

    fetchUsers();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    //const id = users.length ? users[users.length - 1].id + 1 : 1;
    const newUser = {
      firstName: firstName,
      lastName: lastName,
      userName: userName,
      password: password,
      email: email
    };
    try {
      const response = await api.post("/user/new", newUser);
      const allUsers = [...users, response.data];
      setUsers(allUsers);
      setFirstName("");
      setLastName("");
      setUserName("");
      setPassword("");
      setEmail("");
      navigate("/");
    } catch (err) {
      console.log(`Error: ${err.message}`);
    }
  };
  return (
    <>
      <h2>Add new user</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="firstName">Firstname:</label>
        <input
          id="firstName"
          type="text"
          required
          value={firstName}
          onChange={(e) => setFirstName(e.target.value)}
        />
        <label htmlFor="lastName">Lastname:</label>
        <input
            id="lastName"
            type="text"
            required
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
        />
        <label htmlFor="userName">Username:</label>
        <input
            id="userName"
            type="text"
            required
            value={userName}
            onChange={(e) => setUserName(e.target.value)}
        />
        <label htmlFor="password">Password:</label>
        <input
            id="password"
            type="password"
            required
            value={password}
            onChange={(e) => setPassword(e.target.value)}
        />
        <label htmlFor="email">Email:</label>
        <input
          id="email"
          type="text"
          required
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <button type="submit">Submit</button>
      </form>
    </>
  );
};

export default Registration;
