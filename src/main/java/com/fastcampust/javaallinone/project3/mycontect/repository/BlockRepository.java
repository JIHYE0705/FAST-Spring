package com.fastcampust.javaallinone.project3.mycontect.repository;

import com.fastcampust.javaallinone.project3.mycontect.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BlockRepository extends JpaRepository<Block, Long> {
}
