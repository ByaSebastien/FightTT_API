package be.paquya.fighttt_api.utils;

import be.paquya.fighttt_api.configs.JwtConfig;
import be.paquya.fighttt_api.models.entities.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {

    private final JwtConfig config;

    private final JwtParser parser;

    private final JwtBuilder builder;

    public JwtUtils(JwtConfig config){
        this.config = config;
        this.parser = Jwts.parserBuilder().setSigningKey(config.secretKey).build();
        this.builder = Jwts.builder().signWith(config.secretKey);
    }

    public String generateToken(Member member){
        return builder
                .claim("id",member.getId())
                .claim("username",member.getUsername())
                .claim("roles",member.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + config.expireAt * 1000L))
                .compact();
    }

    public Claims getClaims(String token){
        return parser.parseClaimsJws(token).getBody();
    }

    public Integer getId(String token){
        return getClaims(token).get("id", Integer.class);
    }

    public String getUsername(String token){
        return getClaims(token).get("username", String.class);
    }

    public List<String> getRoles(String token){
        return getClaims(token).get("roles", List.class);
    }

    public boolean isValid(String token){
        Claims claims = getClaims(token);
        Date now = new Date();
        return getRoles(token) != null && now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }
}
