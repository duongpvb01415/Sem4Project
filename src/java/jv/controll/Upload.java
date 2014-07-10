/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jv.controll;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Windows
 */
public class Upload {
    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;
    
    public boolean uploadImag() {
        destPath = "D:\\ProjectSem4\\Project_3\\web\\upload\\";
        try {
            System.out.println("Src File name: " + myFile);
            System.out.println("Dst File name: " + myFileFileName);

            File destFile = new File(destPath, myFileFileName);
            FileUtils.copyFile(myFile, destFile);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
