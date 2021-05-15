-- Table: public.product

-- DROP TABLE public.product;

CREATE TABLE public.product
(
  id integer,
  name character varying(70),
  type_id integer,
  expired_date date,
  price real
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.product
  OWNER TO postgres;


INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (1, 'Сыр голландский',1, '2021-06-01' ,250.15);

    INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (2, 'Пошехонский',1, '2021-08-01' ,270.15);

       INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (5, 'Филе трески мороженное',5, '2021-08-11' ,210.25);


           INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (6, 'Филе минтая мороженное',5, '2021-08-11' ,205.25);


           INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (7, 'Фруктовое мороженное',6, '2021-07-11' ,21.25);

           INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (8, 'Молоко Новое',2, '2021-07-12' ,22.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (9, 'Вчерашнее',2, '2021-06-11' ,23.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (10, 'Козье',2, '2021-05-21' ,24.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (11, 'Простоквашино',2, '2021-07-25' ,25.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (12, 'Фермерское',2, '2021-08-11' ,26.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (13, 'Обезжиренное',2, '2021-09-11' ,27.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (14, 'Нормализованное',2, '2021-09-21' ,28.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (15, 'Из Кореновки',2, '2021-07-14' ,29.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (16, 'Полярное',2, '2021-08-21' ,30.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (17, 'Южное',2, '2021-06-27' ,31.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (18, 'С добавками',2, '2021-07-02' ,32.25);
               INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (19, 'Фруктовое',2, '2021-07-17' ,33.25);
    
    
       INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (20, 'Марокканские',3, '2021-12-27' ,433.25);
       INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (21, 'Абхазские',3, '2021-06-24' ,133.25);


       INSERT INTO public.product(
            id, name, type_id, expired_date, price)
    VALUES (22, 'Балтийские',4, '2022-02-24' ,73.25);

    commit;

    select * from product
    
