-- Table: public.items

-- DROP TABLE public.items;

CREATE TABLE public.items
(
  id serial NOT NULL PRIMARY KEY,
  name text
);
ALTER TABLE public.items
  OWNER TO postgres;
  
