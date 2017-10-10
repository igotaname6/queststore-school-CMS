INSERT INTO users (name, surname, email, password, profession)
VALUES ('Agnieszka', 'Koszany', 'test@mentor.com', '123', 'mentor');

INSERT INTO users (name, surname, email, password, profession)
VALUES ('Agnieszka', 'Mentor', 'test2@mentor.com', '123', 'mentor');

INSERT INTO users (name, surname, email, password, profession)
VALUES ('Marian', 'Student', 'test@student.com', '123', 'codecooler');

INSERT INTO users (name, surname, email, password, profession)
VALUES ('Karolina', 'Student', 'test2@student.com', '123', 'codecooler');

INSERT INTO users (name, surname, email, password, profession)
VALUES ('Andrzej', 'Admin', 'test@admin.com', '123', 'admin');

INSERT INTO users (name, surname, email, password, profession)
VALUES ('Stefan', 'Admin', 'test2@admin.com', '123', 'admin');

INSERT INTO groups (name)
VALUES ('KRK.2017.1');

INSERT INTO groups (name)
VALUES ('KRK.2017.2');

INSERT INTO artifacts (name, description, cost, is_group)
VALUES ('testArtifact', 'testDescription', 50, 0);

INSERT INTO artifacts (name, description, cost, is_group)
VALUES ('testTeamArtifact', 'testTeamDescription', 50, 1);

INSERT INTO quests (name, description, reward, is_group)
VALUES ('testQuest', 'testDescription', 100, 0);

INSERT INTO quests (name, description, reward, is_group)
VALUES ('testTeamQuest', 'testTeamDescription', 100, 1);

INSERT INTO teams (name)
VALUES ('testTeam');

INSERT INTO teams (name)
VALUES ('testTeam2');

INSERT INTO level_template (level, required_coins)
VALUES (1, 51);

INSERT INTO level_template (level, required_coins)
VALUES (2, 101);

INSERT INTO artifact_owners (artifact_id, owner_id, is_used)
VALUES (1, 3, 0);

INSERT INTO artifact_owners (artifact_id, owner_id, is_used)
VALUES (1, 4, 0);

INSERT INTO quest_achievers (quest_id, achiever_id)
VALUES (1, 3);

INSERT INTO quest_achievers (quest_id, achiever_id)
VALUES (1, 4);

INSERT INTO user_membership (user_id, group_id)
VALUES (1, 1);

INSERT INTO user_membership (user_id, group_id)
VALUES (2, 2);

INSERT INTO user_membership (user_id, group_id)
VALUES (3, 1);

INSERT INTO user_membership (user_id, group_id)
VALUES (4, 2);

INSERT INTO wallets (user_id, total_earned_coins, available_coins)
VALUES (3, 100, 50);

INSERT INTO wallets (user_id, total_earned_coins, available_coins)
VALUES (4, 150, 100);