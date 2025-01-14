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
updateClock(); 
// Licznik odwiedzin
let visitCount = parseInt(localStorage.getItem('visitCount')) || 0; // Pobierz wartość z localStorage, jeśli jest
function updateVisitCounter() {
    visitCount++; // Zwiększamy licznik odwiedzin
    localStorage.setItem('visitCount', visitCount); // Zapisujemy liczbę odwiedzin do localStorage
    document.getElementById('visitCounter').innerText = visitCount; // Wyświetlamy na stronie
}
updateVisitCounter();
// Formularz rejestracyjny
document.getElementById('registerForm').addEventListener('submit', function (e) {
    e.preventDefault();
    alert('Zarejestrowano użytkownika!');
});

// Księga gości
const guestBook = document.getElementById('guestBook');
document.getElementById('guestBookForm').addEventListener('submit', function (e) {
    e.preventDefault();
    const guestName = document.getElementById('guestName').value;
    const guestMessage = document.getElementById('guestMessage').value;

    const newEntry = document.createElement('div');
    newEntry.classList.add('my-3');
    newEntry.innerHTML = `<strong>${guestName}:</strong> ${guestMessage}`;
    guestBook.appendChild(newEntry);

    // Reset formularza
    document.getElementById('guestBookForm').reset();
});

// Kalkulator prędkości wiatru
document.getElementById('calculateBtn').addEventListener('click', function () {
    const windSpeed = document.getElementById('windSpeedInput').value;
    if (windSpeed) {
        const result = windSpeed * 0.277778; // Przekształcenie km/h na m/s
        document.getElementById('windSpeedOutput').innerText = `Prędkość wiatru: ${result.toFixed(2)} m/s`;
    } else {
        document.getElementById('windSpeedOutput').innerText = 'Proszę wprowadzić prędkość wiatru';
    }
});
