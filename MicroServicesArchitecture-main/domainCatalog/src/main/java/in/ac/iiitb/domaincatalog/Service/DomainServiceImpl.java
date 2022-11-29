package in.ac.iiitb.domaincatalog.Service;

import in.ac.iiitb.domaincatalog.Dto.DomainDto;
import in.ac.iiitb.domaincatalog.Entity.Domain;
import in.ac.iiitb.domaincatalog.Repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public ArrayList<DomainDto> getDomains(String id) {
        ArrayList<Domain> domains = domainRepository.findByExpertId(id);
        ArrayList<DomainDto> domainDtos = new ArrayList<>();
        for(int i=0; i<domains.size(); i++){
            domainDtos.add( new DomainDto(domains.get(i).getDomainName(),
                                            domains.get(i).getExpertId(),
                                            domains.get(i).getDomainId()));
        }
        return domainDtos;
    }

    @Override
    public DomainDto addDomain(DomainDto newDomain) {
        Domain domain = new Domain();
        domain.setDomainId(newDomain.getDomainId());
        domain.setDomainName(newDomain.getDomainName());
        domain.setExpertId(newDomain.getExpertId());
        domainRepository.save(domain);
        return newDomain;
    }
}
