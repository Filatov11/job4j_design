﻿CREATE TABLE public.type
(
  id integer,
  name character varying(50)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.type
  OWNER TO postgres;


INSERT INTO public.type(
            id, name)
    VALUES (1, 'Сыр');
INSERT INTO public.type(
            id, name)
    VALUES (2, 'Молоко');
    INSERT INTO public.type(
            id, name)
    VALUES (3, 'Мандарины');
    INSERT INTO public.type(
            id, name)
    VALUES (4, 'Шпроты');
        INSERT INTO public.type(
            id, name)
    VALUES (5, 'Рыба');
          INSERT INTO public.type(
            id, name)
    VALUES (6, 'Мороженое');  
    commit;

    select * from type;