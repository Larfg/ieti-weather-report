package main.controller.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import main.exceptions.InvalidCredentialsException;
import main.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static main.utils.Constants.*;

@RestController
@RequestMapping( "v1/auth" )
public class AuthController
{

    @Value( "${app.secret}" )
    String secret;

    @PostMapping
    public TokenDto login( )
    {
        return generateTokenDto();
    }

    private String generateToken(Date expirationDate)
    {
        return Jwts.builder()
                .claim("name", "pepe")
                .claim("email", "pepe@pepe")
                .setSubject( String.valueOf( 1))
                .claim( CLAIMS_ROLES_KEY, ADMIN_ROLE )
                .setIssuedAt(new Date() )
                .setExpiration( expirationDate )
                .signWith( SignatureAlgorithm.HS256, secret )
                .compact();
    }

    private TokenDto generateTokenDto()
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add( Calendar.MINUTE, TOKEN_DURATION_MINUTES );
        String token = generateToken(expirationDate.getTime() );
        return new TokenDto( token, expirationDate.getTime() );
    }
}