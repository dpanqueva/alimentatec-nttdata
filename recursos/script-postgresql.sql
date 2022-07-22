------------------------------------------------------
-- create table
------------------------------------------------------
CREATE TABLE public.usuarios
(
    id bigint NOT NULL DEFAULT nextval('tbl_usuarios_id_seq'::regclass),
    cedula character varying(50) COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(50) COLLATE pg_catalog."default" NOT NULL,
    apellido character varying(50) COLLATE pg_catalog."default" NOT NULL,
    correo character varying(50) COLLATE pg_catalog."default" NOT NULL,
    snactivo character varying(1) COLLATE pg_catalog."default" NOT NULL DEFAULT 'S'::character varying,
    CONSTRAINT tbl_usuarios_pkey PRIMARY KEY (id)
)
------------------------------------------------------
-- create sequence
------------------------------------------------------
CREATE SEQUENCE public.tbl_usuarios_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
	
------------------------------------------------------
-- create stored procedure
------------------------------------------------------	
-- PROCEDURE: public.sp_usuario_activo_cedula(character varying, character varying, character varying, numeric, character varying)

-- DROP PROCEDURE public.sp_usuario_activo_cedula(character varying, character varying, character varying, numeric, character varying);

CREATE OR REPLACE PROCEDURE public.sp_usuario_activo_cedula(
	p_cedula character varying,
	INOUT s_name character varying,
	INOUT s_correo character varying,
	INOUT s_id numeric,
	INOUT p_exec character varying)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
s_info_exist numeric;
BEGIN

select count(1) cant into s_info_exist from public.usuarios as u where u.snactivo = 'S'
and u.cedula = p_cedula;

raise notice 's info exist... % ', s_info_exist;
-- consultar si existe en calificaciones
-- flujo normal
if s_info_exist  > 0 then
      select u.nombre ||' '||u.apellido,
	  u.correo, 
	  u.id into s_name, s_correo,s_id
	  from public.usuarios as u where u.snactivo = 'S'
		and u.cedula = p_cedula;
		
	raise notice 'name... % ', s_name;
	raise notice 'correo... % ', s_correo;
	raise notice 's id... % ', s_id;

p_exec:='200';

else
		p_exec:='204';
end if;
exception when others then
 	p_exec:= '500';
END;
$BODY$;
