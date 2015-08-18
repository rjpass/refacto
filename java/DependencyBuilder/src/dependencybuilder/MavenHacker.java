/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencybuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rpassmore
 */
public class MavenHacker {
    
    public static void main(String[] args)
    {
        if(args.length != 4)
            return;
        
        POM pom = new POM();
        
        String newProjectLocation = args[0];
        String pomName = args[1];
        String packageName = args[2];
        String project = args[3];
        
        Set<String> dependencies = new HashSet<>();
        
        String outFile = pom.getPOMStart(packageName, project);
        UpdateCleoRemap.read();
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(pomName)));
            String line;
            while((line=br.readLine()) != null) {
                if(line.trim().startsWith("<dependency>"))
                {
                    String artifactId = "";
                    
                    while((line=br.readLine()) != null && !line.trim().startsWith("</dependency>")) 
                    {       
                        if(line.trim().startsWith("<artifactId>"))
                            artifactId = line.substring(line.indexOf(">")+1, line.lastIndexOf("<")).trim();
                    }
                    
                    dependencies.add(artifactId);
                }
                else if(line.trim().startsWith("</dependencies>"))
                    break;
            }
            
            for(String artifactId : dependencies)
            {
                boolean isTest = false;
                if(artifactId.equalsIgnoreCase("powermock-easymock-1.5.1-full") ||
                    artifactId.toLowerCase().equals("junit-4.10") ||
                    artifactId.toLowerCase().equals("powermock-mockito-1.5.1-full") ||
                    artifactId.toLowerCase().equals("mockito-all-1.9.5") ||
                    artifactId.toLowerCase().equals("easymock-3.1") ||
                    artifactId.toLowerCase().equals("testng-6.8") ||
                    artifactId.toLowerCase().equals("cglib-nodep-2.2.2")
                )
                {
                    isTest = true;
                }
                    
                outFile += pom.buildDependency(artifactId, isTest);
            }
            
            outFile += pom.finishDependencies();
            outFile += pom.finishPOM();
            
            pom.writePOM(newProjectLocation, outFile);
            
        } catch(IOException ex) {
            System.out.println();
        } finally {
            if(br!=null) try { br.close(); } catch(IOException exx) {}
        }
        
        //update this dep for other projects
        UpdateCleoRemap.update(packageName, project);
    }
    
}
