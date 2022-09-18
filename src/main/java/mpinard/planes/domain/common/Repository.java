package mpinard.planes.domain.common;

import java.util.List;

public interface Repository<T> {

    List<T> findAll();

    List<T> saveAll(Iterable<T> domainObjects);
}
