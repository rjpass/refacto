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
        
        POM pom = new POM();
        String pomXML = pom.getPOMStart(parent, project);
        
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
                
                StringTokenizer st = null;
                if(slashRight)
                    st = new StringTokenizer(value, "/");
                else
                    st = new StringTokenizer(value, "\\");
                
                int i=0;
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
                    
                    ++i;
                }
                
                //reconfigure the protocol beans with megacol to support builds
                if  ( parent.equals("protocol") && 
                        (
                            parsedValue.equals("lexbean") ||
                            parsedValue.equals("as2bean") ||
                            parsedValue.equals("ebicsbean") ||
                            parsedValue.equals("ebxmlbean") ||
                            parsedValue.equals("ftp") ||
                            parsedValue.equals("ftps") ||
                            parsedValue.equals("httpbean") ||
                            parsedValue.equals("httpsbean") ||
                            parsedValue.equals("mqbean") ||
                            parsedValue.equals("oftpbean") ||
                            parsedValue.equals("rosettabean") ||
                            parsedValue.equals("smtpbean") ||
                            parsedValue.equals("wsbean")
                        )
                    )
                {
                    if(!addedMegacol)
                        pomXML += pom.buildDependency("megacol", false, "com.cleo.protocol", "5.2.1-SNAPSHOT");
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
        
        pomXML += pom.finishPOM();
        
        pom.writePOM(newProjectLocation, pomXML);
    }
}
