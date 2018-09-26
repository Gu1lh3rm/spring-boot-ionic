package com.gml.cursomc.services;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;


public class MockEmailService extends AbstractEmailService{

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Simulando envio de email...");
        LOG.info(msg.toString());
        LOG.info("Email enviado");
    }

    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOG.info("Simulando envio de email HTML...");
        LOG.info(msg.toString());
        LOG.info("Email enviado");
    }
}
