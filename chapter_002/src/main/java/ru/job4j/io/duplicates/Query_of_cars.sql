1)

select nmr.model_name as "Car model", eg.engine_type as "Type of engine", 
           tm.type as "Type of transmission", vb.type as "Type of car body" 
from nissan_models_range nmr,  engines eg , transmissions tm, vehicle_body vb
where nmr.gearbox_id = tm.tm_id
and nmr.vehicle_body_id = vb.vb_id
and nmr.engine_id = eg.engine_id


2)

Parts not used in car_model




 
select * from  engines eg where engine_id not in ( select nmr.engine_id-- eg.engine_type as "Type of engine"
from nissan_models_range nmr 
 where nmr.model_name = 'Nissan Infiniti'
and nmr.engine_id is not null
)











select * from  transmissions tm where tm.tm_id not in ( select nmr.gearbox_id 
from nissan_models_range nmr 
 where nmr.model_name = 'Nissan Infiniti'
and nmr.gearbox_id is not null
)


select * from  vehicle_body vb where vb.vb_id not in ( select nmr.vehicle_body_id 
from nissan_models_range nmr 
 where nmr.model_name = 'Nissan Infiniti'
and nmr.gearbox_id is not null
)

