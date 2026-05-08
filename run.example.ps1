# =========================
# RH Manager Run Script
# =========================

# Database Environment Variables
$env:DATABASE_URL = "jdbc:postgresql://localhost:5432/rh_management"
$env:DATABASE_USERNAME = "username"
$env:DATABASE_PASSWORD = "password"

# Server Port
$env:PORT = "8080"

# Optional upload directory
$env:FILE_UPLOAD_DIR = "C:\rh-manager\uploads"

Write-Host ""
Write-Host "Starting RH Manager..." -ForegroundColor Green
Write-Host "Database: $env:DATABASE_URL"
Write-Host "Port: $env:PORT"
Write-Host ""

# Run Spring Boot application
.\gradlew bootRun