package githubapi.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RepositoryResponse {
    Long id;
    String name;
    String full_name;
    OwnerResponse owner;
}
