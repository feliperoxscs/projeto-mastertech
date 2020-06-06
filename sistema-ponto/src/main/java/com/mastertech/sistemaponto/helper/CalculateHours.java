package com.mastertech.sistemaponto.helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mastertech.sistemaponto.model.BatidaPonto;



public class CalculateHours {

    private static String TIPO_BATIDA_ENTRADA = "entrada";

    public static String calulateHours(List<BatidaPonto> batidasPonto) {
        Date totalHoras = new Date();
        List<Date> entradas = new ArrayList<>();
        List<Date> saidas = new ArrayList<>();
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        batidasPonto.forEach(batidaPonto -> {
            if(batidaPonto.getTipoBatida().equalsIgnoreCase(TIPO_BATIDA_ENTRADA)){
                entradas.add(batidaPonto.getDataBatida());
            } 
            else {
                saidas.add(batidaPonto.getDataBatida());
            }
        });

        for(int i=0;i < entradas.size();i++) {
            hours += saidas.get(i).getHours() - entradas.get(i).getHours();
            minutes += saidas.get(i).getMinutes() - entradas.get(i).getMinutes();
            seconds += saidas.get(i).getSeconds() - entradas.get(i).getSeconds();
        }
        totalHoras.setHours(hours);
        totalHoras.setMinutes(minutes);
        totalHoras.setSeconds(seconds);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(totalHoras);

    }
}