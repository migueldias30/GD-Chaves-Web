function setBaseForIncludes(basePath) {
  let base = document.createElement('base');
  base.href = basePath;
  document.head.appendChild(base);
}

async function loadHTML(selector, url) {
  const response = await fetch(url);
  if (response.ok) {
    const text = await response.text();
    document.querySelector(selector).innerHTML = text;
  }
}

window.addEventListener('DOMContentLoaded', () => {
  setBaseForIncludes('../../'); // base path para header.html e imagens
  loadHTML('header', '../../header.html');
  loadHTML('footer', '../../footer.html');
});

