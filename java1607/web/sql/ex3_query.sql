/*3.查询student表的所有记录*/
SELECT * FROM student;

/*4.查询student表的第2条到4条记录*/
SELECT * FROM student LIMIT 1, 3;

/*5.从student表查询所有学生的学号（id）、姓名（name）和院系（department）的信息*/
SELECT Id, Name, Department FROM student;

/*6.从student表中查询计算机系和英语系的学生的信息*/
SELECT * FROM student WHERE Department = "计算机系" or Department = "英语系";

/*7.从student表中查询年龄18~22岁的学生信息*/
SELECT * FROM student
WHERE (EXTRACT(YEAR FROM CURDATE()) - Birth) >= 18
  AND (EXTRACT(YEAR FROM CURDATE()) - Birth) <= 22;

/*8.从student表中查询每个院系有多少人*/
SELECT Department , COUNT(*) FROM student GROUP BY Department;

/*9.从score表中查询每个科目的最高分*/
SELECT C_name, MAX(Grade) FROM score GROUP BY C_name;

/*10.查询李四的考试科目（c_name）和考试成绩（grade）*/
SELECT Name, C_name, Grade FROM student, score
WHERE Name = "李四" AND Stu_id = student.Id;

/*11.查询所有学生的信息和考试信息*/
SELECT Name, C_name, Grade FROM student, score
WHERE Stu_id = student.Id;

/*12.计算每个学生的总成绩*/
SELECT s.Name, SUM(c.Grade) AS Total_Grade FROM student s, score c
WHERE c.Stu_id = s.id
GROUP BY s.Id;

/*13.计算每个考试科目的平均成绩*/
SELECT C_name, AVG(Grade) FROM score
GROUP BY C_name;

/*14.查询计算机成绩低于95的学生信息*/
SELECT Name, C_name, Grade FROM student
JOIN score ON
  student.Id = score.Stu_id
  AND C_name = "计算机" AND Grade < 95;

/*15.查询同时参加计算机和英语考试的学生的信息*/
SELECT s.Name FROM student s, score c1, score c2
WHERE s.Id = c1.Stu_id AND c1.Stu_id = c2.Stu_id
  AND c1.C_name="计算机" AND c2.C_name="英语";

/*16.将计算机考试成绩按从高到低进行排序*/
SELECT C_name, Grade FROM score
WHERE C_name="计算机"
ORDER BY Grade DESC;

/*17.从student表和score表中查询出学生的学号，然后合并查询结果*/
SELECT student.Id FROM student
UNION
SELECT score.Stu_id FROM score;
 
/*18.查询姓张或者姓王的同学的姓名、院系和考试科目及成绩*/
SELECT Name, Department, C_name, Grade FROM student, score
WHERE student.Id = score.Stu_id AND (Name like "王%" OR Name LIKE "张%");

/*19.查询都是湖南的学生的姓名、年龄、院系和考试科目及成绩*/
SELECT Name, EXTRACT(YEAR FROM CURDATE()) - Birth AS Age, Department, Grade
FROM student, score
WHERE student.Id = score.Stu_id;
