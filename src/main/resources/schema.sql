CREATE TABLE IF NOT EXISTS task (
  id UUID NOT NULL PRIMARY KEY ,
  description VARCHAR(100) NOT NULL,
  status VARCHAR(100) NOT NULL
);