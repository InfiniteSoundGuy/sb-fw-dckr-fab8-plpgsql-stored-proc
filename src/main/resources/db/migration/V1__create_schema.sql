CREATE SEQUENCE example_example_id_seq;

CREATE TABLE example (
    example_id      BIGINT      NOT NULL    DEFAULT nextval('example_example_id_seq'),
    insert_date     TIMESTAMP   NOT NULL,
    label           VARCHAR(10) NOT NULL,
    prop_id         VARCHAR(20) NOT NULL,
    case_id         VARCHAR(50) NOT NULL
);

ALTER SEQUENCE example_example_id_seq OWNED BY example.example_id;