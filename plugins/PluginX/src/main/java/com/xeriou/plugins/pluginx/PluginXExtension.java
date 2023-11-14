package com.xeriou.plugins.pluginx;

import com.xeriou.api.LoadPageExtension;
import org.pf4j.Extension;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Extension
public class PluginXExtension implements LoadPageExtension {
    @Override
    public List<File> scanPage() {
        try {
            URI templates = this.getClass().getResource("/templates").toURI();
            System.out.println("ScanFileRunner " + templates);

            Path path = ResourceUtils.getFile(templates).toPath();
            Files.list(path).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Scan Page Error");
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
