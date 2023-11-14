package com.xeriou.plugins.pluginx;

import com.xeriou.api.IGreetService;
import com.xeriou.api.IHelloController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;

@RestController
public class HelloController implements IHelloController {

    @Autowired
    IGreetService greetService;


    @Autowired
    private DataSource dataSource;

    @Override
    @GetMapping("/hello")
    public String sayHello() {
        return "這是 PluginX. " + greetService.sayHello();
    }


    @GetMapping("/pluginx/db")
    public String db() {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "show tables";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            StringBuilder stringBuilder = new StringBuilder();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getString(1)).append("\n");
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
