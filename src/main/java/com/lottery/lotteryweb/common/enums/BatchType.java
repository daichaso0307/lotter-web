package com.lottery.lotteryweb.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum BatchType {
    ANALYTICS_DAILY_ACTION_USER(11, "analytics_daily_active_users", "日別のアクティブユーザー(DAU)"),
    ANALYTICS_DAILY_LEAVE_USER(12, "analytics_daily_leave_users", "日別の退会ユーザー（クラブ, memma）"),
    ANALYTICS_DAILY_CLUB(31, "analytics_daily_clubs", "日別のクラブ"),
    ANALYTICS_DAILY_CLUB_MEMBER(32, "analytics_daily_club_members", "日別のクラブメンバー"),
    ANALYTICS_DAILY_CLUB_ACTION(33, "analytics_daily_club_actions", "日別のクラブ（オーナー、スタッフ）のアクション"),;

    private int value;
    private String tableName;
    private String label;
    private static Map<Integer, BatchType> valueMapping;

    BatchType(final int value, final String tableName, final String label) {
        this.value = value;
        this.tableName = tableName;
        this.label = label;
    }

    public static BatchType valueOf(final int i) {
        if (valueMapping == null) {
            initializeMapping();
        }

        return valueMapping.get(i);
    }

    private static void initializeMapping() {
        valueMapping = new HashMap<>();

        for (BatchType s : values()) {
            valueMapping.put(s.value, s);
        }
    }

    public int getValue() {
        return value;
    }

    public String getTableName() {
        return tableName;
    }

    public String getLabel() {
        return label;
    }
}
