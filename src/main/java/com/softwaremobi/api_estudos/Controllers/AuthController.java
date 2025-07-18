package com.softwaremobi.api_estudos.Controllers;

import com.softwaremobi.api_estudos.DTO.ResponseDTO;
import com.softwaremobi.api_estudos.DTO.ResponseLoginDTO;
import com.softwaremobi.api_estudos.DTO.UserRegisterDTO;
import com.softwaremobi.api_estudos.Mappers.UserMapper;
import com.softwaremobi.api_estudos.Models.UserModel;
import com.softwaremobi.api_estudos.Repositories.UserRepository;
import com.softwaremobi.api_estudos.Services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseLoginDTO> login(@RequestBody @Valid UserRegisterDTO userRegisterDTO) throws Exception {
        var usernamePassword = new UsernamePasswordAuthenticationToken(userRegisterDTO.getUsername(), userRegisterDTO.getPassword());
        var autenticacao = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.gerarToken((UserModel) autenticacao.getPrincipal());
        UserModel userModel = (UserModel) userRepository.findByUsername(userRegisterDTO.getUsername());
        ResponseLoginDTO response = new ResponseLoginDTO(false,"Login efetuado com sucesso!!!",token,userModel);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseLoginDTO> registroUser(@RequestBody @Valid UserRegisterDTO userRegisterDTO) throws Exception{
        if(userRepository.findByUsername(userRegisterDTO.getUsername())==null){
            var passwordEncoder = new BCryptPasswordEncoder().encode(userRegisterDTO.getPassword());
            UserModel userModel = userMapper.toModel(userRegisterDTO);
            userModel.setPassword(passwordEncoder);
            userRepository.save(userModel);
            var token = tokenService.gerarToken(userModel);
            ResponseLoginDTO response = new ResponseLoginDTO(false,"Registro efetuado com sucesso!!!",token, userModel);
            return ResponseEntity.ok(response);
        }
        ResponseLoginDTO badResponse = new ResponseLoginDTO(true,"Username em uso",null,null);
        return ResponseEntity.status(400).body(badResponse);
    }
}
