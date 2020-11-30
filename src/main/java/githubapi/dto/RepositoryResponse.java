package githubapi.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RepositoryResponse {
    Long id;
    String name;
    String full_name;
    OwnerResponse owner;
}
