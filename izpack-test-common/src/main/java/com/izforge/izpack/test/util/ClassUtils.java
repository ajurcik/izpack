package com.izforge.izpack.test.util;

import java.io.File;
import java.net.URL;

/**
 * jar Classloading manipulation class
 *
 * @author Anthonin Bonnefoy
 */
public class ClassUtils {
    public static void unloadLastJar() {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader instanceof ModifyableClassLoader) {
                Thread.currentThread().setContextClassLoader(((ModifyableClassLoader)contextClassLoader).getParent());
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void loadJarInSystemClassLoader(File out) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            URL url = out.toURI().toURL();
            if (contextClassLoader instanceof ModifyableClassLoader) {
                ((ModifyableClassLoader)contextClassLoader).addURL(url);
            } else {
                Thread.currentThread().setContextClassLoader(new ModifyableClassLoader(url, ClassLoader.getSystemClassLoader()));
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
