CREATE USER keycloak_user WITH PASSWORD '1234';
CREATE SCHEMA keycloak_schema;
GRANT ALL PRIVILEGES ON SCHEMA keycloak_schema TO keycloak_user;

CREATE SCHEMA first;
GRANT ALL PRIVILEGES ON SCHEMA first TO first_test_user;
-- Important Security Note:
-- 1. Do not use the password 'YOUR_STRONG_PASSWORD' in a production environment.
--    Replace it with a long, randomly generated password.
-- 2. Store the password securely (e.g., in an environment variable or a secret management system)
--    and do not hardcode it in your application's configuration files.
-- 3. In a production environment, you should also consider restricting the user's privileges
--    to only what is necessary, and limiting the IP addresses that can connect.
