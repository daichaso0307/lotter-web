/***********************************************************************************************************************
**************************　results table・抽選結果テーブル **************************************
***********************************************************************************************************************/
CREATE TABLE IF NOT EXISTS `results` (
  `id`            BIGINT(20)    NOT NULL AUTO_INCREMENT            COMMENT 'レコードID',
  `entry_id`      VARCHAR(20)   NOT NULL                           COMMENT '抽選申し込みID',
  `lottery_no`    VARCHAR(20)   NOT NULL                           COMMENT '抽選番号',
  `delete_flag`   TINYINT(1)    NOT NULL DEFAULT '0'               COMMENT '論理削除フラグ (0: 未削除 1: 削除)',
  `updated_at`    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
  `created_at`    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_results_entry_id`        FOREIGN KEY (`entry_id`)        REFERENCES `entries` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='抽選結果テーブル';

