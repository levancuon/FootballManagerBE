package org.example.footballmanagerdn.services.iml;

import org.example.footballmanagerdn.models.DTO.PlayerDto;
import org.example.footballmanagerdn.models.DTO.PlayerUserDto;
import org.example.footballmanagerdn.models.Player;
import org.example.footballmanagerdn.repositories.IPlayerRepo;
import org.example.footballmanagerdn.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepo playerRepo;

    @Override
    public Page<PlayerDto> findAll(int page, int size, String sortString, String name, Double salaryMin, Double salaryMax, String position, String status) {
        Sort sort;
        if(sortString != null && !sortString.isEmpty()) {
            String[] sorts = sortString.split(" ");
            sort = Sort.by(sorts[1].equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sorts[0]);
        }else {
            sort = Sort.by(Sort.Direction.DESC, "id");
        }
        Pageable pageable = PageRequest.of(page, size, sort);
        return playerRepo.findAll(pageable, name, salaryMin, salaryMax, position, status);
    }

    @Override
    public void createPlayer(PlayerUserDto playerUserDto) {
    }
}
