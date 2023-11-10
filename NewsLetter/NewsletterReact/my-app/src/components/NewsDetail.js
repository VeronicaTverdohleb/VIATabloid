const NewsDetail = ({ story, onDelete }) => {
  return (
    <div>
      <h3>{story.name}</h3>
      <p>{story.description}</p>
      <p>Department: {story.department}</p>
      <button onClick={() => onDelete(story.id)}>Delete</button>
    </div>
  );
};
export default NewsDetail;
