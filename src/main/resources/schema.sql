BEGIN;

CREATE TABLE IF NOT EXISTS users
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    username character varying NOT NULL,
    password character varying NOT NULL,
    is_active boolean NOT NULL,
    is_admin boolean NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
    );

END;