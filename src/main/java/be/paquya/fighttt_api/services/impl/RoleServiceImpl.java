package be.paquya.fighttt_api.services.impl;

import be.paquya.fighttt_api.models.entities.Role;
import be.paquya.fighttt_api.repositories.RoleRepository;
import be.paquya.fighttt_api.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> GetAllRoles() {
        return this.roleRepository.findAll();
    }

    //public
}
