package com.levanov.busstations.service.impl;

import com.levanov.busstations.entity.Station;
import com.levanov.busstations.repository.StationRepository;

import com.levanov.busstations.service.DirectServiceH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class DirectServiceH2Impl implements DirectServiceH2 {

    @Autowired
    StationRepository stationRepository;

    @Override
    public String findDirectH2(Integer firstStation, Integer secondStation) {
        long time = System.currentTimeMillis();
        String directIsExist = "false";

        ArrayList<Station> stationArrayListFrom = stationRepository.findAllByCode(firstStation);
        ArrayList<Station> stationArrayListTo = stationRepository.findAllByCode(secondStation);

        for (Station stationFrom : stationArrayListFrom) {
            for (Station stationTo : stationArrayListTo) {
                if (stationFrom.getPosition() < stationTo.getPosition()
                        && stationFrom.getDirectsCode().equals(stationTo.getDirectsCode())){

                    directIsExist = "true";
                    break;
                }

            }

        }

        System.out.println(System.currentTimeMillis() - time);
        return directIsExist;
    }
}
