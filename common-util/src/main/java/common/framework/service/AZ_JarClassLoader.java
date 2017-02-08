package common.framework.service;

import common.framework.abstracted.AZ_ClassLoader;
import common.framework.security.SecurityCoder;

import java.io.*;

public class AZ_JarClassLoader  extends AZ_ClassLoader{
    public AZ_JarClassLoader(String name, String path) {
        super(name, path);
    }
    public AZ_JarClassLoader(String name) {
        super(name);
    }
    public AZ_JarClassLoader(SecurityCoder securityCoder, String name, String path) {
        super(securityCoder, name, path);
    }
    @Override
    public InputStream readResource(String path, String fileName, String fileTyep) throws FileNotFoundException {
        return new BufferedInputStream(new FileInputStream(new File(path+fileName + fileTyep)));
    }
}
