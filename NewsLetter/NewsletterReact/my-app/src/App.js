// src/App.js
import React, { useState, useEffect } from "react";
import StoryItem from "./components/NewsDetail";
import AddStory from "./components/AddStory";

const App = () => {
  const [stories, setStories] = useState([]);

  useEffect(() => {
    fetchStories();
  }, []);

  const fetchStories = async () => {
    try {
      const response = await fetch("http://localhost:8070/stories"); // Adjust URL as needed
      if (!response.ok) {
        throw new Error("Network response was not ok " + response.statusText);
      }
      const data = await response.json();
      setStories(data);
    } catch (error) {
      console.error(
        "There has been a problem with your fetch operation:",
        error
      );
    }
  };

  const addStory = async (story) => {
    try {
      const response = await fetch("http://localhost:8070", {
        // Adjust URL as needed
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(story),
      });
      if (!response.ok) {
        throw new Error("Network response was not ok " + response.statusText);
      }
      fetchStories();
    } catch (error) {
      console.error(
        "There has been a problem with your fetch operation:",
        error
      );
    }
  };

  const deleteStory = async (id) => {
    try {
      const response = await fetch(`http://localhost:8070/stories/${id}`, {
        // Adjust URL as needed
        method: "DELETE",
      });
      if (!response.ok) {
        throw new Error("Network response was not ok " + response.statusText);
      }
      fetchStories();
    } catch (error) {
      console.error(
        "There has been a problem with your fetch operation:",
        error
      );
    }
  };

  return (
    <div>
      <AddStory onAdd={addStory} />
      {stories.map((story) => (
        <StoryItem key={story.id} story={story} onDelete={deleteStory} />
      ))}
    </div>
  );
};

export default App;
