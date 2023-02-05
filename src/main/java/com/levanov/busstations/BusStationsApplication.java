package com.levanov.busstations;

import com.levanov.busstations.entity.Direct;
import com.levanov.busstations.entity.Station;
import com.levanov.busstations.repository.DirectRepository;
import com.levanov.busstations.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class BusStationsApplication {

    @Autowired
    static
    StationRepository stationRepository;
    @Autowired
    static
    DirectRepository directRepository;

    public BusStationsApplication(StationRepository stationRepository, DirectRepository directRepository) {
        this.stationRepository = stationRepository;
        this.directRepository = directRepository;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BusStationsApplication.class, args);

        File file = new File("src/main/resources/static/1.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        String str = bufferedReader.readLine();
        while (str != null) {
            String[] words = str.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (i == 0) {
                    System.out.println("id direct " + words[i]);
                    Direct direct = new Direct();
                    direct.setCode(Integer.valueOf(words[i]));
                    directRepository.save(direct);
                } else {

                    Station station = new Station();
                    station.setCode(Integer.valueOf(words[i]));
                    station.setPosition(i);
                    station.setDirectsCode(Integer.valueOf(words[0]));
                    stationRepository.save(station);
                }

            }
            System.out.println();
            str = bufferedReader.readLine();

        }
        System.out.println(directRepository.findAll());
    }

}
