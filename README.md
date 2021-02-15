# cache-sample
缓存例子
## 使用指南
### 1、复制nginx/conf里的内容
- 主要2个文件，localhost_84.conf和cache.lua
### 2、在openresty的nginx.conf中新增
- http内 include vhost/*.conf;  引入conf文件
## 测试
### 设置启动内存 -Xms256m -Xmx256m
### 访问
- http://localhost:8080/article/detail?id=1
- http://localhost:84/article/detail?id=1
