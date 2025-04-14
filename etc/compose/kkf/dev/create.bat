@echo off
docker-compose --env-file .env_dev -f ../docker-compose.yml up -d
echo on