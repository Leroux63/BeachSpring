package com.hb.dl.demo.services;

import com.hb.dl.demo.models.Plage;
import com.hb.dl.demo.repository.PlageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlageService {

        @Autowired
        private PlageRepository plageRepository;

        public List<Plage> getAll(){
                return this.plageRepository.findAll();
        }

        public Plage addPlage(Plage plage) {
                return plageRepository.save(plage);
        }

        public List<Plage> findByName(String name) {
                return plageRepository.findByName(name);
        }

        public Plage save(Plage plage){
                return plageRepository.save(plage);
        }

        public void remove(Plage plage){
                this.plageRepository.delete(plage);
        }

        public Page<Plage> paginatePlage(int nbResult, int page){
                Pageable pageable = PageRequest.of(page, nbResult);
                Page<Plage> plagePaginated = this.plageRepository.pagePagination(pageable);
                return plagePaginated;
        }
}
