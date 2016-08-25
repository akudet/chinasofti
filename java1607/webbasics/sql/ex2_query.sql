/*1.查询不重复的职位*/
SELECT DISTINCT job from emp;

/*2.查询年薪，起别名,别名不要用单引号括起来*/
SELECT ename, (sal + comm) * 12 as YearlySalary from emp where comm IS NOT NULL
UNION
SELECT ename, sal * 12 from emp;

/*3.简单查询中可以使用"||"连接查询的字段*/
/*4.在oracle中数据时区分大小写的*/

/*5.查询不是'CLERK'的雇员信息*/
SELECT * FROM emp where job != "CLERK";

/*6.查询第二个字母为"A"的雇员*/
SELECT * FROM emp where ename like "_A%";

/*7.查询含有字母为"A"的雇员*/
SELECT * FROM emp where ename like "%A%";

/*8.查询不含有字母为"A"的雇员*/
SELECT * FROM emp where ename not like "%A%";

/*9.按照工资进行排序（降序）*/
SELECT * FROM emp order by sal desc;

/*10.先按工资排序，再按照雇佣日期排序*/
SELECT * FROM emp order by sal, hiredate;

/*11.选择部门为30的所有的员工*/
SELECT * FROM emp WHERE deptno=30;

/*12.找出部门10中的所有经理（MANAGER）和部门20的所有办事员（CLERK）的详细资料*/
SELECT * FROM emp WHERE deptno=10 and job = "MANAGER"
UNION
SELECT * FROM emp where deptno=20 and job = "CLERK";

/*13.找出收取佣金的员工的员工的不同工作*/
SELECT DISTINCT job FROM emp where comm IS NOT NULL;

/*14.找出不取佣金或者是收取佣金小于100的员工详细信息*/
SELECT * FROM emp where comm IS NULL or comm < 100;

/*15.以首字母大写的方式显示员工姓名*/
SELECT CONCAT(UPPER(LEFT(ename, 1)), LOWER(SUBSTRING(ename, 2))) as CapName FROM emp;

/*16.显示姓名正好为5个长度的所有员工*/
SELECT * FROM emp where CHAR_LENGTH(ename) = 5;

/*17.显示带有'R'的员工的详细*/
SELECT * FROM emp where mgr IS NOT NULL;

/*18.显示员工姓名的前三个字符*/
SELECT MID(ename, 1, 3) FROM emp;

/*19.列出满10年雇佣期限的员工的详细信息*/
SELECT * FROM emp WHERE DATEDIFF(CURDATE(), DATE_ADD(hiredate, INTERVAL 10 YEAR)) > 0;

/*20.显示员工的详细资料，并按姓名排序*/
SELECT * FROM emp order by ename;

/*21.对于每个员工显示其来到公司的天数*/
SELECT DATEDIFF(CURDATE(), hiredate) AS DAYS from emp;
