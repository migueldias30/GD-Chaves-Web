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

window.addEventListener('DOMContentLoaded', async () => {
  setBaseForIncludes('../../');
  await loadHTML('header', '../../header.html');
  await loadHTML('footer', '../../footer.html');

  document.getElementById("logo-link")?.addEventListener("click", function (e) {
    e.preventDefault();
    window.location.href = "../../Index.html";
  });

  document.querySelectorAll('.nav-fixtures button').forEach(button => {
    button.addEventListener('click', function () {
      document.querySelector('.nav-fixtures .active')?.classList.remove('active');
      this.classList.add('active');
      filtrarJogos(this.getAttribute('data-fixture'));
    });
  });
  const loginLink = document.getElementById("openLoginModal");
  const registerLink = document.getElementById("openRegisterModal");
  const userDropdown = document.getElementById("userDropdown");

  const userId = localStorage.getItem("userId");

  if (userId) {
    if (loginLink) loginLink.style.display = "none";
    if (registerLink) registerLink.style.display = "none";
    if (userDropdown) userDropdown.style.display = "block";
  } else {
    if (loginLink) loginLink.style.display = "inline-block";
    if (registerLink) registerLink.style.display = "inline-block";
    if (userDropdown) userDropdown.style.display = "none";
  }
});

// Adicione esta função temporária se não estiver definida em outro lugar
function filtrarJogos(tipo) {
  // Implemente a lógica de filtragem aqui
  console.warn('filtrarJogos não está implementado. Tipo:', tipo);
}


