/* author : Jintong Wu(akudet@qq.com) */

/* Student */
DROP TABLE IF EXISTS student;
CREATE TABLE student (
  Id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Name VARCHAR(20) NOT NULL,
  Sex VARCHAR(4),
  Birth YEAR,
  Department VARCHAR(20) NOT NULL,
  Address VARCHAR(50)
);

INSERT INTO student VALUES( 901,'张老大', '男',1985,'计算机系', '北京市海淀区');
INSERT INTO student VALUES( 902,'张老二', '男',1986,'中文系', '北京市昌平区');
INSERT INTO student VALUES( 903,'张三', '女',1990,'中文系', '湖南省永州市');
INSERT INTO student VALUES( 904,'李四', '男',1990,'英语系', '辽宁省阜新市');
INSERT INTO student VALUES( 905,'王五', '女',1991,'英语系', '福建省厦门市');
INSERT INTO student VALUES( 906,'王六', '男',1988,'计算机系', '湖南省衡阳市');

SELECT * FROM student;

/* Score */
DROP TABLE IF EXISTS score;
CREATE TABLE score (
  Id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Stu_id INT(10) NOT NULL,
  C_name VARCHAR(20),
  Grade INT(10)
);

INSERT INTO score VALUES(NULL,901, '计算机',98);
INSERT INTO score VALUES(NULL,901, '英语', 80);
INSERT INTO score VALUES(NULL,902, '计算机',65);
INSERT INTO score VALUES(NULL,902, '中文',88);
INSERT INTO score VALUES(NULL,903, '中文',95);
INSERT INTO score VALUES(NULL,904, '计算机',70);
INSERT INTO score VALUES(NULL,904, '英语',92);
INSERT INTO score VALUES(NULL,905, '英语',94);
INSERT INTO score VALUES(NULL,906, '计算机',90);
INSERT INTO score VALUES(NULL,906, '英语',85);

SELECT * FROM score;
