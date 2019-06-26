-- auto Generated on 2019-06-06
-- DROP TABLE IF EXISTS roles;
CREATE TABLE roles(
	role_no INT (11) NOT NULL AUTO_INCREMENT COMMENT 'role_no',
	role_name VARCHAR (60) NOT NULL DEFAULT '' COMMENT 'role_name',
	role_desc VARCHAR (50) DEFAULT '' COMMENT 'role_desc',
	PRIMARY KEY (role_no)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'roles';
