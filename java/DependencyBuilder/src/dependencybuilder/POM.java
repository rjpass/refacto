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
import java.util.Map;

/**
 *
 * @author rpassmore
 */
public class POM {
    
    private Map<String,String> cleoMap = UpdateCleoRemap.projects;
    private ThirdPartyMavenMap thirdPartyMap = new ThirdPartyMavenMap();
    
    public String getPOMStart(String parent, String project) 
    {
        String parentCaps = parent.substring(0,1).toUpperCase() + parent.substring(1);
        
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
            "\n" +
            "    <modelVersion>4.0.0</modelVersion>\n" +
            "\n" +
            "    <parent>\n" +
            "        <groupId>com.cleo." + parent + "</groupId>\n" +
            "        <artifactId>" + parent + "</artifactId>\n" +
            "        <version>5.2.2-SNAPSHOT</version>\n" +
            "    </parent>\n" +
            "\n" +
            "    <groupId>com.cleo." + parent + "</groupId>\n" + 
            "    <artifactId>" + project + "</artifactId>\n" +
            "    <packaging>jar</packaging>\n" +
            "    <name>Cleo :: " + parentCaps + " :: " + project + "</name>\n" +
            "\n" +
            "    <dependencies>";
    }
    
    
    public String buildDependency(String artifactId, boolean isTest)
    {
        return buildDependency(artifactId, isTest, "com.cleo", "${version.cleo}");
    }
    
    public String buildDependency(String artifactId, boolean isTest, String groupId, String versionNumber)
    {
        UpdateCleoRemap.read();
        cleoMap = UpdateCleoRemap.projects;
        
        String pomXML =         "\n        <dependency>\n" +
                                "            <groupId>" + groupId + "</groupId>\n" +
                                "            <artifactId>" + artifactId + "</artifactId>\n" +
                                "            <version>" + versionNumber + "</version>\n";
        
        if(thirdPartyMap.get(artifactId) != null)
            pomXML = thirdPartyMap.get(artifactId);
        else if(cleoMap.get(artifactId) != null)
        {
            pomXML = "\n        <dependency>\n" +
                                "            <groupId>com.cleo." + cleoMap.get(artifactId) + "</groupId>\n" +
                                "            <artifactId>" + artifactId + "</artifactId>\n" +
                                "            <version>" + versionNumber + "</version>\n";
        }
        
        if(isTest)
            pomXML += "            <scope>test</scope>\n";
        
        if(
                thirdPartyMap.get(artifactId) == null || 
                artifactId.toLowerCase().equals("powermock-easymock-1.5.1-full") ||
                artifactId.toLowerCase().equals("junit-4.10") ||
                artifactId.toLowerCase().equals("powermock-mockito-1.5.1-full") ||
                artifactId.toLowerCase().equals("mockito-all-1.9.5") ||
                artifactId.toLowerCase().equals("easymock-3.1") ||
                artifactId.toLowerCase().equals("testng-6.8") ||
                artifactId.toLowerCase().equals("cglib-nodep-2.2.2")
                )
        {
            pomXML +=
                "        </dependency>";
        }
        
        return pomXML;
    }
    
    public String finishDependencies() {
        return "\n    </dependencies>";
    }
    
    public String updateEncoding(String encoding) {
        return  "\n\n    <build>\n" +
                "        <plugins>\n" +
                "            <plugin>\n" +
                "                <groupId>org.apache.maven.plugins</groupId>\n" +
                "                <artifactId>maven-compiler-plugin</artifactId>\n" +
                "                <configuration>\n" +
                "                    <source>${maven.compiler.source}</source>\n" +
                "                    <target>${maven.compiler.target}</target>\n" +
                "                    <debug>${maven.compiler.debug}</debug>\n" +
                "                    <encoding>" + encoding + "</encoding>\n" +
                "                    <maxmem>256M</maxmem>\n" +
                "                    <fork>${compiler.fork}</fork>\n" +
                "                </configuration>\n" +
                "            </plugin>\n" +
                "        </plugins>\n" +
                "    </build>";
    }
    
    public String finishPOM() {
        return "\n</project>";
    }
    
    public void writePOM(String location, String pomXML) {
        //Write updated POM to disk
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(location + "/pom.xml")));
            bw.write(pomXML);
        } catch(IOException e) {
            
        } finally {
            if(bw != null) try { bw.close(); } catch(IOException exx) {}
        }
    }
}
