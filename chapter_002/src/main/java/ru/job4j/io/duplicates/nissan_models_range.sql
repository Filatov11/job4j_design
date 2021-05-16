

CREATE TABLE public.nissan_models_range
(
  model_id integer,
  model_name character varying(70),
  vehicle_body_id integer,
  gearbox_id integer,
  engine_id integer
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.nissan_models_range
  OWNER TO postgres;

INSERT INTO public.nissan_models_range( model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
 VALUES (1, 'Nissan Atlas', 1, 1, 1);
INSERT INTO public.nissan_models_range(model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (2, 'Nissan Auster', 2, 2, 2);
    INSERT INTO public.nissan_models_range( model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (3, 'Nissan Auster', 3, 2, 3);
    INSERT INTO public.nissan_models_range( model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (4, 'Nissan Avenir', 4, 2, 4);
    INSERT INTO public.nissan_models_range( model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (5, 'Nissan Avenir', 5, 3, 5);
    INSERT INTO public.nissan_models_range( model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (6, 'Nissan Bassara', 6, 2, 6);
    INSERT INTO public.nissan_models_range(  model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (7, 'Nissan Bassara', 7, 2, 7);
    INSERT INTO public.nissan_models_range( model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (8, 'Nissan Caravan', 8, 1, 8);
    INSERT INTO public.nissan_models_range(model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (9, 'Nissan Caravan', 9, 3, 8);
    INSERT INTO public.nissan_models_range( model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (10, 'Nissan Cedric', 10, 3, 9);
    INSERT INTO public.nissan_models_range( model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (11, 'Nissan Clipper', 11, 4, 10);
    INSERT INTO public.nissan_models_range( model_id, model_name, vehicle_body_id, gearbox_id, engine_id)
    VALUES (12, 'Nissan Infiniti', 12, 5, 11);
   
select * from nissan_models_range