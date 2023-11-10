// src/components/AddStory.js
import React, { useState } from "react";
import axios from "axios";

const AddStory = () => {
  const [story, setStory] = useState({
    id: "",
    name: "",
    description: "",
    department: "",
  });
  const handleChange = (e) => {
    setStory({ ...story, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8080/stories", story)
      .then((response) => {
        console.log(response);
      })
      .catch((error) => console.error("There was an error!", error));
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>ID:</label>
      <input type="text" name="id" value={story.id} onChange={handleChange} />

      <label>Name:</label>
      <input
        type="text"
        name="name"
        value={story.name}
        onChange={handleChange}
      />

      <label>Description:</label>
      <input
        type="text"
        name="description"
        value={story.description}
        onChange={handleChange}
      />

      <label>Department:</label>
      <input
        type="text"
        name="department"
        value={story.department}
        onChange={handleChange}
      />

      <button type="submit">Add Story</button>
    </form>
  );
};

export default AddStory;
