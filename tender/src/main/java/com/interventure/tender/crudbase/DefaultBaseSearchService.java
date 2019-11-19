package com.interventure.tender.crudbase;

import com.interventure.tender.service.BaseSearchService;
import com.interventure.tender.service.dto.BaseDto;
import org.dozer.DozerBeanMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class DefaultBaseSearchService<
        E extends BaseEntity,
        F extends BaseFilter,
        S extends BaseSpec<E, F>,
        R extends JpaRepositoryImplementation<E, Long>> implements BaseSearchService<E, F> {

    private final R repository;
    private final S spec;
    private final DozerBeanMapper dozerBeanMapper;

    protected DefaultBaseSearchService(R repository, S spec, DozerBeanMapper dozerBeanMapper) {
        this.repository = repository;
        this.spec = spec;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public <D extends BaseDto> List<D> findAllAndConvert(Class<D> outClass) {
        List<E> all = findAll();
        return convertList(all, outClass);
    }

    public List<E> findAll(F filter) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification);
    }

    public <D extends BaseDto> List<D> findAllAndConvert(F filter, Class<D> outClass) {
        List<E> all = findAll(filter);
        return convertList(all, outClass);
    }

    public E findOne(Long id) {
        Optional<E> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public <D extends BaseDto> D findOneAndConvert(Long id, Class<D> outClass) {
        E entity = repository.findById(id).orElse(null);
        return convertEntity(entity, outClass);
    }

    private <D extends BaseDto> D convertEntity(E entity, Class<D> outClass) {
        return entity != null ? dozerBeanMapper.map(entity, outClass) : null;
    }

    private <D extends BaseDto> List<D> convertList(List<E> entities, Class<D> outClass) {
        return entities.stream().map(e -> convertEntity(e, outClass)).collect(Collectors.toList());
    }
}
