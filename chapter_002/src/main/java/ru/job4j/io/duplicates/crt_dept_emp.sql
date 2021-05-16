

drop table dept cascade;
create table departments(  
  deptno     integer,  
  dname      varchar(14),  
  constraint pk_dept primary key (deptno)  
)


drop table emploees cascade;
create table emploees(  
  empno    integer,  
  ename    varchar(10),  
  job      varchar(9),  
  deptno   integer,  
  constraint pk_emp primary key (empno),  
)


