package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootTest
//@EnableTransactionManagement
class DemoApplicationTests {

//    @Autowired
//    @Qualifier("postgre")
//    private MySqlHelper postgreHelper;
//
//    @Autowired
//    private MySqlHelper mySqlHelper;
//
//    @Autowired
//    private DbSourceService dbSourceService;

    /*
    问题1：不能为定时任务指定单独的数据库
    问题2：org.postgresql.util.PSQLException: 在 PreparedStatement 上不能使用获取查询字符的查询方法。
    允许其他服务器访问：
    C:\Program Files\PostgreSQL\9.5\data\pg_hba.conf
    * */
    @Test
    void contextLoads() throws Exception {
        //dbSourceService.handle();

    }

    @Test
    void clean() throws Exception {
        //dbSourceService.clean();
    }
}
