package stravaoauth2;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StravaOauth2RestController {

  // https://stackoverflow.com/questions/27864295/how-to-use-oauth2resttemplate
  @RequestMapping("/user")
  public Map<String, Object> user(
      @AuthenticationPrincipal Principal principal) {

    final Map<String, Object> map = new HashMap<String, Object>();
    map.put("name", principal.getName());

    OAuth2Authentication oauth2Auth = (OAuth2Authentication) principal;
    OAuth2AuthenticationDetails oauth2AuthDetails =
        (OAuth2AuthenticationDetails) oauth2Auth.getDetails();
    map.put("token", oauth2AuthDetails.getTokenValue());

    return map;
  }

  // https://stackoverflow.com/questions/19238715/how-to-set-an-accept-header-on-spring-resttemplate-request
  @RequestMapping("/test")
  public ResponseEntity<String> test(
      @AuthenticationPrincipal Principal principal) {

    final OAuth2Authentication oauth2Auth = (OAuth2Authentication) principal;
    final OAuth2AuthenticationDetails oauth2AuthDetails =
        (OAuth2AuthenticationDetails) oauth2Auth.getDetails();

    final String url = "https://www.strava.com/api/v3/athlete/activities";
    final RestTemplate restTemplate = new RestTemplate();
    final HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(oauth2AuthDetails.getTokenValue());
    final HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

    return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
  }

  @RequestMapping("/principal")
  public Principal principal(Principal principal) {
    return principal;
  }

}
