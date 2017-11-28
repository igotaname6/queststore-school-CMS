ALTER TABLE artifacts RENAME TO artifacts_temp;

CREATE TABLE artifacts (
  'id' INTEGER PRIMARY KEY AUTOINCREMENT,
  'name' varchar(255),
  'description' varchar(255),
  'cost' int,
  'is_group' boolean,
  'is_used' boolean
);

INSERT INTO artifacts
  SELECT
    id, name, description, cost, is_group, is_used
  FROM
    artifacts_temp;

DROP TABLE artifacts_temp;