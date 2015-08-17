/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencybuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rpassmore
 */
public class UpdateCleoRemap {
    
    public static final Map<String,String> projects = new HashMap<>();
    
    public static void read() 
    {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("cleo.prop")));
            
            String line = "";
            while((line=reader.readLine()) != null)
                projects.put(line.substring(0, line.indexOf(":")), line.substring(line.indexOf(":")+1));
            
        } catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            if(reader != null) try { reader.close(); } catch(Exception e) {}
        }
    }
    
    public static void update(String newLocation, String newProject) 
    {
        BufferedWriter writer = null;
        
        read();
        
        projects.put(newProject, newLocation);
    
        try {
            writer = new BufferedWriter(new FileWriter(new File("cleo.prop")));
            
            for(String project : projects.keySet()) 
            {
                String location = projects.get(project);
                writer.write(project + ":" + location);
                writer.newLine();
            }
            
        } catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            if(writer != null) try { writer.close(); } catch(Exception e) {}
        }
    }
}
