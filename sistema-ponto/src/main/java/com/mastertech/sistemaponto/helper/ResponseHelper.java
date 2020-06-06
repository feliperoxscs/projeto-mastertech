package com.mastertech.sistemaponto.helper;

import java.util.List;

import com.mastertech.sistemaponto.model.BatidaPonto;

public class ResponseHelper {
    
    private List<BatidaPonto> batidasPonto;
    
    private String totalHorasTrabalhadas;

    public List<BatidaPonto> getBatidasPonto() {
        return batidasPonto;
    }

    public void setBatidasPonto(List<BatidaPonto> batidasPonto) {
        this.batidasPonto = batidasPonto;
    }

    public String getTotalHorasTrabalhadas() {
        return totalHorasTrabalhadas;
    }

    public void setTotalHorasTrabalhadas(String totalHorasTrabalhadas) {
        this.totalHorasTrabalhadas = totalHorasTrabalhadas;
    }
}