package io.github.arnascizi.bl.repository;

import io.github.arnascizi.enums.SeasonEnum;
import io.github.arnascizi.model.Item;
import io.github.arnascizi.model.Item_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NonNull;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ItemRepository extends SimpleJpaRepository<Item, Long> {

    @PersistenceContext
    private EntityManager em;

    public ItemRepository(EntityManager em) {
        super(JpaEntityInformationSupport.getEntityInformation(Item.class, em), em);
    }

    public List<Item> getAllItems() {
        return findAll();
    }

    public List<Item> getItemsBySeason(@NonNull String season) {
        return findAll((root, query, cb) -> cb.or(cb.equal(root.get(Item_.recommendedSeason), season),
                cb.equal(root.get(Item_.recommendedSeason), SeasonEnum.ALL.name())));
    }
}
