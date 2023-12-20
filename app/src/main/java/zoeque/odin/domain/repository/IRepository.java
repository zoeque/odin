package zoeque.odin.domain.repository;

import io.vavr.control.Try;
import zoeque.odin.domain.entity.OdinEntity;

/**
 * The interface of the repository class.
 */
public interface IRepository<T extends OdinEntity> {
    Try<T> save(T entity);
}
