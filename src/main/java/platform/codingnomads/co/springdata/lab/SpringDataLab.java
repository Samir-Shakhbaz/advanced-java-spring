package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.DestinationUnknown;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.DestinationUnknownRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;
import platform.codingnomads.co.springdata.lab_complete.models.PointOfInterest;


import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;

    private final DestinationUnknownRepository destinationUnknownRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (areaRepository.findAll().size() == 0) {
            final List<Area> areas = areaRepository.saveAll(
                    Arrays.asList(
                            Area.builder().code("G").build(),
                            Area.builder().code("H").build(),
                            Area.builder().code("Y").build(),
                            Area.builder().code("Z").build(),
                            Area.builder().code("K").build(),
                            Area.builder().code("L").build(),
                            Area.builder().code("M").build(),
                            Area.builder().code("N").build()

                    )
            );
        }


        if(routeRepository.findAll().size() == 0){
            final List<Route> myRoute = routeRepository.saveAll(
            Arrays.asList(
                Route.builder().origin(areaRepository.findByCode("M"))
                        .destination(areaRepository.findByCode("N")).build(),
                Route.builder().origin(areaRepository.findByCode("L"))
                        .destination(areaRepository.findByCode("Y")).build()
                    )
            );
        }

        if(destinationUnknownRepository.findAll().size() == 0){
            DestinationUnknown destinationUnknown = new DestinationUnknown("pharmacy", "store",
                    areaRepository.findByCode("L"));
                    destinationUnknown.addRoutes(routeRepository.findAllByCodeContaining("L"));
        }

        System.out.println(routeRepository.findByOrigin_code("Z"));
        System.out.println(routeRepository.findAllByCodeContaining("K"));

    }

}