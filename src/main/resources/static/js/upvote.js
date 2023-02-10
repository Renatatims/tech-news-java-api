//Click Handler Event - async function
async function upvoteClickHandler(event) {
  event.preventDefault();
// parse the id via the window location
  const id = window.location.toString().split('/')[
    window.location.toString().split('/').length - 1
  ];

//id is sent as a PUT request
  const response = await fetch('/posts/upvote', {
    method: 'PUT',
    body: JSON.stringify({
        postId: id
    }),
    headers: {
      'Content-Type': 'application/json'
    }
  });

  if (response.ok) {
    document.location.reload();
  } else {
    alert(response.statusText);
  }
}
// attach event listener to the upvote button
document.querySelector('.upvote-btn').addEventListener('click', upvoteClickHandler);