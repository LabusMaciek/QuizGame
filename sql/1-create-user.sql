CREATE USER 'admin_quiz'@'localhost' IDENTIFIED BY 'admin_quiz';

GRANT ALL PRIVILEGES ON * . * TO 'admin_quiz'@'localhost';


ALTER USER 'admin_quiz'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin';
