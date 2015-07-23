/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencybuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author rpassmore
 */
public class DependencyBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length != 4)
            return;
        
        String oldProjectLocation = args[0];
        String newProjectLocation = args[1];
        String parent = args[2];
        String project = args[3];
        
        String parentCaps = parent.substring(0,1).toUpperCase() + parent.substring(1);
        
        //load the project.properties file
            String buildXML = oldProjectLocation + "/" + "nbproject/project.properties";
        Properties buildProp = new Properties();
        
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(buildXML);
            buildProp.load(inputStream);
        } catch(IOException ex) {
            
        } finally {
            if(inputStream != null) try {inputStream.close();} catch(IOException exx) {}
        }
        
        String pomXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
            "\n" +
            "    <modelVersion>4.0.0</modelVersion>\n" +
            "\n" +
            "    <parent>\n" +
            "        <artifactId>" + parent + "</artifactId>\n" +
            "        <groupId>com.cleo." + parent + "</groupId>\n" +
            "        <version>5.2.1-SNAPSHOT</version>\n" +
            "    </parent>\n" +
            "\n" +
            "    <artifactId>com.cleo." + parent + "." + project + "</artifactId>\n" +
            "    <packaging>jar</packaging>\n" +
            "    <name>Cleo :: " + parentCaps + " :: " + project + "</name>\n" +
            "\n" +
            "    <properties>\n" +
            "        <cleo.version>5.2-SNAPSHOT</cleo.version>\n" + 
            "    </properties>\n\n" +
            "    <dependencies>";
        
        for(Object key : buildProp.keySet())
        {
            String keyString = (String)key;
            if(keyString.startsWith("file.reference"))
            {
                String value = buildProp.getProperty(keyString);
                int sIndex = value.lastIndexOf('\\') + 1;
                int eIndex = value.lastIndexOf(".");
                String parsedValue = value.substring(sIndex, eIndex);
                pomXML += "\n        <dependency>\n" +
                    "            <groupId>com.cleo</groupId>\n" +
                    "            <artifactId>" + parsedValue + "</artifactId>\n" +
                    "            <version>${cleo.version}</version>\n" +     
                    "        </dependency>";
            }
        }
        
        pomXML += "\n    </dependencies>";
        pomXML += "\n</project>";
        
        //Write updated POM to disk
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(newProjectLocation + "/pom.xml")));
            bw.write(pomXML);
        } catch(IOException e) {
            
        } finally {
            if(bw != null) try { bw.close(); } catch(IOException exx) {}
        }
    }
}
