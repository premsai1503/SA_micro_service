package in.ac.iiitb.domaincatalog.Controller;

import in.ac.iiitb.domaincatalog.Dto.DomainDto;
import in.ac.iiitb.domaincatalog.Service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/domains")
public class DomainController {

    @Autowired
    private DomainService domainService;

    @PostMapping("/getdomainsfromId/{id}")
    public ResponseEntity<ArrayList<DomainDto>> getDomains(@PathVariable String id) {

        ArrayList<DomainDto> domains = domainService.getDomains(id);
        return new ResponseEntity<>(domains, HttpStatus.OK);
    }

    @PostMapping("/addDomain")
    public ResponseEntity<DomainDto> getDomains(@RequestBody DomainDto newDomain) {

        DomainDto domain = domainService.addDomain(newDomain);
        return new ResponseEntity<>(domain, HttpStatus.OK);
    }

}
