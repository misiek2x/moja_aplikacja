<?php
// Połączenie z bazą danych
$host = "localhost";
$dbname = "portal_edukacyjny";
$username = "root";
$password = "";

try {
    $conn = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Błąd połączenia: " . $e->getMessage());
}

// Sprawdzanie danych przesłanych przez formularz
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = filter_input(INPUT_POST, 'email', FILTER_VALIDATE_EMAIL);
    $password = $_POST['password'];
    $confirm_password = $_POST['confirm_password'];

    if (!$email) {
        echo "Nieprawidłowy adres e-mail.";
        exit;
    }

    if ($password !== $confirm_password) {
        echo "Hasła nie są takie same.";
        exit;
    }

    // Hashowanie hasła
    $hashed_password = password_hash($password, PASSWORD_DEFAULT);

    // Sprawdzanie, czy użytkownik już istnieje
    $stmt = $conn->prepare("SELECT COUNT(*) FROM users WHERE email = :email");
    $stmt->execute(['email' => $email]);
    if ($stmt->fetchColumn() > 0) {
        echo "Ten e-mail jest już zarejestrowany.";
        exit;
    }

    // Wstawianie użytkownika do bazy danych
    $stmt = $conn->prepare("INSERT INTO users (email, password) VALUES (:email, :password)");
    $stmt->execute([
        'email' => $email,
        'password' => $hashed_password,
    ]);

    echo "Rejestracja zakończona sukcesem!";
}
?>
