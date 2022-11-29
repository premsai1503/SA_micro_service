package in.ac.iiitb.domaincatalog.Service;

import in.ac.iiitb.domaincatalog.Dto.DomainDto;

import java.util.ArrayList;

public interface DomainService {
    public ArrayList<DomainDto> getDomains(String id);

    public DomainDto addDomain(DomainDto newDomain);
}
