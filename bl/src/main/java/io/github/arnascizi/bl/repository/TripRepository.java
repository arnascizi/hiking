package io.github.arnascizi.bl.repository;

import io.github.arnascizi.model.Trip;
import io.github.arnascizi.model.Trip_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TripRepository extends SimpleJpaRepository<Trip, Long> {

    @PersistenceContext
    private EntityManager em;

    public TripRepository(EntityManager entityManager) {
        super(JpaEntityInformationSupport.getEntityInformation(Trip.class, entityManager), entityManager);
    }

    public Trip getTrip(Trip trip) {
        return findOne((root, query, cb) -> cb.and(cb.equal(root.get(Trip_.season), trip.getSeason()),
                cb.equal(root.get(Trip_.distance), trip.getDistance()))).orElse(new Trip());
    }
}
