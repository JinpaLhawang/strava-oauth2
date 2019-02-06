# strava-oauth2

# Configuration

Navigate to [Stava My API Application](https://www.strava.com/settings/api). If required, create a new application to receive a Client ID and Secret. Use those in the run command below.

## Build and Run

```
./mvnw clean verify
./mvnw spring-boot:run -Dspring-boot.run.arguments=--security.oauth2.client.client-id=REPLACE_ME,--security.oauth2.client.client-secret=REPLACE_ME

```

1. Navigate to http://localhost:8080
1. Log in with Strava and Allow OAuth2
1. Once logged in:
  * Navigate to [Authentication Principal](http://localhost:8080/principal)
  * Navigate to [Subset of Principal](http://localhost:8080/user)
  * Navigate to [Sample Strava API Request with Access Token included in Header](http://localhost:8080/test)
