-- *****************************************************************************
-- Returns rows from table infinitesound.example, whose insert_date is between
-- start_date and end_date.
-- *****************************************************************************
CREATE OR REPLACE FUNCTION get_example_data(start_date TIMESTAMP, end_date TIMESTAMP)
RETURNS TABLE (
    -- TABLE is a PostgreSQL-specific mechanism for returning data.
    example_id      BIGINT,
    insert_date     TIMESTAMP,
    label           VARCHAR,
    prop_id         VARCHAR,
    case_id         VARCHAR
) AS $$
BEGIN
    RETURN QUERY
    SELECT q.example_id, q.insert_date, q.label, q.prop_id, q.case_id
    FROM example AS q
    WHERE q.insert_date BETWEEN start_date AND end_date;
END;
$$ LANGUAGE plpgsql;
