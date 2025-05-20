async function loadHTML(selector, url) {
  const response = await fetch(url);
  if (response.ok) {
    const text = await response.text();
    document.querySelector(selector).innerHTML = text;
  }
}

window.addEventListener('DOMContentLoaded', () => {
  loadHTML('header', 'header.html');
  loadHTML('footer', 'footer.html');
});
