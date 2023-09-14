package com.hb.dl.demo.repository;

import com.hb.dl.demo.forms.SearchForm;
import com.hb.dl.demo.models.Plage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlageCriteriaRepository {

    @Autowired
    private EntityManager em;



    public List<Plage> searchEnginePlage(SearchForm searchForm){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Plage> cq = cb.createQuery(Plage.class);
        Root<Plage> plageRoot = cq.from(Plage.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if (searchForm.isPlageWithPicture()){
            Predicate plageWithPicture = cb.isNotNull(plageRoot.get("image"));
            predicates.add(plageWithPicture);
        }
        if (!searchForm.getSearchBar().isEmpty()){
            Predicate p1 =cb.like(plageRoot.get("name"),"%"+searchForm.getSearchBar()+"%");
            Predicate p2 =cb.like(plageRoot.get("address"),"%"+searchForm.getSearchBar()+"%");
            Predicate p3 =cb.like(plageRoot.get("city"),"%"+searchForm.getSearchBar()+"%");
            Predicate p4 =cb.like(plageRoot.get("postalCode"),"%"+searchForm.getSearchBar()+"%");

            predicates.add((cb.or(p1,p2,p3,p4)));
        }
        if (!searchForm.getDepartmentNumber().isEmpty()){
            String cpNumber = searchForm.getDepartmentNumber();
            if(cpNumber.length() == 1){
                cpNumber = "0"+cpNumber;
            }
            Predicate p1 = cb.like(plageRoot.get("postalCode"),cpNumber+"%");
            predicates.add(p1);
        }
        cq.where(predicates.toArray(new Predicate[]{}));

        TypedQuery<Plage> query = em.createQuery(cq);

        return query.getResultList();
    }
}
