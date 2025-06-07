package com.softwaremobi.api_estudos.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.softwaremobi.api_estudos.Models.UserModel;
import org.springframework.stereotype.Service;

@Service
public class TokenService{

    private String secret = "asduigasidu234234/349;;d,ad,ad*(¨*%¨2";

    public String gerarToken(UserModel userModel) throws  Exception{
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT
                    .create()
                    .withIssuer("ESTUDOS")
                    .withSubject(userModel.getUsername())
                    .sign(algorithm);
            return token;
        }
        catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar token",e);
        }
    }
    public String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT
                    .require(algorithm)
                    .withIssuer("ESTUDOS")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e){
            return null;
        }
    }

}
