package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.mapper;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseMapper;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper extends BaseMapper<Customer, CustomerDTO, CustomerSaveRequest, CustomerUpdateRequest> {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    @Mapping(target = "fullName", expression = "java(customer.getName() + ' ' + customer.getSurname())")
    CustomerDTO convertToDTO(Customer customer);

    @Mapping(target = "fullName", expression = "java(customer.getName() + ' ' + customer.getSurname())")
    List<CustomerDTO> convertToDTOs(List<Customer> customerList);

}
