/***********************************************************************************************************************
**************************　users table・ユーザーテーブル **************************************
***********************************************************************************************************************/
CREATE TABLE IF NOT EXISTS `users` (
  `id`            BIGINT(20)   NOT NULL AUTO_INCREMENT            COMMENT 'レコードID',
  `gate_name`     BIGINT(20)   NOT NULL                           COMMENT 'ゲート名',
  `delete_flag`   TINYINT(1)   NOT NULL DEFAULT '0'               COMMENT '論理削除フラグ (0: 未削除 1: 削除)',
  `updated_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日時',
  `created_at`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gates_gate_name` (`gate_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='ユーザーテーブル';

