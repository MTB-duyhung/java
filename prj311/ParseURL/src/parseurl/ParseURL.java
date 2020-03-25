/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parseurl;

import java.net.*;

/**
 *
 * @author Admin
 */
public class ParseURL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException {
        URL aURL=new URL("https://classroom.google.com/u/1/c/NTE5NzE5MTkxODha/a/NTM0MTQ4ODIxMjJa/details");
        System.out.println("protocol = "+aURL.getProtocol());
        System.out.println("authority = "+aURL.getAuthority());
        System.out.println("host = "+aURL.getHost());
        System.out.println("port = "+aURL.getPort());
        System.out.println("path = "+aURL.getPath());
        System.out.println("query = "+aURL.getQuery());
        System.out.println("filename = "+aURL.getFile());
        System.out.println("ref = "+aURL.getRef());
    }
    
}
