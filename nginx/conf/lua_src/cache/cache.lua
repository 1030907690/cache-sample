local uriArgs = ngx.req.get_uri_args() -- 得到全部参数
local articleId = uriArgs["id"] -- 得到id参数的值
local cache_ngx = ngx.shared.article_cache -- 共享内存dict
local articleCacheKey = "article_"..articleId   -- 拼接key
local articleCache = cache_ngx:get(articleCacheKey) -- 得到key的值
if  articleCache == nil or articleCache == "" then -- 判断是否存在
	local http = require("resty.http") -- 引入resty.http模块
	local httpc = http.new() -- 创建对象
	local resp, err = httpc:request_uri("http://127.0.0.1:8080/article/detail?id="..articleId,{method = "GET",keepalive = false}) -- 发起请求
	articleCache = resp.body -- 得到返回
	cache_ngx:set(articleCacheKey,articleCache,1 *30) -- 设置缓存
end
ngx.say(articleCache) -- 打印、输出