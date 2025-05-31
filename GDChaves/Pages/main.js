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

  // Reativar os listeners só depois do header estar carregado
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

});

// Adicione esta função temporária se não estiver definida em outro lugar
function filtrarJogos(tipo) {
  // Implemente a lógica de filtragem aqui
  console.warn('filtrarJogos não está implementado. Tipo:', tipo);
}


