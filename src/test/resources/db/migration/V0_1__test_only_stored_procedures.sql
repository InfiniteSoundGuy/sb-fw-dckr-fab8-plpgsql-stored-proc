-- *****************************************************************************
-- Inserts row into table example, and return the inserted row's id value.
-- *****************************************************************************
CREATE OR REPLACE FUNCTION insert_example(p_label VARCHAR, p_prop_id VARCHAR, p_case_id VARCHAR, p_insert_date TIMESTAMP)
RETURNS BIGINT
AS $$
DECLARE new_id BIGINT;
BEGIN
    INSERT INTO example (label, prop_id, case_id, insert_date)
    VALUES (p_label, p_prop_id, p_case_id, p_insert_date)
    RETURNING id INTO new_id;
    RETURN new_id;
END;
$$ LANGUAGE plpgsql;
