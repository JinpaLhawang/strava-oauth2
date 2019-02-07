package stravaoauth2.athletetoken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteTokenRepository
    extends JpaRepository<AthleteToken, Long> {

}
