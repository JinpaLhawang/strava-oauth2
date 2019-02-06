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

## References

* [Spring Guides: Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2): Sections on Simple, Click and Logout used to create project and get OAuth2 client setup.
* [How to get oauth2 token out of response to then be able to send it along in subsequent requests](https://stackoverflow.com/questions/27864295/how-to-use-oauth2resttemplate)
* [How to add token to header and do a sample Strava API request using it](https://stackoverflow.com/questions/19238715/how-to-set-an-accept-header-on-spring-resttemplate-request)
