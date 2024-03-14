package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller.contract;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.baseController.BaseControllerContractImpl;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.mapper.CustomerMapper;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.CustomerService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.RestaurantSuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CustomerControllerContractImpl extends BaseControllerContractImpl<
        CustomerService,
        Customer,
        CustomerRepository,
        CustomerMapper,
        CustomerDTO,
        CustomerUpdateRequest,
        CustomerSaveRequest> {

    private final CustomerService customerService;
    private final RestaurantSuggestionService restaurantSuggestionService;
    @Override
    protected CustomerService getService() {
        return customerService;
    }
    public List<RestaurantDTO>  suggestRestaurants(Long id) {
        return restaurantSuggestionService.suggestRestaurants(id);
    }

}
