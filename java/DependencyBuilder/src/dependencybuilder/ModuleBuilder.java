/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencybuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author rpassmore
 */
public class ModuleBuilder {
    
    public static void main(String[] args) 
    {
        if(args.length <= 1)
            return;
        
        String packageName = args[0];
        String packageNameCaps = packageName.substring(0,1).toUpperCase() + packageName.substring(1);
        
        String pomXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
            "    \n" +
            "    <modelVersion>4.0.0</modelVersion>\n" +
            "\n" +
            "    <parent>\n" +
            "        <groupId>com.cleo</groupId>\n" +
            "        <artifactId>parent</artifactId>\n" +
            "        <version>5.2.2-SNAPSHOT</version>\n" +
            "        <relativePath>../parent/pom.xml</relativePath>\n" +
            "    </parent>\n" +
            "\n" +
            "    <groupId>com.cleo." + packageName + "</groupId>\n" +
            "    <artifactId>" + packageName + "</artifactId>\n" +
            "    <packaging>pom</packaging>\n" +
            "    <name>Cleo :: " + packageNameCaps + "</name>\n" +
            "    \n" +
            "    <modules>        \n";
        
        for(int i=1; i<args.length; ++i)
        {
            pomXML += "        <module>" + args[i] + "</module>\n";
        }
        
        pomXML += "    </modules>\n" +
            "</project>";
        
        //Write updated POM to disk
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File("../efss-maven/" + packageName + "/pom.xml")));
            bw.write(pomXML);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null) try { bw.close(); } catch(IOException exx) {}
        }
    }
    
}
