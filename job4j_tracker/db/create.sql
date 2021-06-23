-- Table: public.items

-- DROP TABLE public.items;

CREATE TABLE public.items
(
  id serial NOT NULL DEFAULT nextval('items_id_seq'::regclass),
  name text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.items
  OWNER TO postgres;