package tr.gov.tubitak.bilgem.yte;

import java.io.*;
import java.util.Scanner;

class ReadTextFile {

    static StringBuilder read(String fileName) {
        System.out.println("The text file is loading...");
        StringBuilder text = new StringBuilder();
        File file = new File("/Users/fatihsaracoglu/IdeaProjects/text-to-speech/src/main/java/tr/gov/tubitak/bilgem/yte/text/" + fileName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                text.append(sc.nextLine()).append(" ");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return text;
    }

}
