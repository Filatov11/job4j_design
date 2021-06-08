CREATE TABLE public.transmissions
(
  tm_id integer,
  type character varying(30)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.transmissions
  OWNER TO postgres;


CREATE TABLE public.vehicle_body
(
  vb_id integer,
  type character varying(50)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.vehicle_body
  OWNER TO postgres;



CREATE TABLE public.gearboxes
(
  gb_id integer,
  gear_type character varying(70),
  model_id integer
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.gearboxes
  OWNER TO postgres;





INSERT INTO public.transmissions(
            tm_id, type)
    VALUES (1,'MT');
INSERT INTO public.transmissions(
            tm_id, type)
    VALUES (2,'AT');
    INSERT INTO public.transmissions(
            tm_id, type)
    VALUES (3,'AT.F4');

    INSERT INTO public.transmissions(
            tm_id, type)
    VALUES (4,'AT.R4');  

     INSERT INTO public.transmissions(
            tm_id, type)
    VALUES (5,'5MT');    
    
     INSERT INTO public.transmissions(
            tm_id, type)
    VALUES (6,'5MT.F4');    
     INSERT INTO public.transmissions(
            tm_id, type)
    VALUES (12,'ATF.M4');    

INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (1, 'TD27');
INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (2, 'CA18I');
    INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (3, 'CA16S');
    INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (4, 'SR20DE');
    INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (5, 'QR20DE');
    INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (6, 'VQ30DE');
    INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (7, 'KA24DE');
    INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (8, 'ZD30DD');


        INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (9, 'VG20P');
        INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (10, '3G83');
        INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (11, 'VH45D');
        INSERT INTO public.engines(
            engine_id, engine_type)
    VALUES (14, 'VH72DT');
    commit;


INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (1, 'AF22');
INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (2, 'PT12');
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (3, 'T12');
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (4, 'PNW10');
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (5, 'RNW11');
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (6, 'JHU30');
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (7, 'JU30');
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (8, 'CQGE25');
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (9, 'DWMGE25');
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (10, 'BJY31');
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (11, 'U71T'); 
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (12, 'G50');
    INSERT INTO public.vehicle_body(
            vb_id, type)
    VALUES (17, 'RTY57');

    commit;
commit;
