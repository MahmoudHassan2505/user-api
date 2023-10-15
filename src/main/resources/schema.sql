BEGIN;

CREATE TABLE IF NOT EXISTS role
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying NOT NULL,
    CONSTRAINT role_pkey PRIMARY KEY (id)
);



CREATE TABLE IF NOT EXISTS users
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    username character varying NOT NULL,
    password character varying NOT NULL,
    is_active boolean NOT NULL,
    role_id bigint NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT "username_Unique" UNIQUE (username),
    CONSTRAINT "Role_FK" FOREIGN KEY (role_id)
        REFERENCES role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE INDEX IF NOT EXISTS "fki_Role_FK"
    ON users USING btree
        (role_id ASC NULLS LAST)
    TABLESPACE pg_default;
END;