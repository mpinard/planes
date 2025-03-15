-- liquibase formatted sql

-- changeset pinardm:db-changelog-1.0.0.sql logicalFilePath:file_1.0.0
CREATE TABLE `airport`
(
    `id`            VARCHAR(36) NOT NULL PRIMARY KEY,
    `name`          VARCHAR(36) NOT NULL,
    `country`       VARCHAR(36) NOT NULL,
    `continent`     VARCHAR(36) NOT NULL,
    `airport_class` TINYINT NOT NULL,
    `population`    INT NOT NULL,
    `latitude`      INT NOT NULL,
    `longitude`     INT NOT NULL,
    `open`          TINYINT NOT NULL DEFAULT 0,
    `created_by`    VARCHAR(36) NOT NULL DEFAULT 'SYS',
    `created_on`    TIMESTAMP NOT NULL DEFAULT current_timestamp,
    `modified_by`   VARCHAR(36) NULL,
    `modified_on`   TIMESTAMP NULL ON UPDATE current_timestamp
);

