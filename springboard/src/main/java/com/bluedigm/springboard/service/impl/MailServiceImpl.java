package com.bluedigm.springboard.service.impl;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bluedigm.springboard.Useful;
import com.bluedigm.springboard.entity.ResetDAO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.BoardRepo;
import com.bluedigm.springboard.repository.MemberRepo;
import com.bluedigm.springboard.repository.NoteRepo;
import com.bluedigm.springboard.repository.ResetRepo;
import com.bluedigm.springboard.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	JavaMailSenderImpl jMailSender;
	@Autowired
	ResetRepo resetRepo;
	@Autowired
	BoardRepo boardRepo;
	@Autowired
	MemberRepo memberRepo;
	@Autowired
	NoteRepo noteRepo;

	@Override
	public void simpleMail(UserDAO dao) {
		logger.info(Useful.getMethodName());
		try {
			byte[] bytes = new byte[16];
			for (int j = 0; j < bytes.length; j++) {
				bytes[j] = (byte) (Math.random() * Byte.MAX_VALUE);
			}
			if (resetRepo.select(dao.getId()).isPresent()) {
				ResetDAO dao2 = new ResetDAO();
				dao2.setUserId(dao.getId());
				dao2.setCode(bytes.toString());
				resetRepo.update(dao2);
			}
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("admin@liteboard.com");
			message.setTo(dao.getEmail());
			message.setSubject("Verify Mail with SimpleMailMessage");
			message.setText(bytes.toString());
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mimeMail(UserDAO dao, List<String> pathList) {
		logger.info(Useful.getMethodName());
		try {
			byte[] bytes = new byte[16];
			for (int j = 0; j < bytes.length; j++) {
				bytes[j] = (byte) (Math.random() * Byte.MAX_VALUE);
			}
			if (resetRepo.select(dao.getId()).isPresent()) {
				ResetDAO dao2 = new ResetDAO();
				dao2.setUserId(dao.getId());
				dao2.setCode(bytes.toString());
				resetRepo.update(dao2);
			}
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("admin@liteboard.com");
			helper.setTo(dao.getEmail());
			helper.setSubject("Verify Mail with MimeMessage");
			helper.setText(bytes.toString(), true);
			for (String string : pathList) {
				String[] strings = string.split("\\");
				helper.addAttachment(strings[strings.length], new File(string));
			}
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
