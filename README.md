# cache-sample
缓存例子
## 使用指南Openresty缓存
### 1、复制nginx/conf里的内容
- 主要2个文件，localhost_84.conf和cache.lua
### 2、在openresty的nginx.conf中新增
- http内 include vhost/*.conf;  引入conf文件
### 3、创建db和表、新增数据
create database `dwc-admin`;
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




```

server {
        listen       8087;
        server_name  localhost;
		  lua_code_cache off;
		 location / {
		 resolver 8.8.8.8;
           default_type text/html;
			# lua文件的路径
			set $request_base_uri 'http://spider.ngrok.findourlove.com';
			content_by_lua_file conf/lua_src/api_result.lua;
        }
}

local uri =  ngx.var.request_uri;
local uriArgs = ngx.req.get_uri_args() 
local request_method = ngx.var.request_method
local cjson = require "cjson"
local http = require("resty.http") -- 引入resty.http模块
local httpc = http.new() -- 创建对象
local data = nil
if "GET" == request_method then

	local resp, err = httpc:request_uri(ngx.var.request_base_uri..uri,{method = "GET",keepalive = false}) -- 发起请求
	data = cjson.decode(resp.body);
elseif "POST" == request_method then
	ngx.say(uri)
	
end

-- 增加code返回
--if data['Status'] == 1 then
--	data['code'] = 0
--else
--	data['code'] = 1
--end
-- 返回
--ngx.say(cjson.encode(data))

```