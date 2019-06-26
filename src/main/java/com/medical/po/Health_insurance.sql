-- auto Generated on 2019-06-06
-- DROP TABLE IF EXISTS health_insurance;
CREATE TABLE health_insurance(
	hi_id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'hi_id',
	student_no VARCHAR (30) NOT NULL DEFAULT '' COMMENT 'student_no',
	name VARCHAR (30) NOT NULL DEFAULT '' COMMENT 'name',
	dept VARCHAR (30) NOT NULL DEFAULT '' COMMENT 'dept',
	grade VARCHAR (30) NOT NULL DEFAULT '' COMMENT 'grade',
	major VARCHAR (30) NOT NULL DEFAULT '' COMMENT 'major',
	glass VARCHAR (30) NOT NULL DEFAULT '' COMMENT 'glass',
	card_no VARCHAR (30) NOT NULL DEFAULT '' COMMENT 'card_no',
	id_no VARCHAR (30) NOT NULL DEFAULT '' COMMENT 'id_no',
	mobile VARCHAR (30) NOT NULL DEFAULT '' COMMENT 'mobile',
	start_date VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'start_date',
	end_date VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'end_date',
	hi_status VARCHAR (20) NOT NULL DEFAULT '' COMMENT 'hi_status',
	PRIMARY KEY (hi_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'health_insurance';
