package org.example.footballmanagerdn.services.iml;

import org.example.footballmanagerdn.exception.NotFoundException;
import org.example.footballmanagerdn.models.DTO.PlayerDto;
import org.example.footballmanagerdn.models.DTO.PlayerFormCreateDto;
import org.example.footballmanagerdn.models.DTO.PlayerFormUpdateDto;
import org.example.footballmanagerdn.models.Player;
import org.example.footballmanagerdn.models.User;
import org.example.footballmanagerdn.repositories.IPlayerRepo;
import org.example.footballmanagerdn.repositories.IUserRepo;
import org.example.footballmanagerdn.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepo playerRepo;
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${upload.path}")
    private String fileUpload;

    @Override
    public Page<PlayerDto> findAll(int page, int size, String sortString, String name, Double salaryMin, Double salaryMax, String position, String status) {
        Sort sort = createSort(sortString);
        Pageable pageable = PageRequest.of(page, size, sort);
        return playerRepo.findAll(pageable, name, salaryMin, salaryMax, position, status);
    }

    private Sort createSort(String sortString) {
        if (sortString != null && !sortString.isEmpty()) {
            String[] sorts = sortString.split(" ");
            return Sort.by(Sort.Direction.fromString(sorts[1]), sorts[0]);
        } else {
            return Sort.by(Sort.Direction.DESC, "id");
        }
    }


    @Override
    public void createPlayer(PlayerFormCreateDto playerFormCreateDto) {

        validateUniqueEmail(playerFormCreateDto.getUserEmail());

// Todo: refactor tách hàm và sử dụng builder pattern
        User user = new User();
        user.setEmail(playerFormCreateDto.getUserEmail());
        user.setPassword(passwordEncoder.encode(playerFormCreateDto.getUserPassword()));
        user = userRepo.save(user);

        String avatarFileName = saveFile(playerFormCreateDto.getAvatar());

// Todo: refactor tách hàm
        Player player = Player.builder()
                .name(playerFormCreateDto.getName())
                .dob(playerFormCreateDto.getDob())
                .homeTown(playerFormCreateDto.getHomeTown())
                .performance(playerFormCreateDto.getPerformance())
                .height(playerFormCreateDto.getHeight())
                .weight(playerFormCreateDto.getWeight())
                .salary(playerFormCreateDto.getSalary())
                .ranking(playerFormCreateDto.getRanking())
                .abilityProfile(playerFormCreateDto.getAbilityProfile())
                .position(playerFormCreateDto.getPosition())
                .status(playerFormCreateDto.getStatus())
                .avatar(avatarFileName)
                .user(user)
                .build();
        playerRepo.save(player);
    }

    private String saveFile(MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            return null;
        }
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

    private void validateUniqueEmail(String email) {
        if (userRepo.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
    }

    @Override
    public void save(Player player) {
        playerRepo.save(player);

    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepo.findById(id);
    }

    @Override
    public void updatePlayer(Long id, PlayerFormUpdateDto playerFormUpdateDto) {
        Optional<Player> playerOptional = playerRepo.findById(id);
        if (playerOptional.isEmpty()) {
            throw new NotFoundException("Player not found");
        }

        String avatarFileName = saveFile(playerFormUpdateDto.getAvatar());

        Player player = playerOptional.get();
        player.setName(playerFormUpdateDto.getName());
        player.setDob(playerFormUpdateDto.getDob());
        player.setHomeTown(playerFormUpdateDto.getHomeTown());
        player.setPerformance(playerFormUpdateDto.getPerformance());
        player.setHeight(playerFormUpdateDto.getHeight());
        player.setWeight(playerFormUpdateDto.getWeight());
        player.setSalary(playerFormUpdateDto.getSalary());
        player.setRanking(playerFormUpdateDto.getRanking());
        player.setAbilityProfile(playerFormUpdateDto.getAbilityProfile());
        player.setPosition(playerFormUpdateDto.getPosition());
        player.setStatus(playerFormUpdateDto.getStatus());
        player.setAvatar(avatarFileName);

        playerRepo.save(player);
    }

    @Override
    public void deletePlayer(Long id) {
        Optional<Player> playerOptional = findById(id);
        if (playerOptional.isEmpty()) {
            throw new NotFoundException("Player not found");
        }
        playerRepo.deleteById(id);
    }


}
