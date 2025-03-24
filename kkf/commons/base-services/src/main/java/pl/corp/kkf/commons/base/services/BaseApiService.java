package pl.corp.kkf.commons.base.services;

public interface BaseApiService<T> {

    T get(long id);

    T create(T dto);

    T update(T dto);

    T delete(long id);

}
