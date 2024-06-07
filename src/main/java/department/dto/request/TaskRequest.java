package department.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record TaskRequest(
        @NotBlank
        String description,
        boolean isCompleted
) {
}
