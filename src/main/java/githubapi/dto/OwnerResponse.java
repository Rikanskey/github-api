package githubapi.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OwnerResponse {
    String login;
    Long id;
}
