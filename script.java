// Licznik odwiedzin
function updateVisitCounter() {
    let visitCount = localStorage.getItem("visitCount");
    if (!visitCount) {
        visitCount = 0;
    }
    visitCount++;
    localStorage.setItem("visitCount", visitCount);
    document.getElementById("counter").textContent = visitCount;
}

// Zegar internetowy
function updateClock() {
    const now = new Date();
    const formattedTime = now.toLocaleTimeString();
    document.getElementById("current-time").textContent = formattedTime;
}

// Funkcja inicjalizacyjna
function init() {
    updateVisitCounter();
    setInterval(updateClock, 1000); // Aktualizacja zegara co sekundę
}

document.addEventListener("DOMContentLoaded", init);