CREATE TABLE sessions(
  'uuid' text PRIMARY KEY NOT NULL,
  'account_id' INTEGER NOT NULL,
    FOREIGN KEY (account_id) REFERENCES users(id));
