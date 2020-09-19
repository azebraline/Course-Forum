# 选修课程评分系统

快速启动项目
1. Docker 启动 mysql
```bash
cd docker
docker-compose up -d
```
访问 http://localhost:8080, 将初始数据导入。

修改数据库链接相关配置，启动项目。
```bash
mvn install
mvn spring-boot:run
初始用户名: admin
初始密码: admin
```
