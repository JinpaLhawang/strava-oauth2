package stravaoauth2;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import stravaoauth2.athletetoken.AthleteToken;
import stravaoauth2.athletetoken.AthleteTokenRepository;

// https://stackoverflow.com/questions/27864295/how-to-use-oauth2resttemplate

@RestController
@RequiredArgsConstructor
public class StravaOauth2RestController {

  private final AthleteTokenRepository athleteRepository;

  @RequestMapping("/user")
  public AthleteToken user(
      final @AuthenticationPrincipal Principal principal) {

    return athleteRepository.save(
        AthleteToken.builder()
            .accessToken(getAccessToken(principal))
            .build());
  }

  @RequestMapping("/principal")
  public Principal principal(
      @AuthenticationPrincipal Principal principal) {
    return principal;
  }

  private String getAccessToken(
      final Principal principal) {

    final OAuth2Authentication oauth2Auth = (OAuth2Authentication) principal;
    final OAuth2AuthenticationDetails oauth2AuthDetails =
        (OAuth2AuthenticationDetails) oauth2Auth.getDetails();

    return oauth2AuthDetails.getTokenValue();
  }

}
