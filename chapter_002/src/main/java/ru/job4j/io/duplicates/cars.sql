﻿CREATE TABLE Car_Names 
( 
    ID int  PRIMARY KEY, 
    vendor char(25), 
    model VARCHAR(25), 
    description text

)

insert into Car_Names (ID,vendor,model,description) values (1, 'VAZ', '2101', 'ВАЗ-2101');
insert into Car_Names (ID,vendor,model,description) values (2, 'UAZ', '469', 'УАЗ-469');
insert into Car_Names (ID,vendor,model,description) values (3, 'Audi', 'A4', 'A4 Avant');
commit;

select * from Car_Names;

update Car_Names set model = 'RS 6' , description = 'Audi RS 6' where ID = 3;
commit;

select * from Car_Names;

delete from Car_Names where id = 1;
select * from Car_Names;

