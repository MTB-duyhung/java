/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21p0062;

import java.io.File;

/**
 *
 * @author Admin
 */
public class Method {

    public void checkInputPath() {
        System.out.println("Please input Path: ");
        String path = Validation.checkInputString();
        File file = new File(path);
        if (file.isFile()) {
            System.out.println("Disk: " + getDisk(path));
            System.out.println("Extension: " + getExtension(path));
            System.out.println("File name: " + getFileName(path));
            System.out.println("Path: " + getPath(path));
            System.out.println("Folders: " + getFolder(path));
        } else {
            System.err.println("Path is not file.");
        }
    }

    private String getPath(String path) {
        int toNameFile = path.lastIndexOf("\\");
        return path.substring(0, toNameFile);
    }

    private String getFileName(String path) {
        int positionFrom = path.lastIndexOf("\\");
        int positionTo = path.lastIndexOf(".");
        return path.substring(positionFrom + 1, positionTo);
    }

    private String getExtension(String path) {
        int positionDot = path.lastIndexOf(".");
        return path.substring(positionDot + 1);
    }

    private String getDisk(String path) {
        int positionColon = path.indexOf("\\");
        return path.substring(0, positionColon);
    }

    private String getFolder(String path) {
        int positionColon = path.indexOf("\\");
        int positionLastColon = path.lastIndexOf("\\");
        return path.substring(positionColon + 1, positionLastColon);
    }
}
