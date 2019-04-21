package com.lottery.lotteryweb.services.mail;

import com.lottery.lotteryweb.models.Entry;

public interface IMailService {
    void sendEntryConfirmation(final Entry entry);
}
