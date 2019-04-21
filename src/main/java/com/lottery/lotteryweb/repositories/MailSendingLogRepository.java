package com.lottery.lotteryweb.repositories;

import com.lottery.lotteryweb.models.MailSendingLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailSendingLogRepository extends JpaRepository<MailSendingLog, Long> {
}
