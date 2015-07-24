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
        
        String outFile = pom.getPOMStart(packageName, project);
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(pomName)));
            String line = "";
            while((line=br.readLine()) != null) {
                if(line.trim().startsWith("<dependency>"))
                {
                    boolean isJunit = false;
                    boolean isMockito = false;
                    outFile += '\n' + line + '\n';
                    while((line=br.readLine()) != null && !line.trim().startsWith("</dependency>")) {
                        if(line.trim().startsWith("<groupId>junit"))
                            isJunit = true;
                        if(line.trim().startsWith("<groupId>org.mockito"))
                            isMockito = true;
                        if(line.trim().startsWith("<version>${"))
                        {
                            if(isJunit)
                            {
                                outFile += "      <version>${version.cleo.junit}</version>\n";
                                isJunit = false;
                            }
                            else if(isMockito)
                            {
                                outFile += "      <version>${version.cleo.mockito-all}</version>\n";
                                isMockito = false;
                            }
                            else
                                outFile += "      <version>${version.cleo}</version>\n";
                        }
                        else
                            outFile += line + '\n';
                    }
                    outFile += line + '\n';    //</dependency>
                }
                else if(line.trim().startsWith("</dependencies>"))
                    break;
            }
            
            outFile += pom.finishDependencies();
            outFile += pom.finishPOM();
            
            pom.writePOM(newProjectLocation, outFile);
            
        } catch(IOException ex) {
            System.out.println();
        } finally {
            if(br!=null) try { br.close(); } catch(IOException exx) {}
        }
    }
    
}
