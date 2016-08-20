CREATE TABLE neighborhood.users (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `region_id` varchar(255) DEFAULT NULL,
  `room_id` varchar(255) DEFAULT NULL,
  `sex` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`user_id`)
);

CREATE TABLE neighborhood.room (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notice` varchar(255) DEFAULT NULL,
  `owner_id` varchar(255) DEFAULT NULL,
  `region_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_room` (
  `room_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE neighborhood.category (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`name`)
);

CREATE TABLE neighborhood.article (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL,
  `view_count` bigint(20) DEFAULT NULL,
  `writer_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`room_id`) REFERENCES neighborhood.room (`id`)
);

CREATE TABLE neighborhood.comment (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) DEFAULT NULL,
  `contents` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`article_id`) REFERENCES neighborhood.article (`id`)
);