package com.example.questiontesting.service;

import com.example.questiontesting.dto.LevelDto;
import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.entity.Level;
import com.example.questiontesting.entity.Profile;
import com.example.questiontesting.exception.NotFoundLevelException;
import com.example.questiontesting.exception.NotFoundProfileException;
import com.example.questiontesting.hateoas.ProfileAssembler;
import com.example.questiontesting.repositories.ProfileRepository;
import com.example.questiontesting.util.Mapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;
    private Mapper mapper;

    private ProfileAssembler assembler;

    public ProfileService(ProfileRepository profileRepository, Mapper mapper, ProfileAssembler profileAssembler) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
        this.assembler = profileAssembler;
    }

    public EntityModel<ProfileDto> getById(Long id) {
//        Profile profile = profileRepository.getById(id); // унаследован от JpaRepository
//        Profile profile = byId.get(); // можно так, но рез-т может быть пустым
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new NotFoundProfileException(id));// метод hibernate
        ProfileDto profileDto = mapper.mapper(profile, ProfileDto.class);

////        return profileDto;
        return assembler.toModel(profileDto);
    }

    public void saveProfile(ProfileDto profileDto) {
        Profile profile = mapper.mapper(profileDto, Profile.class);
        profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new NotFoundProfileException(id));
        profileRepository.delete(profile);
    }

}
