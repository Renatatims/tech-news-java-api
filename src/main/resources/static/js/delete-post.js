// Function to Delete Posts - async function
async function deleteFormHandler(event) {
  event.preventDefault();

// parse the id via the window location
  const id = window.location.toString().split('/')[
    window.location.toString().split('/').length - 1
  ];

//Method: DELETE by post by id
  const response = await fetch(`/api/posts/${id}`, {
    method: 'DELETE'
  });

  if (response.ok) {
    document.location.replace('/dashboard/')
  } else {
    alert(response.statusText);
  }
}

//Event Listener - added to delete button
document.querySelector('.delete-post-btn').addEventListener('click', deleteFormHandler);