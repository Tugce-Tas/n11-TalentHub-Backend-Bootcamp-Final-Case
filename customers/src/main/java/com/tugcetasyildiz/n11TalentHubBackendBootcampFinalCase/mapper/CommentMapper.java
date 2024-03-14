package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.mapper;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentRestaurantResponseDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.entity.Comment;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseMapper;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CommentSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CommentUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper extends BaseMapper<Comment, CommentDTO, CommentSaveRequest, CommentUpdateRequest> {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "customerName", expression = "java(comment.getCustomer().getName() + ' ' + comment.getCustomer().getSurname())")
    CommentDTO convertToDTO(Comment comment);

    List<CommentDTO> convertToDTOs(List<Comment> commentList);

    CommentRestaurantResponseDTO convertToCommentDTOForRestaurant(Comment comment);

    List<CommentRestaurantResponseDTO> convertToCommentDTOsForRestaurant(List<Comment> comment);

}
