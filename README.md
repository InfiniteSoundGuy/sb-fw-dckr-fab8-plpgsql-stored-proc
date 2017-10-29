# sb-fw-dckr-fab8-plpgsql-stored-proc
Example: Integration tests
- Spring Boot
- Docker
- Hibernate (JPA)
- Flyway (executes SQL scripts after postgres starts in container)
- Fabric8 docker-maven-plugin (to control image build and container startup for integration tests)
- Example code using entityManager.createStoredProcedureQuery(...)
- PostgreSQL native "plpgsql" stored procedure, including use of "TABLE" construct for returning resultset
