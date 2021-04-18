DROP TABLE dfu CASCADE;

CREATE TABLE dfu(
    dfu_id BIGSERIAL PRIMARY KEY,
    dmdunit VARCHAR(50) NOT NULL,
    dmdgroup VARCHAR(50) NOT NULL,
    loc VARCHAR(50) NOT NULL,
    modelconfigset VARCHAR(50) NOT NULL,
    paramprofile VARCHAR(50)
);

DROP TABLE modelconfig CASCADE;

CREATE TABLE MODELCONFIG(
    config_id BIGSERIAL PRIMARY KEY,
    configset VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    value VARCHAR(100)
);

DROP TABLE users CASCADE;

CREATE TABLE users(
   username varchar(20) NOT NULL,
   password varchar(20) NOT NULL,
   enabled boolean NOT NULL DEFAULT FALSE,
   primary key(username)
);

DROP TABLE user_roles CASCADE;

create table user_roles (
  user_role_id SERIAL PRIMARY KEY,
  username varchar(20) NOT NULL,
  role varchar(20) NOT NULL,
  UNIQUE (username,role),
  FOREIGN KEY (username) REFERENCES users (username)
);