SELECT DISTINCT job from emp;

SELECT ename, (sal + comm) * 12 from emp where comm IS NOT NULL
UNION
SELECT ename, sal * 12 from emp;

SELECT * FROM emp where job != "CLERK";

SELECT * FROM emp where ename like "_A%";

SELECT * FROM emp where ename like "%A%";

SELECT * FROM emp where ename not like "%A%";

SELECT * FROM emp order by sal desc;

SELECT * FROM emp order by sal, hiredate;

SELECT * FROM emp WHERE deptno=30;

SELECT * FROM emp WHERE deptno=10 and job = "MANAGER"
UNION
SELECT * FROM emp where deptno=20 and job = "CLERK";

SELECT DISTINCT job FROM emp where comm IS NOT NULL;

SELECT * FROM emp where comm IS NULL or comm < 100;

/* 15 */
SELECT CONCAT(UPPER(LEFT(ename, 1)), LOWER(SUBSTRING(ename, 2))) as CapName FROM emp;

/* 16 */
SELECT * FROM emp group by ename having CHAR_LENGTH(ename) = 5;

/* 17 */

SELECT MID(ename, 1, 3) FROM emp;

SELECT * FROM emp WHERE DATEDIFF(CURDATE(), DATE_ADD(hiredate, INTERVAL 10 YEAR)) > 0;

SELECT * FROM emp order by ename;

SELECT DATEDIFF(CURDATE(), hiredate) AS DAYS from emp;
