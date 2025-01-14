// Funkcja do aktualizacji zegara
function updateClock() {
    const now = new Date();
    const hours = now.getHours().toString().padStart(2, '0');
    const minutes = now.getMinutes().toString().padStart(2, '0');
    const seconds = now.getSeconds().toString().padStart(2, '0');
    document.getElementById('clock').innerText = `${hours}:${minutes}:${seconds}`;
}

// Zegar uruchamia się przy pierwszym załadowaniu strony i aktualizuje co sekundę
setInterval(updateClock, 1000);
updateClock();  // Wywołanie funkcji na starcie, żeby od razu pokazać czas

// Licznik odwiedzin
let visitCount = parseInt(localStorage.getItem('visitCount')) || 0; // Pobierz wartość z localStorage, jeśli jest
function updateVisitCounter() {
    visitCount++; // Zwiększamy licznik odwiedzin
    localStorage.setItem('visitCount', visitCount); // Zapisujemy liczbę odwiedzin do localStorage
    document.getElementById('visitCounter').innerText = visitCount; // Wyświetlamy na stronie
}
updateVisitCounter(); 
