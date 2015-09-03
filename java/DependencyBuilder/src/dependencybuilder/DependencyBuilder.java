/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencybuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

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
        
        boolean addedMegacol = false;
        Set<String> addedDependencies = new HashSet<>();
        
        POM pom = new POM();
        String pomXML = pom.getPOMStart(parent, project);
        
        if(project.equalsIgnoreCase("lexicom"))
        {
            addedDependencies.add("javax.servlet");
            pomXML += pom.buildDependency("javax.servlet", false);
        }
        
        for(Object key : buildProp.keySet())
        {
            String keyString = (String)key;
            if(keyString.startsWith("file.reference"))
            {
                String value = buildProp.getProperty(keyString);
                int sIndex = value.lastIndexOf('\\') + 1;
                int eIndex = value.lastIndexOf(".");
                
                boolean slashRight = false;
                if(sIndex == 0 || eIndex < sIndex)
                {
                    sIndex = value.lastIndexOf('/') + 1;
                    eIndex = value.lastIndexOf(".");
                    if(sIndex == 0 || eIndex < sIndex)
                        continue;
                    
                    slashRight = true;
                }
                
                String parsedValue = value.substring(sIndex, eIndex);
                
                if(parsedValue.equalsIgnoreCase("ftp"))
                    parsedValue = "ftpbean";
                else if(parsedValue.equalsIgnoreCase("ftps"))
                    parsedValue = "ftpsbean";
                else if(parsedValue.equalsIgnoreCase("sftpserver"))
                    parsedValue = "SftpServer";
                else if(parsedValue.equalsIgnoreCase("webserver"))
                    parsedValue = "WebServer";
                
                if(addedDependencies.contains(parsedValue))
                    continue;
                else
                    addedDependencies.add(parsedValue);
                
                StringTokenizer st = null;
                if(slashRight)
                    st = new StringTokenizer(value, "/");
                else
                    st = new StringTokenizer(value, "\\");
                
                boolean isTest = false;
                while(st.hasMoreTokens())
                {
                    String nextToken = st.nextToken();
                    if(nextToken.equals("test") && 
                            !project.toLowerCase().equals("jcapi") &&
                            !project.toLowerCase().equals("httpclient"))
                    {
                        isTest = true;
                        break;
                    }
                }
                
                //reconfigure the protocol beans with megacol to support builds
                if  ( (parent.equals("protocol") || project.equals("lexbean")) && 
                        (
                            parsedValue.equals("lexbean") ||
                            parsedValue.equals("as2bean") ||
                            parsedValue.equals("ebicsbean") ||
                            parsedValue.equals("ebxmlbean") ||
                            parsedValue.equals("ftpbean") ||
                            parsedValue.equals("ftpsbean") ||
                            parsedValue.equals("httpbean") ||
                            parsedValue.equals("httpsbean") ||
                            parsedValue.equals("mqbean") ||
                            parsedValue.equals("oftpbean") ||
                            parsedValue.equals("rosettabean") ||
                            parsedValue.equals("smtpbean") ||
                            parsedValue.equals("wsbean") ||
                            parsedValue.equals("webserver") ||
                            parsedValue.equals("mailbean") ||
                            parsedValue.equals("lexhelp")
                        )   
                    )
                {
                    if(!addedMegacol)
                        pomXML += pom.buildDependency("megacol", false, "com.cleo.api", "5.2.2-SNAPSHOT");
                    addedMegacol = true;
                }
                else
                {
                    pomXML += pom.buildDependency(parsedValue, isTest);
                }
            }
        }
        
        pomXML += pom.finishDependencies();
        
        //stupid jcapi... doesn't use UTF-8 files
        if(project.toLowerCase().equals("jcapi"))
        {
            pomXML += pom.updateEncoding("ISO-8859-1");
        } 
        else if(project.toLowerCase().equals("j2ssh"))
        {
            pomXML = pom.getPOMStart(parent, project);
            pomXML += pom.buildDependency("commons-logging", false);
            pomXML += pom.buildDependency("xercesImpl", false);
            pomXML += pom.buildDependency("xmlParserAPIs", false);
            pomXML += pom.buildDependency("jce-jdk13-119", false);
            pomXML += pom.buildDependency("ant", false);
            pomXML += pom.buildDependency("HTTPClient", false);
            pomXML += pom.finishDependencies();
        }
        
        pomXML += pom.finishPOM();
        
        pom.writePOM(newProjectLocation, pomXML);
        
        //update this dep for other projects
        UpdateCleoRemap.update(parent, project);
    }
}
