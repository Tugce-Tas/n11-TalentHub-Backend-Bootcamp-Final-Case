package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller.contract.CustomerControllerContractImpl;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.*;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.baseController.BaseController;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.baseController.BaseControllerContractImpl;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.mapper.CustomerMapper;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController extends BaseController<
        CustomerDTO,
        CustomerSaveRequest,
        CustomerUpdateRequest,
        CustomerService,
        Customer,
        CustomerRepository,
        CustomerMapper> {

    private final CustomerControllerContractImpl customerContract;
    @Override
    protected BaseControllerContractImpl<CustomerService, Customer, CustomerRepository, CustomerMapper, CustomerDTO, CustomerUpdateRequest, CustomerSaveRequest> getControllerContract() {
        return customerContract;
    }

    @GetMapping("/suggested-restaurants/{id}")
    public ResponseEntity<RestResponse<List<RestaurantDTO>>> suggestRestaurants(@PathVariable Long id) {
        List<RestaurantDTO> restaurantList = customerContract.suggestRestaurants(id);
        return ResponseEntity.ok(RestResponse.of(restaurantList));
    }
}

