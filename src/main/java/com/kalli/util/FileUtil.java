package com.kalli.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public FileUtil() {
    }

    public File createFile(String fileName){
        try {
            File file = new File("C:\\Users\\johnr\\Desktop\\" + fileName);
            if (file.createNewFile()) {
                logger.info("File created: " + file.getName());
            } else {
                logger.info("File already exists.");
            }

            return file;
        } catch (IOException e) {
            logger.error("ERROR IN CREATING FILE.");
            e.printStackTrace();
        }
        return null;
    }

    public void writeToFile(String fileName, String input){
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\johnr\\Desktop\\" + fileName);

            fileWriter.write(input);
            fileWriter.close();

            logger.info("Successfully wrote to the file.");
        }
        catch (IOException e) {
            logger.error("ERROR IN WRITING TO FILE.");
            e.printStackTrace();
        }

    }
}
