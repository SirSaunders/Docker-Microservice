# Docker-Microservice
AOOD Docker Microservice example

Please have docker installed and run `docker-compose up` in root directory.
This will run the Dockerfile build for the ComparatorService and Docker-Sorter. Making them within a docker network.

send a list as a string to 'http://localhost:8000/sort' with the parameter words followed by a list (separated by commas) as string.
example: `http://localhost:8000/sort?words=Tyler,John,Josh,Nick` will return `John,Josh,Nick,Tyler`
