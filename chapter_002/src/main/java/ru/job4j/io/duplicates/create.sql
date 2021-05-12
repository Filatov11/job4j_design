-- Table: public.attachments

-- DROP TABLE public.attachments;

CREATE TABLE public.attachments
(
  attachment_id integer NOT NULL,
  item_id integer,
  attachment text,
  CONSTRAINT attachment_id_pk PRIMARY KEY (attachment_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.attachments
  OWNER TO postgres;


-- Table: public.category

-- DROP TABLE public.category;

CREATE TABLE public.category
(
  category_id integer NOT NULL,
  category character(25)[],
  CONSTRAINT category_id_pk PRIMARY KEY (category_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.category
  OWNER TO postgres;


-- Table: public.comments

-- DROP TABLE public.comments;

CREATE TABLE public.comments
(
  comment_id integer NOT NULL,
  CONSTRAINT comment_id_pk PRIMARY KEY (comment_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.comments
  OWNER TO postgres;



-- Table: public.items

-- DROP TABLE public.items;

CREATE TABLE public.items
(
  item_id integer NOT NULL,
  state_id integer,
  attach_id integer,
  category_id integer,
  user_id integer,
  comment_id integer,
  CONSTRAINT item_id_pk PRIMARY KEY (item_id),
  CONSTRAINT attach_id_fk FOREIGN KEY (attach_id)
      REFERENCES public.attachments (attachment_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT category_id_fk FOREIGN KEY (category_id)
      REFERENCES public.category (category_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT comment_id_fk FOREIGN KEY (comment_id)
      REFERENCES public.comments (comment_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT state_id_fk FOREIGN KEY (state_id)
      REFERENCES public.states (state_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_id_fk FOREIGN KEY (user_id)
      REFERENCES public.users (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.items
  OWNER TO postgres;

-- Index: public.fki_attach_id_fk

-- DROP INDEX public.fki_attach_id_fk;

CREATE INDEX fki_attach_id_fk
  ON public.items
  USING btree
  (attach_id);

-- Index: public.fki_category_id_fk

-- DROP INDEX public.fki_category_id_fk;

CREATE INDEX fki_category_id_fk
  ON public.items
  USING btree
  (category_id);

-- Index: public.fki_comment_id_fk

-- DROP INDEX public.fki_comment_id_fk;

CREATE INDEX fki_comment_id_fk
  ON public.items
  USING btree
  (comment_id);

-- Index: public.fki_state_id_fk

-- DROP INDEX public.fki_state_id_fk;

CREATE INDEX fki_state_id_fk
  ON public.items
  USING btree
  (state_id);

-- Index: public.fki_user_id_fk

-- DROP INDEX public.fki_user_id_fk;

CREATE INDEX fki_user_id_fk
  ON public.items
  USING btree
  (user_id);



-- Table: public.role_rules

-- DROP TABLE public.role_rules;

CREATE TABLE public.role_rules
(
  rule_id integer,
  role_id integer,
  role_rule_id integer NOT NULL,
  CONSTRAINT role_rule_id_pk PRIMARY KEY (role_rule_id),
  CONSTRAINT role_id_fk FOREIGN KEY ()
      REFERENCES public.roles () MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT rule_id_fk FOREIGN KEY ()
      REFERENCES public.rules () MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.role_rules
  OWNER TO postgres;

-- Index: public.fki_role_id_fk

-- DROP INDEX public.fki_role_id_fk;

CREATE INDEX fki_role_id_fk
  ON public.role_rules
  USING btree
  (role_id);



-- Table: public.roles

-- DROP TABLE public.roles;

CREATE TABLE public.roles
(
  role_id integer NOT NULL,
  role_name character(25)[],
  description character(100)[],
  CONSTRAINT role_id_pk PRIMARY KEY (role_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.roles
  OWNER TO postgres;


-- Table: public.rules

-- DROP TABLE public.rules;

CREATE TABLE public.rules
(
  rule_id integer NOT NULL,
  rule_name character(25)[],
  description character(100)[],
  CONSTRAINT rule_id_pk PRIMARY KEY (rule_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.rules
  OWNER TO postgres;


-- Table: public.states

-- DROP TABLE public.states;

CREATE TABLE public.states
(
  state_id integer NOT NULL,
  state character(20)[],
  CONSTRAINT state_id_pk PRIMARY KEY (state_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.states
  OWNER TO postgres;


-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
  user_id integer NOT NULL,
  username character varying(25) NOT NULL,
  password character varying(30) NOT NULL,
  role integer,
  CONSTRAINT users_pkey PRIMARY KEY (user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.users
  OWNER TO postgres;



