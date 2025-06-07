package pl.corp.kkf.services.dictionaries.api.addresses;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.dictionaries.api.addresses.dto.*;

@Path("/dictionaries/addresses")
@Tag(name = "AddressApiService", description = "Usługa obsługi danych słownikowych adresu")
public interface AddressApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie adresu")
    AddressResponse getAddress(@Parameter(description = "Identyfikator adresu")
                                 @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie adresu")
    AddressResponse createAddress(@Parameter(description = "Obiekt adresu")
                                    Address address);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja adresu")
    AddressResponse updateAddress(@Parameter(description = "Obiekt adresu")
                                    Address address);

    @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja adresu")
    GeneralResponse archiveAddress(@Parameter(description = "Identyfikator adresu")
                                 @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie adresu")
    GeneralResponse unarchiveAddress(@Parameter(description = "Identyfikator adresu")
                                   @PathParam("id") long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    AddressListResponse getAllAddresses();

    @POST
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Wyszukiwanie adresów według kryteriów")
    AddressSearchResponse findByCriteria(@Parameter(description = "Zapytanie wyszukiwania adresów")
                                            AddressSearchRequest request);
}
