2)
select * from departments d left join emploees e on d.deptno = e.deptno
select * from departments d right join emploees e on d.deptno = e.deptno
select * from departments d full join emploees e on d.deptno = e.deptno
select * from departments d cross join emploees 

3)
select dname as department_without_employers from departments d left join emploees e on d.deptno = e.deptno
where empno is null

4)
select dname as department_without_employers from departments d left join emploees e on d.deptno = e.deptno
where empno is null
union all
select dname as department_without_employers from  emploees e  right join  departments d on  d.deptno = e.deptno
where empno is null

5)
select t1.name  || ' + ' || t2.name from teens t1 cross join teens t2 
where t1.gender <> t2.gender 

