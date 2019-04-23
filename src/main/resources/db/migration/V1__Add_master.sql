/***********************************************************************************************************************
**************************　years table・年度マスタテーブル **************************************
***********************************************************************************************************************/
CREATE TABLE IF NOT EXISTS `years` (
  `id`            BIGINT(20)   NOT NULL AUTO_INCREMENT            COMMENT 'レコードID',
  `value`         BIGINT(20)   NOT NULL                           COMMENT '年度',
  `delete_flag`   TINYINT(1)   NOT NULL DEFAULT '0'               COMMENT '論理削除フラグ (0: 未削除 1: 削除)',
  `updated_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
  `created_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_years_value` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='年度マスタテーブル';

/***********************************************************************************************************************
**************************　games table・試合マスタテーブル **************************************
***********************************************************************************************************************/
CREATE TABLE IF NOT EXISTS `games` (
  `id`            BIGINT(20)   NOT NULL AUTO_INCREMENT            COMMENT 'レコードID',
  `year_id`       BIGINT(20)   NOT NULL                           COMMENT '年度ID',
  `value`         BIGINT(20)   NOT NULL                           COMMENT 'x節',
  `time`          VARCHAR(45)  NOT NULL                           COMMENT 'キックオフ時間',
  `studium`       VARCHAR(45)  NOT NULL                           COMMENT '開催スタジアム',
  `team`          VARCHAR(45)  NOT NULL                           COMMENT '対戦チーム',
  `delete_flag`   TINYINT(1)   NOT NULL DEFAULT '0'               COMMENT '論理削除フラグ (0: 未削除 1: 削除)',
  `updated_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
  `created_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_games_year_id`        FOREIGN KEY (`year_id`)        REFERENCES `years` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='試合マスタテーブル';

/***********************************************************************************************************************
**************************　gates table・ゲートマスタテーブル **************************************
***********************************************************************************************************************/
CREATE TABLE IF NOT EXISTS `gates` (
  `id`            BIGINT(20)   NOT NULL AUTO_INCREMENT            COMMENT 'レコードID',
  `gate_name`     BIGINT(20)   NOT NULL                           COMMENT 'ゲート名',
  `delete_flag`   TINYINT(1)   NOT NULL DEFAULT '0'               COMMENT '論理削除フラグ (0: 未削除 1: 削除)',
  `updated_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
  `created_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gates_gate_name` (`gate_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='ゲートマスタテーブル';

