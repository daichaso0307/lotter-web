/***********************************************************************************************************************
**************************　entries table・抽選申し込みテーブル **************************************
***********************************************************************************************************************/
CREATE TABLE IF NOT EXISTS `entries` (
  `id`            BIGINT(20)    NOT NULL AUTO_INCREMENT            COMMENT 'レコードID',
  `year_id`       BIGINT(20)    NOT NULL                           COMMENT '年度ID',
  `game_id`       BIGINT(20)    NOT NULL                           COMMENT 'ゲームID',
  `gate_id`       BIGINT(20)    NOT NULL                           COMMENT 'ゲートID',
  `pass_id`       VARCHAR(20)   NOT NULL                           COMMENT 'シーチケID',
  `person`        INT           NOT NULL                           COMMENT '人数',
  `user_name`     VARCHAR(20)   NOT NULL                           COMMENT 'ユーザ名',
  `user_kana`     VARCHAR(20)   NOT NULL                           COMMENT 'ユーザ名カナ',
  `email`         VARCHAR(20)   NOT NULL                           COMMENT 'メールアドレス',
  `delete_flag`   TINYINT(1)    NOT NULL DEFAULT '0'               COMMENT '論理削除フラグ (0: 未削除 1: 削除)',
  `updated_at`    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
  `created_at`    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_games_year_id`        FOREIGN KEY (`year_id`)        REFERENCES `years` (`id`),
  CONSTRAINT `FK_games_game_id`        FOREIGN KEY (`game_id`)        REFERENCES `games` (`id`),
  CONSTRAINT `FK_games_gate_id`        FOREIGN KEY (`gate_id`)        REFERENCES `gates` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='抽選申し込みテーブル';

