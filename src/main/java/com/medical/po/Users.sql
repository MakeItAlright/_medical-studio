-- auto Generated on 2019-06-06
-- DROP TABLE IF EXISTS users;
CREATE TABLE users(
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	username VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'username',
	password VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'password',
	name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
	userrole VARCHAR (20) NOT NULL DEFAULT '' COMMENT 'userrole',
	email VARCHAR (60) DEFAULT '' COMMENT 'email',
	telephone VARCHAR (30) DEFAULT '' COMMENT 'telephone',
	mobilephone VARCHAR (20) NOT NULL DEFAULT '' COMMENT 'mobilephone',
	work_no VARCHAR (20) NOT NULL DEFAULT '' COMMENT 'work_no',
	u_status VARCHAR (20) NOT NULL DEFAULT '' COMMENT 'u_status',
	remark VARCHAR (120) DEFAULT '' COMMENT 'remark',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'users';
