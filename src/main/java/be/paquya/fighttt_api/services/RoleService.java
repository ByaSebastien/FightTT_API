package be.paquya.fighttt_api.services;

import be.paquya.fighttt_api.models.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    public List<Role> GetAllRoles();
}
