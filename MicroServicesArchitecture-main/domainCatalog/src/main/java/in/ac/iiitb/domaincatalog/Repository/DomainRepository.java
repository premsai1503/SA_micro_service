package in.ac.iiitb.domaincatalog.Repository;

import in.ac.iiitb.domaincatalog.Entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface DomainRepository extends JpaRepository<Domain, Integer> {
    ArrayList<Domain> findByExpertId(String expertId);

    boolean existsByDomainId(String domainId);
}