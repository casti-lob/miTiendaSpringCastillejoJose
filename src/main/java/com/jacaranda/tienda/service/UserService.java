package com.jacaranda.tienda.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jacaranda.tienda.model.User;
import com.jacaranda.tienda.model.UserException;
import com.jacaranda.tienda.repository.UserRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import net.bytebuddy.utility.RandomString;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	@Autowired
	private JavaMailSender mailSender;

	public User getUser(String user) {
		return repository.findById(user).orElse(null);
	}

	public List<User> getUsers() {
		return repository.findAll();
	}

	public User addUser(User u) {
		return repository.save(u);
	}

	public void deleteUser(User u) {
		repository.delete(u);
	}

	public User updateUser(User u) {
		if (getUser(u.getUser()) != null) {
			return repository.save(u);
		} else {
			return null;
		}
	}

	public boolean checkExist(User s) {
		boolean resultado = false;
		// Comprueba que no existe el nombre del usuario
		User checkUser = repository.findById(s.getUser()).orElse(null);
		// Comprueba que no existe el email en la base de datos
		List<User> checkEmail = repository.findByEmail(s.getEmail());
		if (checkUser == null && checkEmail.size() == 0) {
			resultado = true;
		}
		return resultado;
	}

	public void add(User s, String siteURL) throws UnsupportedEncodingException, MessagingException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(s.getPassword());
		try {
			s.setPassword(encodedPassword);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Genera una cadena aleatoria que guarderemos en el código
		// de verificación y que le enviaremos al usuario para saber
		// que es él.
		String randomCode = RandomString.make(64);
		s.setVerification_code(randomCode);
		;
		s.setEnabled(false);
		s.setRole("USER");
		repository.save(s);
		sendVerificationEmail(s, siteURL);
	}

	private void sendVerificationEmail(User user, String siteURL)
			throws MessagingException, UnsupportedEncodingException {
		String toAddress = user.getEmail();
		String fromAddress = "romandos962m@gmail.com";
		String senderName = "Tu Fishing de Confianza";
		String subject = "Please verify your registration";
		String content = "Dear [[user]],<br>" + "Please click the link below to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\"target=\"_self\">VERIFY</a></h3>" + "Thank you,<br>" + "Your company name.";
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);
		content = content.replace("[[user]]", user.getUser());
		String verifyURL = siteURL + "/verify?code=" + user.getVerification_code();
		content = content.replace("[[URL]]", verifyURL);
		helper.setText(content, true);
		mailSender.send(message);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findById(username).orElse(null);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}
}
