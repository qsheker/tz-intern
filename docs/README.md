
# Weather Service

Spring Boot application for managing weather data with PostgreSQL, Nginx and Docker.

## Technologies
- Java 17, Spring Boot
- PostgreSQL
- Nginx (reverse proxy)
- Docker, Docker Compose

## Quick Start

### Requirements
- Docker
- Docker Compose

### Run the project

1. Clone the repository and change into the project folder:

```bash
git clone https://github.com/your-username/weather-service.git
cd weather-service
```

2. Build and start the containers (from the `docker` directory):

```bash
cd docker
docker-compose up -d --build
```

Stop the project:

```bash
docker-compose down
```

## Health and basic checks

1. Check application health

```bash
# Through Nginx (port 80)
curl http://localhost/api/health

# Directly to backend (port 8080)
curl http://localhost:8080/api/health
```

Expected response:

```json
{"status": "HEALTHY"}
```

2. Basic ping check

```bash
curl http://localhost/api/ping
```

Expected response: `Pong`

3. View weather data

Open in a browser:

```
http://localhost:8080/list
```

Or with curl:

```bash
curl http://localhost:8080/list
```

This will show an HTML page with a table of weather entries.

4. Add a new weather entry

```bash
curl -X POST http://localhost:8080/api/add \
	-H "Content-Type: application/json" \
	-d '{"city": "Tokyo", "temperature": 28}'
```

Expected response:

```json
{"id": 5, "city": "Tokyo", "temperature": 28}
```

## PostgreSQL connection checks

1. Via the application

The application performs a DB connectivity check automatically. If `/api/health` returns `HEALTHY`, the DB connection is OK.

2. From inside the PostgreSQL container

```bash
# Connect to the PostgreSQL container (example container name: "postgres-db")
docker exec -it postgres-db psql -U weather_user -d weather_db

# Inside psql:
weather_db=# SELECT * FROM weather;
weather_db=# \q
```

3. Check connection logs

```bash
docker-compose logs backend | grep -i "database\|postgres\|connection"
```

Note: on PowerShell use `Select-String` instead of `grep`.

## Project structure

```
weather-service/
├── src/                 # Spring Boot application
├── docker/              # Dockerfile and docker-compose.yml
├── nginx/               # Nginx configuration
└── docs/                # Documentation
```

## API Endpoints

Method | URL            | Description
------ | -------------- | -----------
GET    | `/api/health`  | Application and DB health status
GET    | `/api/ping`    | Basic ping check
GET    | `/list`        | HTML page with weather data
POST   | `/api/add`     | Add a weather entry

## PostgreSQL environment variables (defaults)

- Database: `weather_db`
- User: `weather_user`
- Password: `weather_pass`
- Port: `5432`

## CI/CD

Docker images are built automatically on each push to the `main` branch.

## What this README covers
- ✅ **How to build and run** — Docker Compose commands
- ✅ **How to verify the service** — curl examples for key endpoints
- ✅ **How to check PostgreSQL** — three verification methods
- ✅ **Example responses** — expected responses for requests
- ✅ **Project structure** — folder overview

---

If you want, I can also run `git add` / `git commit` and attempt to `git push` from this environment — let me know (note: `git push` requires repository credentials).

