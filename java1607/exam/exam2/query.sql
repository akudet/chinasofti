select ProNo from ProOut
group by ProNo
having sum(Quantity) > 100;

select distinct c.CusNo, c.CusName, c.Tel
from customer c, ProOut p
where c.CusNo = p.CusNo
  AND p.ProNo = "P0002"
order by c.CusName desc;

select ProNo, sum(Quantity)
from ProOut
where CusNo = "C004"
  AND SaleDate like "2008%"
group by ProNo;
