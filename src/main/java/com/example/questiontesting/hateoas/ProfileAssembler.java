package com.example.questiontesting.hateoas;

import com.example.questiontesting.controller.ProfileController;
import com.example.questiontesting.dto.ProfileDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProfileAssembler implements RepresentationModelAssembler<ProfileDto, EntityModel<ProfileDto>> {
    @Override
    public EntityModel<ProfileDto> toModel(ProfileDto entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(ProfileController.class)
                        .updateProfile(
                                entity,
                                entity.getId()))
                        .withRel("Update Profile by id with " + HttpMethod.PUT),
                linkTo(methodOn(ProfileController.class)
                        .deleteProfile(
                                entity.getId()))
                        .withRel("Delete Profile by id with " + HttpMethod.DELETE),
                linkTo(methodOn(ProfileController.class)
                        .addProfile(
                                entity))
                        .withRel("Create Profile with " + HttpMethod.POST)
        );
    }

    @Override
    public CollectionModel<EntityModel<ProfileDto>> toCollectionModel(Iterable<? extends ProfileDto> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
