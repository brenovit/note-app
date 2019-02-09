package br.com.friends.noteapp.bean.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@Configuration
@EqualsAndHashCode(callSuper=false)
@ConfigurationProperties(value="mail.smtp")
public class MailSMTPProperties {
	
	private String host;
	private String port;
	private String auth;
	private String username;
	private String password;
}
