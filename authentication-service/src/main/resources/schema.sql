DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS user_orgs;

CREATE  TABLE users (
  user_name VARCHAR(100) NOT NULL ,
  password VARCHAR(100) NOT NULL ,
  enabled boolean NOT NULL ,
  PRIMARY KEY (user_name));

CREATE TABLE user_roles (
  user_role_id SERIAL,
  user_name varchar(100) NOT NULL,
  role varchar(100) NOT NULL,
  PRIMARY KEY (user_role_id));

CREATE TABLE user_orgs (
  organization_id   VARCHAR(100)  NOT NULL,
  user_name         VARCHAR(100)   NOT NULL,
  PRIMARY KEY (user_name));

INSERT INTO users(user_name,password,enabled) VALUES ('tim.wolf','a8f7d11948e656c4276ed70c333062ebf58e80d97857fc147a6e484106bcff9e', true);
INSERT INTO users(user_name,password,enabled) VALUES ('tom.hawk','ecaa80490e4ef09862a095fdd0baff856d80ad6fd9c46b6440f0c13f22e850c2', true);

INSERT INTO user_roles (user_name, role) VALUES ('tim.wolf', 'ROLE_USER');
INSERT INTO user_roles (user_name, role) VALUES ('tom.hawk', 'ROLE_ADMIN');
INSERT INTO user_roles (user_name, role) VALUES ('tom.hawk', 'ROLE_USER');

INSERT INTO user_orgs (organization_id, user_name) VALUES ('d1859f1f-4bd7-4593-8654-ea6d9a6a626e', 'tim.wolf');
INSERT INTO user_orgs (organization_id, user_name) VALUES ('42d3d4f5-9f33-42f4-8aca-b7519d6af1bb', 'tom.hawk');
