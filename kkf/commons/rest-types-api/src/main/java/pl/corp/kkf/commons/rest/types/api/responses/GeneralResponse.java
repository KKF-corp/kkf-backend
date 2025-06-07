package pl.corp.kkf.commons.rest.types.api.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.messages.MessageDTO;

import java.util.List;

@Schema(name = "Ogólna odpowiedź serwisu")
public class GeneralResponse {

    @Schema(description = "Wskaźnik czy działanie zakończone sukcesem")
    private boolean success;

    @Schema(description = "Komunikaty błędów")
    private List<MessageDTO> messages;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
}
