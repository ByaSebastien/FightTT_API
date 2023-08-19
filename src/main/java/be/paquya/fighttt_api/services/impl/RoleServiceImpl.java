package be.paquya.fighttt_api.services.impl;

import be.paquya.fighttt_api.repositories.RoleRepository;
import be.paquya.fighttt_api.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    //public
}
