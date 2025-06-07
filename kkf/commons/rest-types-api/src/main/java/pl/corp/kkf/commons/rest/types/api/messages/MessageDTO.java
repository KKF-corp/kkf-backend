package pl.corp.kkf.commons.rest.types.api.messages;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Komunikaty zwrotne z systemu")
public class MessageDTO {

    @Schema(description = "Rodzaj komunikatu")
    private MessageType messageType;

    @Schema(description = "Treść komunikatu")
    private String message;

//    @Schema(description = "Ścieżka do atrybutu, któego dotyczy komunikat")
//    private String attributePath;

    public MessageDTO() {
    }

    public MessageDTO(String message) {
        this.message = message;
    }

    public MessageDTO(MessageType messageType, String message) {
        this.messageType = messageType;
        this.message = message;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}