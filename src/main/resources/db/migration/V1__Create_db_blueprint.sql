CREATE TABLE users (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	varchar(255),
	`surname`	varchar(255),
	`email`	varchar(255) UNIQUE,
	`password`	varchar(255),
	`profession`	varchar(255)
);

CREATE TABLE teams (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	varchar(255)
);

CREATE TABLE artifacts (
	`id`    INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`  varchar(255),
	`description`	varchar(255),
	`cost`	varchar(255),
	`is_group`	boolean
);

CREATE TABLE quests (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	varchar(255),
	`description`	varchar(255),
	`reward`	int,
  `is_group`	boolean
);

CREATE TABLE groups (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	varchar(255)
);

CREATE TABLE artifact_owners (
    'id' INTEGER PRIMARY KEY AUTOINCREMENT,
    'artifact_id' int,
    'owner_id' int,
    'is_used' boolean,
    FOREIGN KEY('artifact_id') REFERENCES artifacts('id') ON DELETE CASCADE,
    FOREIGN KEY('owner_id') REFERENCES users('id') ON DELETE CASCADE
);

CREATE TABLE user_membership (
    'id' INTEGER PRIMARY KEY AUTOINCREMENT,
    'user_id' int,
    'group_id' int,
    FOREIGN KEY('user_id') REFERENCES users('id') ON DELETE CASCADE,
    FOREIGN KEY('group_id') REFERENCES groups('id') ON DELETE CASCADE
);

CREATE TABLE quest_achievers (
    'id' INTEGER PRIMARY KEY AUTOINCREMENT,
    'quest_id' int,
    'achiever_id' int,
    FOREIGN KEY('quest_id') REFERENCES quests('id') ON DELETE CASCADE,
    FOREIGN KEY('achiever_id') REFERENCES users('id') ON DELETE CASCADE
);

CREATE TABLE wallets (
    'id' INTEGER PRIMARY KEY AUTOINCREMENT,
    'user_id' int,
    'total_earned_coins' int,
    'available_coins' int,
    FOREIGN KEY('user_id') REFERENCES users('id') ON DELETE CASCADE
);

CREATE TABLE level_template (
    'id' INTEGER PRIMARY KEY AUTOINCREMENT,
    'level' int UNIQUE,
    'required_coins' int
);

