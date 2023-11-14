package com.xeriou.api;

import org.pf4j.Extension;
import org.pf4j.ExtensionPoint;

import java.io.File;
import java.util.List;


public interface LoadPageExtension extends ExtensionPoint {

    List<File> scanPage();
}
