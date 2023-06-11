/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author User
 */
public class FilesDemo {
    
    public static void main(String[] args) {
        // 定義檔案目錄
        Path source = Paths.get("c:/com/example/java/hello.txt");
        System.out.println("source：" + source);
        Path targe = Paths.get("c:", "com", "sample", "python", "hi.txt");
        System.out.println("targe：" + targe);
        
        try {
            // 建立資料夾
            Files.createDirectories(source.getParent());
            Files.createDirectories(targe.getParent());
            // 建立檔案前先檢查檔案是否存在
            if(Files.exists(source)){
                System.out.println(source.getFileName() + " 檔案已存在");
            }else{
                // 建立檔案
                Files.createFile(source);
                System.out.println(source.getFileName() + " 檔案建立完成!");
            }
            
            // 判斷檔案是否可寫
            if(Files.isWritable(source)){
                System.out.println(source.getFileName() + " 檔案可寫");
                // 建立集合
                ArrayList<String> list = new ArrayList(Arrays.asList("Java SE 11", "巨匠電腦", LocalDateTime.now().toString()));
                Files.write(source, list, StandardOpenOption.APPEND);
                System.out.println("資料儲存完成");
            }else{
                System.out.println(source.getFileName() + " 檔案不可寫");
            }
            
            // 檔案複製
            // Files.copy(source, targe, StandardCopyOption.REPLACE_EXISTING);
            
            // 檔案刪除
            // Files.delete(targe);
            
            // 檔案移動
            // Files.move(source, targe, StandardCopyOption.REPLACE_EXISTING);
            
            // Path test = Paths.get("c:/com/android/test.txt");
            // 目標資料夾不存在 java.nio.file.NoSuchFileException
            // Files.move(source, test, StandardCopyOption.REPLACE_EXISTING);           

            // 下載網路圖片
//            String url = "http://fes4media.com/wp-content/uploads/2019/10/Oracle-Certification-badge_OC-Professional.png";
//            URI uri = URI.create(url);
//            Path ocp = Paths.get("javaocp.png");
//            try(InputStream in = uri.toURL().openStream()){
//                Files.copy(in, ocp, StandardCopyOption.REPLACE_EXISTING);
//            }catch (IOException ex){
//                System.out.println(ex);
//            }

            // 走訪資料夾(單層)
            Path path1 = Paths.get("."); // 當前的專案目錄
            System.out.println(path1.toAbsolutePath());
            Stream<Path> files1 = Files.list(path1);
            files1.forEach(System.out::println);
            System.out.println("-----------------------");
            // 走訪資料夾(每一層)
            Stream<Path> files2 = Files.walk(path1);
            files2.forEach(System.out::println);
            System.out.println("-----------------------");
            
            // 讀取資料，搭配 Stream
            try(BufferedReader br = new BufferedReader(new FileReader(source.toString()))){
                br.lines().forEach(System.out::println);
            }
            System.out.println("-----------------");
            
            try(Stream<String> lines = Files.lines(source)){
                lines.forEach(System.out::println);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
