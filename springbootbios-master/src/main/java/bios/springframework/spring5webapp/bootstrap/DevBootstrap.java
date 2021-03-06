package bios.springframework.spring5webapp.bootstrap;

import bios.springframework.spring5webapp.model.Zaal;
import bios.springframework.spring5webapp.model.Film;
import bios.springframework.spring5webapp.model.Tijden;
import bios.springframework.spring5webapp.repositories.TijdRepository;
import bios.springframework.spring5webapp.repositories.ZaalRepository;
import bios.springframework.spring5webapp.repositories.FilmRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ZaalRepository zaalRepository;
    private FilmRepository filmRepository;
    private TijdRepository tijdRepository;


    public DevBootstrap(ZaalRepository zaalRepository, FilmRepository filmRepository, TijdRepository tijdRepository) {
        this.zaalRepository = zaalRepository;
        this.filmRepository = filmRepository;
        this.tijdRepository = tijdRepository;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){



        //Zaal 1
        Zaal zaal = new Zaal("Zaal 1");
        Film ddd = new Film("James Bond");
        Tijden tijd1 = new Tijden("10:00");
        zaal.getFilms().add(ddd);
        ddd.getZalen().add(zaal);
        //tijd1.getBegintijden().add(tijd1);

        zaalRepository.save(zaal);
        filmRepository.save(ddd);
        tijdRepository.save(tijd1);


        //Zaal 2
        Zaal zaal2 = new Zaal("Zaal 2");
        Film noEJB = new Film("De Smurfen");
        zaal2.getFilms().add(noEJB);
        noEJB.getZalen().add(zaal2);

        zaalRepository.save(zaal2);
        filmRepository.save(noEJB);
    }

}
