CREATE TYPE position_nomenclature AS ENUM ('EMPLOYEE', 'HEAD_OF_DEPARTMENT', 'DIRECTOR_OF_DIRECTORATE');
CREATE TYPE role AS ENUM ('ROLE_ADMIN', 'ROLE_DIRECTOR', 'ROLE_HEAD', 'ROLE_EMPLOYEE');
CREATE TYPE subdepartment_type AS ENUM ('EMPLOYEES', 'HEADS', 'DIRECTORS');

CREATE TABLE IF NOT EXISTS directorates
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START WITH 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    directorate_name character varying(200) NOT NULL,
    directorate_description character varying(400) NOT NULL,
    active boolean NOT NULL DEFAULT true,
    CONSTRAINT directorates_pkey PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS departments
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START WITH 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    department_name character varying(200) NOT NULL,
    department_description character varying(400) NOT NULL,
    directorate bigint,
    active boolean NOT NULL DEFAULT true,
    CONSTRAINT departments_pkey PRIMARY KEY (id),
    CONSTRAINT fk_dep_dir FOREIGN KEY (directorate)
    REFERENCES directorates (id)
);
CREATE TABLE IF NOT EXISTS subdepartments
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START WITH 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    parent bigint,
    active boolean NOT NULL DEFAULT true,
    subdepartment_type subdepartment_type DEFAULT 'EMPLOYEES'::subdepartment_type,
    CONSTRAINT subdepartments_pkey PRIMARY KEY (id),
    CONSTRAINT fk_subdep_dep FOREIGN KEY (parent)
    REFERENCES public.departments (id)
);
CREATE TABLE IF NOT EXISTS employees
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START WITH 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    employee_name character varying(100) NOT NULL,
    employee_surname character varying(100) NOT NULL,
    employee_personal_id character varying(9) NOT NULL,
    employee_age integer NOT NULL,
    active boolean NOT NULL DEFAULT true,
    subdepartment bigint,
    employee_position position_nomenclature NOT NULL DEFAULT 'EMPLOYEE'::position_nomenclature,
    CONSTRAINT employees_pkey PRIMARY KEY (id),
    CONSTRAINT fk_emp_subdep FOREIGN KEY (subdepartment)
    REFERENCES public.subdepartments (id)
);
CREATE TABLE IF NOT EXISTS users
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START WITH 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    username character varying(60) NOT NULL,
    password character varying(100) NOT NULL,
    employee_id bigint,
    active boolean NOT NULL DEFAULT true,
    CONSTRAINT users1_pkey PRIMARY KEY (id),
    CONSTRAINT fk_user_emp FOREIGN KEY (employee_id)
    REFERENCES public.employees (id)
)