package com.sample;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class PathDemo {
    
    public static void main(String[] args) {
        // FileSystem：建立 Path 或 其他存取檔案系統的物件
        // Path：用來定義檔案或目錄
        // Files：用來操作檔案或目錄
        FileSystem fileSystem = FileSystems.getDefault();
        System.out.println("fileSystem：" + fileSystem);
        Path p1 = fileSystem.getPath("c:\\home\\oracle\\labs\\resources\\myfile.txt");
        System.out.println("p1：" + p1);
        Path p2 = fileSystem.getPath("c:", "home", "oracle", "labs", "resources", "myfile.txt");
        System.out.println("p2：" + p2);
        Path p3 = fileSystem.getPath("c:/home/oracle/labs/resources/myfile.txt");
        System.out.println("p3：" + p3);
        Path p4 = fileSystem.getPath("/home/oracle/labs/resources/myfile.txt");
        System.out.println("p4：" + p4);
        System.out.println("-------------------------");

        Path path1 = Paths.get("c:", "home", "oracle", "labs", "resources", "myFile.txt");
        System.out.println("path1 --> "+path1);     // c:\home\oracle\labs\resources\myFile.txt
        System.out.println("path1.getFileName() --> "+path1.getFileName()); // myFile.txt
        System.out.println("path1.getParent() --> "+path1.getParent()); // c:\home\oracle\labs\resources
        System.out.println("path1.isAbsolute() --> "+path1.isAbsolute());   // true
        System.out.println("path1.toAbsolutePath() --> "+path1.toAbsolutePath());   // c:\home\oracle\labs\resources\myFile.txt 
        System.out.println("path1.getRoot() --> "+path1.getRoot()); // c:\ 
        System.out.println("path1.getName(2) --> "+path1.getName(2)); // labs
        System.out.println("path1.subpath(0, 2) --> "+path1.subpath(0, 2)); // home\oracle
        System.out.println("path1.toUri() --> "+path1.toUri()); // file:///c:/home/oracle/labs/resources/myFile.txt
        
        //------------------------------------------------------------------------------------------        
        System.out.println("去除冗餘資訊-------------------------");
        Path path2 = Paths.get("c:/temp/company/../../pcschool/student.txt");
        System.out.println("path2 --> "+path2); 
        Path newPath2 = path2.normalize();
        System.out.println("newPath2 --> "+newPath2); //c:\pcschool\student.txt
        
        Path path3 = Paths.get("c:/temp/company/./../pcschool/student.txt");
        System.out.println("path3 --> "+path3); 
        Path newPath3 = path3.normalize();
        System.out.println("newPath3 --> "+newPath3); //c:\temp\pcschool\student.txt
        
        System.out.println("路徑合併-------------------------");
        Path path4 = Paths.get("c:/temp/company/pcschool");
        Path path5;
        path5 = Paths.get("student.txt");  //c:\temp\company\pcschool\student.txt
        path5 = Paths.get("/student.txt"); //c:\student.txt
        path5 = Paths.get("../../student.txt"); //c:\temp\company\pcschool\..\..\student.txt
        path5 = Paths.get("java/student.txt");  //c:\temp\company\pcschool\java\student.txt
        path5 = Paths.get("/java/student.txt");  //c:\java\student.txt
        
        Path newPath5 = path4.resolve(path5);
        System.out.println("newPath5 --> "+newPath5);
        
        System.out.println("路徑切換-------------------------");
        Path path6 = Paths.get("c:/temp/company/pcschool/java");
        Path path7 = Paths.get("c:/gjun/android");
        Path temp = path6.relativize(path7);
        System.out.println("temp --> "+temp); //..\..\..\..\gjun\android
    }
}
