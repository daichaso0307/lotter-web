package com.lottery.lotteryweb.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum MailSendingLogStatus {

    FAILED(0, "failed", "メールの送信に失敗しました。"),
    SENT(1, "sent", "メールの送信に成功しました。");

    private int value;
    private String label;
    private String description;
    private static Map<Integer, MailSendingLogStatus> valueToMailSendingLogStatusMapping;

    MailSendingLogStatus(int value, String label, String description) {
        this.value = value;
        this.label = label;
        this.description = description;
    }

    public static MailSendingLogStatus getMailSendingLogStatus(int i) {
        if (valueToMailSendingLogStatusMapping == null) {
            initializeMapping();
        }

        return valueToMailSendingLogStatusMapping.get(i);
    }

    private static void initializeMapping() {
        valueToMailSendingLogStatusMapping = new HashMap<>();

        for (MailSendingLogStatus s : values()) {
            valueToMailSendingLogStatusMapping.put(s.value, s);
        }
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }
}
