/**
 * 
 */
 fetch('Navigation.html')
      .then(response => response.text())
      .then(data => {
        document.getElementById('navigation-placeholder').innerHTML = data;
      })
      .catch(error => {
        console.error('Error fetching navigation: ', error);
      });