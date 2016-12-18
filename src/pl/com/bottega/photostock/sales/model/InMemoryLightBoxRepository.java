package pl.com.bottega.photostock.sales.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by bottega on 17.12.2016.   kodzik Kuby

public class InMemoryLightBoxRepository implements LightBoxRepository {
    Map<Client, Collection<LightBox>> repository = new HashMap<>();

    @Override
    public void put (LightBox 1){
        Client owner = 1.getOwner();
        repository.putIfAbsent(owner, new HashSet<>());
        Collection<LightBox> ownerLightBoxes = repository.get(owner);
        ownerLightBoxes.add(1);
    }

    @Override
    public Collection<LightBox> getFor(Client client){
        return repository.get(client);
    }
}
*/