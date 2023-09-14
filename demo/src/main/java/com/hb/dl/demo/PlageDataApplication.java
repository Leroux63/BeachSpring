package com.hb.dl.demo;

import com.hb.dl.demo.models.Plage;
import com.hb.dl.demo.services.PlageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlageDataApplication {

    private Logger logger = LoggerFactory.getLogger(PlageDataApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PlageDataApplication.class);
    }

    @Bean
    public CommandLineRunner dataLoader(PlageService plageService) {
        return args -> {
            logger.info("Création d'une plage");
            if (plageService.findByName("Une belle plage sur la Côte d'Azur.").isEmpty()) {
                Plage plage1 = new Plage("Une belle plage sur la Côte d'Azur.", "45", "Les quais", "06000", "Nice");
                plageService.addPlage(plage1);
            }
            if (plageService.findByName("Plage de Biarritz").isEmpty()) {
                Plage plage2 = new Plage("Plage de Biarritz", "84", "Le rouleau", "64200", "Biarritz", "https://tourisme.biarritz.fr/sites/default/files/plage_du_port_vieux_biarritz.jpg");
                plageService.addPlage(plage2);
            }
            if (plageService.findByName("Plage de Cannes").isEmpty()) {
                Plage plage3 = new Plage("Plage de Cannes", "69", "La croisette", "06400", "Cannes", "https://i.f1g.fr/media/eidos/805x453_crop/2018/02/08/XVM7aaa6944-0c28-11e8-9bc2-6afb2a70ff2c-805x453.jpg");
                plageService.addPlage(plage3);
            }
            if (plageService.findByName("Plage de La Baule").isEmpty()) {
                Plage plage5 = new Plage("Plage de La Baule", "456", "La baie du bonheur", "44500", "La Baule", "https://www.levoyageanantes.fr/wp-content/uploads/2022/03/Traversee-Moderne-d-un-Vieux-Pays-La-Baule-OTI-La-Baule-Presqu-ile-de-Guerande_A.Lamoureux_.jpg");
                plageService.addPlage(plage5);
            }
            if (plageService.findByName("Plage de Saint-Malo").isEmpty()) {
                Plage plage6 = new Plage("Plage de Saint-Malo", "124", "La jetée", "35400", "Saint-Malo", "https://www.lepetittrain-saintmalo.com/wp-content/uploads/2021/01/crtb-ad5573_LAMOUREUX-Alexandre-scaled.jpg");
                plageService.addPlage(plage6);
            }
            if (plageService.findByName("La plage de saint Trop").isEmpty()) {
                Plage plage7 = new Plage("La plage de saint Trop", "45", "Le bout du monde", "06145", "St-Tropez", "https://a.cdn-hotels.com/gdcs/production97/d1300/521b740f-8518-424b-98f4-5fee3d010b9d.jpg");
                plageService.addPlage(plage7);
            }
        };
    }
}
