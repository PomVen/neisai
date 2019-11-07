package com.hallth.service;

import com.hallth.domain.MytyAgenda;

import java.util.List;

public interface MytyAgendaService {
    List<MytyAgenda> getNewAgendaDetail(int roundNo);

    MytyAgenda getNewAgenda();

}
