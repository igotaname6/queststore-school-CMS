CREATE TABLE sessions(
  'session_id' text PRIMARY KEY NOT NULL,
  'user_id' INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id));
