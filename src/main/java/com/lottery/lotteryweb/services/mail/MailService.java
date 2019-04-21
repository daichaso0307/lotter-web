package com.lottery.lotteryweb.services.mail;

import com.lottery.lotteryweb.common.enums.MailSendingLogStatus;
import com.lottery.lotteryweb.config.AppPropertiesConfig;
import com.lottery.lotteryweb.models.Entry;
import com.lottery.lotteryweb.models.MailSendingLog;
import com.lottery.lotteryweb.repositories.MailSendingLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.transaction.annotation.Transactional;

import static com.lottery.lotteryweb.common.constants.Auth.REG_CONFIRMATION_PATH;

public class MailService implements IMailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    @Autowired JavaMailSender javaMailSender;
    @Autowired MailSendingLogRepository mailSendingLogRepository;
    @Autowired AppPropertiesConfig appProperties;
    @Autowired MailContentProcessorService mailContentProcessorService;

    @Override
    public void sendEntryConfirmation(final Entry entry) {
        sendMail(
                mimeMessagePreparator(
                        entry.getEmail(),
                        appProperties.getRegistrationConfirmationSubject(),
                        mailContentProcessorService.registrationConfirmationBuilder(
                                appProperties.getAppHostUrl() + REG_CONFIRMATION_PATH,
                                entry.getUserName())),
                entry.getPassId()
        );
    }

    private MimeMessagePreparator mimeMessagePreparator(
            final String toEmail, final String subject, final String content) {

        if (toEmail == null || toEmail.trim().length() == 0) {
            return null;
        }

        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(appProperties.getFromNoReply());
            messageHelper.setTo(toEmail);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);
        };
    }

    @Transactional
    public void sendMail(final MimeMessagePreparator mimeMessagePreparator, final String passId) {

        if (mimeMessagePreparator == null) {
            return;
        }

        MailSendingLog mailSendingLog = new MailSendingLog();

        mailSendingLog.setPassId(passId);
        mailSendingLog.setStatus(MailSendingLogStatus.SENT.getValue());

        try {
            javaMailSender.send(mimeMessagePreparator);
            LOGGER.info(MailSendingLogStatus.SENT.getDescription());
        } catch (MailException exception) {
            LOGGER.error(MailSendingLogStatus.FAILED.getDescription(), exception);
            mailSendingLog.setStatus(MailSendingLogStatus.FAILED.getValue());
        } finally {
            mailSendingLogRepository.save(mailSendingLog);
        }
    }
}
