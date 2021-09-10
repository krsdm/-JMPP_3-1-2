
/*   Initial data   */

INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('admin', '', '$2a$10$BF5JUixK1.T2eo6Acg4oT.VQpfeT4vlJk23fxxESgtidbMi8u0oeO', '26', 'admin@mail.com');
INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('user', '', '$2a$10$BF5JUixK1.T2eo6Acg4oT.VQpfeT4vlJk23fxxESgtidbMi8u0oeO', '19', 'user@mail.com');
INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('someone', '', '$2a$10$BF5JUixK1.T2eo6Acg4oT.VQpfeT4vlJk23fxxESgtidbMi8u0oeO', '33', 'someone@mail.com');

INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_USER');
INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_SOMEONE');

INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '2');
INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '1');
INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('3', '3');