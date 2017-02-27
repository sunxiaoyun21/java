#创建视图
CREATE VIEW v_school AS
SELECT *FROM school WHERE tel=123

SELECT* FROM v_school

CREATE VIEW v_school_1 AS
SELECT * FROM school GROUP BY school DESC

SELECT *FROM v_school_1 GROUP BY id DESC
#删除视图
DROP VIEW v_school_1

#创建存储过程
DELIMITER//
CREATE PROCEDURE procedureavg()
BEGIN
SELECT *FROM school;
END//
DELIMITER
CALL 

DELIMITER//
CREATE PROCEDURE school_1(IN school VARCHAR(50),IN tel CHAR(11))
BEGIN
INSERT INTO school(school,tel)VALUES(school,tel);
END//
DELIMITER;

CALL school_1("焦大",2345)

DELIMITER//
CREATE PROCEDURE school_2(OUT ade INT)
BEGIN
SELECT MAX(age)INTO ade FROM `user`;
END//
DELIMITER;

CALL school_2(@ade);
SELECT @ade


DELIMITER//
CREATE PROCEDURE school_3(OUT mx INT ,OUT mn INT)
BEGIN
SELECT MAX(age) INTO mx FROM `user`;
SELECT MIN(age) INTO mn FROM `user`;
END//
DELIMITER;

CALL school_3(@mx,@mn);
SELECT @mx,@mn

#删除存储过程
DROP PROCEDURE procedureavg

#创建触发器的insert
CREATE TRIGGER t_user_1
AFTER INSERT ON school
FOR EACH ROW
INSERT INTO login(username,`password`) VALUES(new.school,new.tel)

INSERT INTO school(school,tel) VALUES("sxy","2345");

#创建触发器的delete
DELIMITER//
CREATE TRIGGER t_user 
AFTER DELETE ON school
FOR EACH ROW
BEGIN
DELETE FROM login WHERE id=old.id;
END//
DELIMITER

DELETE FROM school WHERE id=2

DELIMITER//
CREATE TRIGGER t_user_2
BEFORE DELETE ON school
FOR EACH ROW
BEGIN
INSERT INTO login(username,`password`) VALUES(old.school,old.tel);
END//
DELIMITER;

DELETE FROM school WHERE id=11
#创建触发器的update
DELIMITER//
CREATE TRIGGER t_user_3
BEFORE UPDATE ON school
FOR EACH ROW
BEGIN
SET new.school=UPPER(new.school);
END//
DELIMITER;

UPDATE school SET school="sxy" WHERE id=12
SELECT *FROM school
#删除触发器
DROP TRIGGER t_user 

#事物的回滚
START TRANSACTION;
DELETE FROM school WHERE id=12;

#事物的保留点
START TRANSACTION;
DELETE FROM school WHERE id=4;
SAVEPOINT s1;
DELETE FROM school WHERE id=8;
ROLLBACK TO s1;

#索引
CREATE INDEX click_num ON topic(clicknum);
SELECT clicknum FROM topic WHERE id=1





