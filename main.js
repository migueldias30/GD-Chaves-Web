async function loadHTML(selector, url) {
  const response = await fetch(url);
  if (response.ok) {
    const text = await response.text();
    document.querySelector(selector).innerHTML = text;

    if (selector === 'header') {
      const logo = document.getElementById("logo-link");
      if (logo) {
        logo.addEventListener("click", function (e) {
          e.preventDefault();
          window.scrollTo({
            top: 0,
            behavior: "smooth"
          });
        });
      }
    }
  }
  document.addEventListener("DOMContentLoaded", () => {
    const hamburgerBtn = document.getElementById("hamburgerBtn");
    const mobileMenu = document.getElementById("mobileMenu");
    const userBtn = document.getElementById("userBtn");
    const userMenuMobile = document.getElementById("userMenuMobile");

    if (hamburgerBtn && mobileMenu) {
      hamburgerBtn.addEventListener("click", () => {
        mobileMenu.classList.toggle("active");
      });
    }

    if (userBtn && userMenuMobile) {
      userBtn.addEventListener("click", () => {
        userMenuMobile.classList.toggle("active");
      });
    }
  });
  function toggleSubMenu(menuId) {
    const submenu = document.getElementById(menuId);
    if (submenu) {
      submenu.classList.toggle("active");
    }
  }


}
window.addEventListener('DOMContentLoaded', () => {
  loadHTML('header', 'header.html');
  loadHTML('footer', 'footer.html');
});

