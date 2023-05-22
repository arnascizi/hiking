package io.github.arnascizi.bl.repository;

import io.github.arnascizi.model.Backpack;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BackpackRepository extends SimpleJpaRepository<Backpack, Long> {

    @PersistenceContext
    private EntityManager em;

    public BackpackRepository(EntityManager em) {
        super(JpaEntityInformationSupport.getEntityInformation(Backpack.class, em), em);
    }

    public List<Backpack> getAllBackpacks() {
        return findAll();
    }
}
