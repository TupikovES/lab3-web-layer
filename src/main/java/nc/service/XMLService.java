package nc.service;

import nc.entity.NCObject;

import java.util.List;

/**
 * <p>Интерфейс сервиса для подготовки экспортируемых объектов
 * из базы данных.
 * </p>
 */
public interface XMLService {

    List<NCObject> getObjectListById(String... args);

}
