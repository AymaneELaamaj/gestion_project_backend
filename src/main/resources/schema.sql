-- Crée la table usersauth
CREATE TABLE  usersauth (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

-- Crée la table authorities
CREATE TABLE  authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES usersauth (username)
);

-- Crée l'index unique
CREATE UNIQUE INDEX IF NOT EXISTS ix_auth_username ON authorities (username, authority);
