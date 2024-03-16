package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.RestResponse;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.CustomerService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.RestaurantSuggestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@Validated
@Tag(name = "Customer Controller", description = "Customer Management")
public class CustomerController {
    private final CustomerService customerService;
    private final RestaurantSuggestionService restaurantSuggestionService;

    @PostMapping
    @Operation(summary = "Save customer")
    public ResponseEntity<RestResponse<CustomerDTO>> save(@Valid @RequestBody CustomerSaveRequest saveRequest) {
        CustomerDTO customerDTO = customerService.save(saveRequest);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @GetMapping
    @Operation(summary = "Get all customers")
    public ResponseEntity<RestResponse<List<CustomerDTO>>> getAll() {
        List<CustomerDTO> customerDTOList = customerService.getAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update customer by id")
    public ResponseEntity<RestResponse<CustomerDTO>> updateById(@PathVariable @NotBlank Long id,
                                                        @Valid @RequestBody CustomerUpdateRequest updateRequest) {
        CustomerDTO customerDTO = customerService.updateById(id, updateRequest);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete customer by id")
    public void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @GetMapping("/suggested-restaurants/{id}")
    @Operation(summary = "Suggest restaurants by customer id", description = "Suggest three restaurants to customer, by calculating distance and average score")
    public ResponseEntity<RestResponse<List<RestaurantDTO>>> suggestRestaurants(@PathVariable Long id) {
        List<RestaurantDTO> restaurantList = restaurantSuggestionService.suggestRestaurants(id);
        return ResponseEntity.ok(RestResponse.of(restaurantList));
    }
}
