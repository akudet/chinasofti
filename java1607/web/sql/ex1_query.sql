/*1.查询student表的第2条到4条记录*/
select * from student_test limit 1,2;

/*2.从student表查询所有学生的学号（id）、姓名（name）和院系（department）的信息*/
select id, name, department from student_test;

/*3.从student表中查询计算机系和英语系的学生的信息*/
select * from student_test where department = '计算机系' or department = '英语系';

/*4.从student表中查询年龄18~22岁的学生信息*/
select * from student_test where birth between (2016 - 22) and (2016 - 18);

/*5.从student表中查询每个院系有多少人 */
select department , count(id) from student_test group by department;

/*6.将计算机考试成绩按从高到低进行排序*/
select * from score_test order by grade desc;

/*7.从student表和score表中查询出学生的学号，然后合并查询结果*/
select id from student_test
union
select stu_id from score_test;
/*the same as abobe*/
select DISTINCT stu.id from student_test stu, score_test sco where stu.id = sco.stu_id;

/*9.查询都是湖南的学生的姓名、年龄、院系和考试科目及成绩*/
select name, (2016 - birth), department, c_name, grade
from student_test
join score_test
on address like '湖南省%' and student_test.id=score_test.stu_id;
