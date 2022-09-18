package mpinard.planes.adapter.mockrepo.common;

import lombok.experimental.FieldDefaults;
import mpinard.planes.domain.common.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.StreamSupport;

@FieldDefaults(makeFinal = true)
public class FakeRepository<T> implements Repository<T> {

    private CopyOnWriteArrayList<T> saved = new CopyOnWriteArrayList<>();

    @Override
    public List<T> findAll() {
        return List.copyOf(saved);
    }

    @Override
    public List<T> saveAll(Iterable<T> toBeSaved) {
        saved.addAll(StreamSupport.stream(toBeSaved.spliterator(), false).toList());
        return List.copyOf(saved);
    }
}
