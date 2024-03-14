package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception.InvalidCustomerIdException;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.message.EnumErrorMessage;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.mapper.CustomerMapper;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerService extends BaseService<
        Customer,
        CustomerRepository,
        CustomerMapper,
        CustomerDTO,
        CustomerSaveRequest,
        CustomerUpdateRequest>{

    private final CustomerRepository customerRepository;
    @Override
    protected CustomerRepository getRepository() {
        return customerRepository;
    }
    @Override
    protected CustomerMapper getMapper() {
        return CustomerMapper.INSTANCE;
    }

    @Override
    public CustomerDTO updateById(Long customerId, CustomerUpdateRequest request) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (Objects.isNull(customer)) {
            throw new InvalidCustomerIdException(EnumErrorMessage.INVALID_CUSTOMER_ID);
        }
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setLatitude(request.getLatitude());
        customer.setLongitude(request.getLongitude());
        customerRepository.save(customer);

        return getMapper().convertToDTO(customer);
    }


}
