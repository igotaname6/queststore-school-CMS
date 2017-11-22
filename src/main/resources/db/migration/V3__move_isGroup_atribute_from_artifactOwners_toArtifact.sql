ALTER TABLE artifact_owners RENAME TO owners_temp;

CREATE TABLE artifact_owners (
  'id' INTEGER PRIMARY KEY AUTOINCREMENT,
  'artifact_id' int,
  'owner_id' int,
  FOREIGN KEY('artifact_id') REFERENCES artifacts('id') ON DELETE CASCADE,
  FOREIGN KEY('owner_id') REFERENCES users('id') ON DELETE CASCADE
);

INSERT INTO artifact_owners
  SELECT
    id, artifact_id, owner_id
  FROM
    owners_temp;

ALTER TABLE artifacts ADD COLUMN 'is_used' boolean;

UPDATE artifacts SET is_used =
  (SELECT owners_temp.is_used FROM owners_temp
    JOIN artifacts ON owners_temp.artifact_id = artifacts.id);

DROP TABLE owners_temp;