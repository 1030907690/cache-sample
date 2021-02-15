# cache-sample
缓存例子
## 使用指南Openresty缓存
### 1、复制nginx/conf里的内容
- 主要2个文件，localhost_84.conf和cache.lua
### 2、在openresty的nginx.conf中新增
- http内 include vhost/*.conf;  引入conf文件
### 3、创建db和表、新增数据
create database ·dwc-admin·;
CREATE TABLE `t_article` (
  `id` bigint(11) NOT NULL,
  `content` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO `dwc-admin`.`t_article`(`id`, `content`) VALUES (1, '<p>\r\n	Think Different\r\n</p>\r\n<p>\r\n	Here’s to the crazy ones. The misfits. The rebels. The troublemakers. The round pegs in the square holes. The ones who see things differently. They’re not fond of rules. And they have no respect for the status quo. You can quote them, disagree with them, glorify or vilify them. About the only thing you can’t do is ignore them. Because they change things. They push the human race forward. And while some may see them as the crazy ones, we see genius. Because the people who are crazy enough to think they can change the world, are the ones who do.\r\n</p>\r\n<p>\r\n	- Apple Inc.\r\n</p>');

## 测试
### 设置启动参数 -server -Xms256m -Xmx256m
### 访问
- http://localhost:8080/article/detail?id=1
- http://localhost:84/article/detail?id=1
