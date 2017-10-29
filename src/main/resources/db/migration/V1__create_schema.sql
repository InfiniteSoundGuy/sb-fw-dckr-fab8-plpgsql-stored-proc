CREATE SEQUENCE example_id_seq;

CREATE TABLE example (
    id              BIGINT      NOT NULL    DEFAULT nextval('example_id_seq'),
    insert_date     TIMESTAMP   NOT NULL,
    label           VARCHAR(10) NOT NULL,
    prop_id         VARCHAR(20) NOT NULL,
    case_id         VARCHAR(50) NOT NULL
);

ALTER SEQUENCE example_id_seq OWNED BY example.id;