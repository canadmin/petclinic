package can.springframework.petclinic.bootstrap;

import can.springframework.petclinic.model.Owner;
import can.springframework.petclinic.model.Vet;
import can.springframework.petclinic.services.OwnerService;
import can.springframework.petclinic.services.VetService;
import can.springframework.petclinic.services.map.OwnerServiceMap;
import can.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoad implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoad() {
    ownerService=new OwnerServiceMap();
    vetService=new VetServiceMap();


    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Can");
        owner1.setLastName("Yard");

        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mustafa");
        owner2.setFirstName("coskun");

        ownerService.save(owner2);

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2=new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet2);


    }
}
