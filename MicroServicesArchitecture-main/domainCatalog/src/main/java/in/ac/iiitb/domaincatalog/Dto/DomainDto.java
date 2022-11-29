package in.ac.iiitb.domaincatalog.Dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link in.ac.iiitb.domaincatalog.Entity.Domain} entity
 */
@Data
public class DomainDto implements Serializable {
    private final String domainName;
    private final String expertId;
    private final String domainId;
}