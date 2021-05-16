1)

select nmr.model_name as "Car model", eg.engine_type as "Type of engine", tm.type as "Type of transmission", vb.type as "Type of car body" from nissan_models_range nmr,  engines eg , transmissions tm, vehicle_body vb
where nmr.gearbox_id = tm.tm_id
and nmr.vehicle_body_id = vb.vb_id
and nmr.engine_id = eg.engine_id


2)

Parts not used in car_model

select nmr.model_name as "Car model"  , eg.engine_type as "Type of engine"
from nissan_models_range nmr  left join engines eg  on  nmr.engine_id = eg.engine_id
and nmr.model_name <> 'Nissan Infiniti'

select nmr.model_name as "Car model"  , tm.type as "Type of transmission"
from nissan_models_range nmr  left join transmissions tm  on  nmr.gearbox_id = tm.tm_id
and nmr.model_name <> 'Nissan Infiniti'

select nmr.model_name as "Car model"  , vb.type as "Type of car body"
from nissan_models_range nmr  left join vehicle_body vb  on nmr.vehicle_body_id = vb.vb_id
and nmr.model_name <> 'Nissan Infiniti'