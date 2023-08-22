package SAL.SALT.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String secretKey; // 임의의 시크릿 키

    public JwtTokenProvider(@Value("${jwt.secret.key}") String secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(String username) {
        Date now = new Date();
        // 토큰 유효 시간 (1개월)
        long validityInMilliseconds = 30L * 24 * 60 * 60 * 1000;
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(validity)
                .compact();
    }
}
