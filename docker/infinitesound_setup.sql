CREATE USER infinitesounduser WITH SUPERUSER PASSWORD 'infinitesoundpassword';
CREATE DATABASE infinitesound;
CREATE DATABASE infinitesound_test;
GRANT ALL PRIVILEGES ON DATABASE infinitesound      TO infinitesounduser;
GRANT ALL PRIVILEGES ON DATABASE infinitesound_test TO infinitesounduser;