package can.springframework.petclinic.services;

import can.springframework.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
