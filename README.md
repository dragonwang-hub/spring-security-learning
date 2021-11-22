#Spring Security Learning
1. Securing a web application: https://spring.io/guides/gs/securing-web/
2. Security 包 自带验证页面，只有单用户，密码在命令行可查。
3. 默认数据库模型的认证与授权(内存型，数据库型)
4. 自定义数据库模型的认证与授权(自定义User Table)，使用JPA实现数据库查询并将Entity转换为UserDto对象
5. spring security 注解的使用。@Secured, @PreAuthorize, @PostAuthorize, @PreFilter, @PostFilter [Reference](http://learn.lianglianglee.com/%E4%B8%93%E6%A0%8F/Spring%20Security%20%E8%AF%A6%E8%A7%A3%E4%B8%8E%E5%AE%9E%E6%93%8D/10%20%20%E5%85%A8%E5%B1%80%E6%96%B9%E6%B3%95%EF%BC%9A%E5%A6%82%E4%BD%95%E7%A1%AE%E4%BF%9D%E6%96%B9%E6%B3%95%E7%BA%A7%E5%88%AB%E7%9A%84%E5%AE%89%E5%85%A8%E8%AE%BF%E9%97%AE%EF%BC%9F.md)
6. RememberMe 的使用，可以记住用户名和密码，下次自动登录。
