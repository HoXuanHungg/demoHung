--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: hung; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hung (
    id bigint NOT NULL,
    address text,
    firstname text,
    lastname text
);


ALTER TABLE public.hung OWNER TO postgres;

--
-- Name: hung_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hung_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hung_id_seq OWNER TO postgres;

--
-- Name: hung_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hung_id_seq OWNED BY public.hung.id;


--
-- Name: hung id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hung ALTER COLUMN id SET DEFAULT nextval('public.hung_id_seq'::regclass);


--
-- PostgreSQL database dump complete
--

