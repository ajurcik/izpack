package com.izforge.izpack.test.util;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Enhanced URL class loader used to add additional resources.
 * 
 * @author Patrick Reinhart
 *
 */
final class ModifyableClassLoader extends URLClassLoader {
    public ModifyableClassLoader(URL initialUrl, ClassLoader parentClassLoader) {
        super(new URL[] {initialUrl}, parentClassLoader);
    }

    @Override
    public void addURL(URL url) {
        super.addURL(url);
    }
}