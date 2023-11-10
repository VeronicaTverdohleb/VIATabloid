import React, { useState, useEffect } from "react";
import axios from "axios";

const NewsList = () => {
  const [stories, setStories] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/stories")
      .then((response) => {
        setStories(response.data);
      })
      .catch((error) => console.error("There was an error!", error));
  }, []);

  return (
    <div>
      <h2>Stories</h2>
      {stories.map((story) => (
        <div key={story.id}>
          <h3>{story.name}</h3>
          <p>{story.description}</p>
          <p>Department: {story.department}</p>
        </div>
      ))}
    </div>
  );
};

export default NewsList;
