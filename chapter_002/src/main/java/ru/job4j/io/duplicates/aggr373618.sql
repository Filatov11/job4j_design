create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

truncate table devices cascade;
INSERT INTO devices VALUEs
(501, 'ThinkSystem ST50', 100.32), 
(502, 'SuperMicro SSG', 117.22), 
(503, 'iDataPlex', 101.24), 
(504, 'Synology DS920', 511.22), 
(505, 'IBM Power Systems', 6011.22), 
(506, 'Quad-Core Xeon Processor', 1111.22), 
(507, 'BladeCenter', 10235.56);


create table people(
    id serial primary key,
    name varchar(255)
);

truncate table people cascade
INSERT INTO people VALUEs
(1, 'Clark'), 
(2, 'Adams'), 
(3, 'James'), 
(4, 'Martin'), 
(5, 'Allen'), 
(6, 'Blake');

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

truncate table devices_people cascade

INSERT INTO devices_people VALUEs
(1, 501, 1), 
(2, 502, 2), 
(3, 507, 3), 
(4, 505, 4), 
(5, 501, 5), 
(6, 504, 6), 
(7, 503, 1), 
(8, 506, 2), 
(9, 501, 3), 
(10, 502, 4), 
(11, 507, 4), 
(12, 505, 3), 
(13, 502, 6), 
(14, 501, 4);


select avg(price) from devices;

select p.name as  username  , avg(d.price) as AVG_price 
from people p , devices d, devices_people dp 
where p.id =  dp.people_id 
and d.id =  dp.device_id
group by p.name  

select p.name as  username  , avg(d.price) as AVG_price 
from people p , devices d, devices_people dp 
where p.id =  dp.people_id 
and d.id =  dp.device_id
group by p.name  
having avg(d.price) > 5000
