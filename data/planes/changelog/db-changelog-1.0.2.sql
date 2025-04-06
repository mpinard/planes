-- liquibase formatted sql

-- changeset mpinard:db-changelog-1.0.2.sql logicalFilePath:file_1.0.2


INSERT INTO `airport` (id, name, country, continent, airport_class, population, latitude, longitude, open)
VALUES
    (UUID(), 'Barcelona', 'Spain', 'Europe', 2, 1620343, 5740, 3808, 0),
    (UUID(), 'Berlin', 'Germany', 'Europe', 2, 3769495, 6112, 3324, 1),
    (UUID(), 'Brussels', 'Belgium', 'Europe', 1, 1222637, 5816, 3412, 1),
    (UUID(), 'Munich', 'Germany', 'Europe', 1, 1488222, 6028, 3512, 1);