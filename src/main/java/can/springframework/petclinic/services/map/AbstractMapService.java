package can.springframework.petclinic.services.map;

import can.springframework.petclinic.model.BaseEntity;

import java.util.*;


public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if(object != null){ // nesne boş değil
            if(object.getId() == null){ // ve id verilmemiş ise en büyük id nin bir fazlasını veriyoruz
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        }else{
            throw  new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }
    void delete(T object){
        map.entrySet().removeIf(entry->entry.getValue().equals(object));
    }
    private Long getNextId(){ // otomatik ıd verme özelliğini aktifleştiriyoruz
        Long nextId=null;
        try{
            nextId=Collections.max(map.keySet())+1;
        }catch (Exception e){
            nextId=1L;
        }

        return nextId;
    }
}
