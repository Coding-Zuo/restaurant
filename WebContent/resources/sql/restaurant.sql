CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` int(2) NOT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_orders` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `number` varchar(32) NOT NULL,
  `note` varchar(100) ,
  `createtime` timestamp NOT NULL,
  `endtime` timestamp ,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` double(10,2) NOT NULL,
  `detail` varchar(100) ,
  `pic` varchar(64) ,
  `createtime` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_orders_items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `orders_id` int(10) NOT NULL,
  `items_id` int(10) NOT NULL,
  `items_num` int(10) NOT NULL,
  `items_type` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orders_id` (`orders_id`),
  KEY `items_id` (`items_id`),
  CONSTRAINT `items_id` FOREIGN KEY (`items_id`) REFERENCES `t_items` (`id`),
  CONSTRAINT `orders_id` FOREIGN KEY (`orders_id`) REFERENCES `t_orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


















