CREATE USER 'admin1'@'localhost' IDENTIFIED BY 'admin1';

GRANT ALL PRIVILEGES ON * . * TO 'admin1'@'localhost';

ALTER USER 'admin1'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin1';