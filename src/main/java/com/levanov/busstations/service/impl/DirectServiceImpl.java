package com.levanov.busstations.service.impl;

import com.levanov.busstations.service.DirectService;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class DirectServiceImpl implements DirectService {

    @Override
    public String findDirect(Integer firstStation, Integer secondStation) {
        long time = System.currentTimeMillis();
        String firstBusStation = " " + Integer.toString(firstStation) + " ";
        String secondBusStation = " " + Integer.toString(secondStation) + " ";
        String directIsExist = "false";


        File file = new File("src/main/resources/static/1.txt");

        try {


            directIsExist = getDirectIsExist(firstBusStation, secondBusStation, directIsExist, file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(System.currentTimeMillis() - time);
        return directIsExist;
    }

    private static String getDirectIsExist(String firstBusStation, String secondBusStation, String directIsExist, File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();
        while (line != null) {

            line = line + " ";
            if ((line.contains(firstBusStation) && line.contains(secondBusStation)) && line.indexOf(firstBusStation) < line.indexOf(secondBusStation)) {
                directIsExist = "true";
                break;
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        return directIsExist;
    }
}
