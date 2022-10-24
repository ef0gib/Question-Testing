package com.example.questiontesting.service;

import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.entity.Profile;
import com.example.questiontesting.exception.NotFoundProfileException;
import com.example.questiontesting.repositories.ProfileRepository;
import com.example.questiontesting.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;
    private Mapper mapper;

    public ProfileService(ProfileRepository profileRepository, Mapper mapper) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
    }

    public ProfileDto getById(Long id) {
//        Profile profile = profileRepository.getById(id); // унаследован от JpaRepository
//        Profile profile = byId.get(); // можно так, но рез-т может быть пустым
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new NotFoundProfileException(id));// метод hibernate
        ProfileDto profileDto = mapper.mapper(profile, ProfileDto.class);

//        mapper.mapper(ProfileDto, Profile.class); // обратное преобразование

        return profileDto;
    }
}
