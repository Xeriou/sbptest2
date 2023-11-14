package com.xeriou.api;

import org.pf4j.ExtensionPoint;

public interface IPluginRegister extends ExtensionPoint {
    String name();

    String description();
}