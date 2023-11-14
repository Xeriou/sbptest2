package com.xeriou.robotapp;

import com.xeriou.api.LoadPageExtension;
import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RootAppController {

    @Lazy
    @Autowired
    private PluginManager pluginManager;

    @Autowired
    private DataSource dataSource;


    @GetMapping("/")
    public String index() {
        return "Hello, World! This is the root of the RobotApp.";
    }

    @GetMapping("/db")
    public String db() {

        try (Connection connection = dataSource.getConnection()){
            String sql = "select 1";
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

    @GetMapping("/checkPage")
    public String checkPage() {
        List<File> resources = new ArrayList<>();
        pluginManager.getExtensions(LoadPageExtension.class).stream()
                .map(LoadPageExtension::scanPage)
                .reduce(resources, (urls, urls2) -> {
                    urls.addAll(urls2);
                    return urls;
                });

        System.out.println("Resources From Extension:");
        resources.forEach(System.out::println);

        return "Resources From Extension ... " + resources.size();
    }
}
