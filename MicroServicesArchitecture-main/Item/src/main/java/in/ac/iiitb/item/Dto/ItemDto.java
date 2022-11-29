package in.ac.iiitb.item.Dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link in.ac.iiitb.item.Entity.Item} entity
 */
@Data
public class ItemDto implements Serializable {
    private final String domainId;
    private final String itemType;
    private final String itemId;
    private final String description;
    private final String option1;
    private final String option2;
    private final String option3;
    private final String option4;
}