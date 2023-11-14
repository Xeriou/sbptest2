package com.xeriou.plugins.pluginx;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScanFileRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        URI templates = this.getClass().getResource("/templates").toURI();
        System.out.println("ScanFileRunner " + templates);

        Path myPath;
        if (templates.getScheme().equals("jar")) {
            FileSystem fileSystem = FileSystems.newFileSystem(templates, Collections.<String, Object>emptyMap());
            myPath = fileSystem.getPath("/templates");
        } else {
            myPath = ResourceUtils.getFile(templates).toPath();
        }

        //            Files.copy()
        Files.list(myPath).forEach(System.out::println);

        Path rootTemplatePath = Paths.get("templates");
        System.out.println("rootTemplatePath " + rootTemplatePath.toAbsolutePath());
        Files.list(rootTemplatePath).forEach(System.out::println);


        List<Path> c = Files.list(myPath).collect(Collectors.toList());
        for (Path f : c) {
            try(InputStream ins = Files.newInputStream(f)) {
                System.out.print("Copy " + f.getFileName());
                Path toCopy = rootTemplatePath.resolve(f.getFileName().toString());
                System.out.println(" to " + toCopy);
                Files.copy(ins, toCopy, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
