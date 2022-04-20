package com.juamber.arquitectos.controllers;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juamber.arquitectos.dto.ChangePasswordFormDTO;
import com.juamber.arquitectos.dto.EmailChangePasswordDTO;
import com.juamber.arquitectos.models.Token;
import com.juamber.arquitectos.models.Usuario;
import com.juamber.arquitectos.services.EmailService;
import com.juamber.arquitectos.services.TokenService;
import com.juamber.arquitectos.services.UsuarioService;

@RequestMapping("/change-password")
@RestController
@CrossOrigin
public class ChangePasswordController {

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	EmailService emailService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	TokenService tokenService;

	@Value("${spring.mail.username}")
	private String mailFrom;

	@Value("${mail.subject}")
	private String subject;

	@PostMapping("/send-email")
	public ResponseEntity<?> sendEmail(@RequestParam String email) {
		System.out.println("sendEmail()\nEmail:" + email);
		EmailChangePasswordDTO dto = new EmailChangePasswordDTO(email);
		System.out.println(dto);
		Optional<Usuario> usuarioOpt = usuarioService.findByEmail(email);
		Usuario user = usuarioOpt.get();
		if (usuarioOpt.isPresent()) {
			dto.setSubject(subject);
			dto.setMailFrom(mailFrom);
			dto.setMailTo(user.getEmail());
			dto.setUserName(user.getNombre());
			UUID uuid = UUID.randomUUID();
			String token = uuid.toString();
			dto.setToken(token);
			Token newToken = new Token(token, user);
			tokenService.deleteAllTokens(user.getId());
			tokenService.save(newToken);
			emailService.sendEmail(dto);
			return new ResponseEntity(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity("Correo no existe", HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/change-password")
	public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordFormDTO dto,
			BindingResult bindingResult) {
		System.out.println("changePassword()\n" + dto);
		if (!bindingResult.hasErrors()) {
			if (dto.getPassword().equals(dto.getConfirmarPassword())) {
				Optional<Token> tokenOpt = tokenService.findByToken(dto.getToken());
				if (tokenOpt.isPresent()) {
					Token token = tokenOpt.get();
					Usuario usuario = token.getUsuario();
					
					String newPassword = encoder.encode(dto.getPassword());
					usuario.setPassword(newPassword);
					tokenService.delete(token.getId());
					return new ResponseEntity("Contraseña cambiada con existo", HttpStatus.OK);

				} else {
					return new ResponseEntity("Token invalido", HttpStatus.BAD_REQUEST);
				}

			} else {
				return new ResponseEntity("Las contraseñas no coinciden", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity("Campos mal puestos", HttpStatus.BAD_REQUEST);
		}
	}
}
