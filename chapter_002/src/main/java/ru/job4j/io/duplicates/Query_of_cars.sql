select * from engines e left join nissan_models_range nmr  
on e.engine_id = nmr.engine_id
where nmr.engine_id is  null;

select * from  transmissions tm left join nissan_models_range nmr   
on tm.tm_id  = nmr.gearbox_id
where nmr.gearbox_id is null

select * from  vehicle_body vb left join nissan_models_range nmr   
on vb.vb_id = nmr.vehicle_body_id 
where nmr.vehicle_body_id is null
