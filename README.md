# Exam-12951-20161219-1
数据库的用户名：root

数据库的密码：123456

访问页面的路径是：http://localhost:8080/Exam-12951-20161219-1/18/index.jsp

登录页面的用户名是customer的first_name,这里我指定的名字是MARY。

当访问首页时由于过滤器的缘故不能直接访问film.jsp,只有通过登录页面才能访问。

当用户名为空时返回登录界面，并且提示用户名为空，当用户名输入错误时也返回登录界面。

mvn exec:java -Dexec.mainClass="com.hand.dao1","com.hamd.dao.impl","com.hand.entity","com.hand.filter"
"com.hand.filter","com.hand.jdbc","com.hand.service","com.hand.servlet","com.hand.test","com.hand.util"
