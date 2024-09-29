CREATE DATABASE  IF NOT EXISTS `donation`;
USE `donation`;

DROP TABLE IF EXISTS `user_donation`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `donation`;



CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `status` int DEFAULT 1,
  `user_name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT 'note',
  primary key (`id`)
);


CREATE TABLE `donation` (
	`id` int NOT NULL AUTO_INCREMENT,
    `code` varchar(255) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `end_date` varchar(255) DEFAULT NULL,
    `money` int DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `organization_name` varchar(255) DEFAULT NULL,
    `phone_number` varchar(255) DEFAULT NULL,
    `start_date` varchar(255) DEFAULT NULL,
    `status` int DEFAULT NULL,
    `display` int DEFAULT NULL,
    primary key(`id`)
);

CREATE TABLE `user_donation` (
	`id` int NOT NULL AUTO_INCREMENT,
    `created_date` varchar(255) DEFAULT NULL,
    `money` int DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `status` int DEFAULT NULL,
    `text` varchar(255) DEFAULT NULL,
    `donation_id` int DEFAULT NULL,
    `user_id` int DEFAULT NULL,
    primary key (`id`),
    foreign key(`donation_id`) references `donation`(`id`),
    foreign key(`user_id`) references `user`(`id`)
);

    
INSERT INTO `user` VALUES
	(1, 'đường 1, TP H', 'admin@email.com', 'Admin', 'test123', '01150129321', 1, 'admin', 'admin', 'note'),
	(2, 'đường 2, TP A', 'emailA@email.com', 'Nguyễn Văn A', 'test123', '01264754939', 1, 'usernameA', 'user', 'note'),
	(3, 'đường 3, TP B', 'emailB@email.com', 'Nguyễn Văn B', 'test123', '01636950978', 1, 'usernameB', 'user', 'note'),
	(4, 'đường 4, TP C', 'emailC@email.com', 'Nguyễn Văn C', 'test123', '01120454779', 1, 'usernameC', 'user', 'note'),
	(5, 'đường 5, TP D', 'emailD@email.com', 'Nguyễn Văn D', 'test123', '01586403114', 1, 'usernameD', 'user', 'note'),
	(6, 'đường 6, TP E', 'emailE@email.com', 'Nguyễn Văn E', 'test123', '01921380671', 1, 'usernameE', 'user', 'note'),
	(7, 'đường 7, TP F', 'emailF@email.com', 'Nguyễn Văn F', 'test123', '01789032428', 1, 'usernameF', 'user', 'note'),
	(8, 'đường 8, TP G', 'emailG@email.com', 'Nguyễn Văn G', 'test123', '01631887582', 1, 'usernameG', 'user', 'note');
	

INSERT INTO `donation` VALUES
	(1, 'C001', 'Giúp đỡ trẻ em nghèo', '2025-08-30', 0, 'Giúp đỡ trẻ em nghèo', 'Bảo vệ trẻ em', '01878254712', '2024-07-01', 2, 1),
    (2, 'C002', 'Hỗ trợ người dân sau lũ lụt', '2025-09-30', 0, 'Giúp đỡ người dân sau thiên tai ', 'Hỗ trợ phòng chống thiên tai', '01239795802', '2024-07-30', 1, 1),
    (3, 'C003', 'Xây trường học cho các em ở khu vực khó khăn', '2025-08-30', 0, 'Xây trường học', 'Từ thiện Việt Nam', '01643343714', '2024-07-10', 1, 1),
    (4, 'C004', 'Chung tay hỗ trợ bệnh nhân ung thư', '2025-08-15', 0, 'Giúp đỡ bệnh nhân bị ung thư', 'Từ thiện Việt Nam', '01109063439', '2024-07-01', 2, 1);
    

    
