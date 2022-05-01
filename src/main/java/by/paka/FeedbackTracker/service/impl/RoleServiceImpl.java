package by.paka.FeedbackTracker.service.impl;

import by.paka.FeedbackTracker.model.Role;
import by.paka.FeedbackTracker.repository.RoleRepository;
import by.paka.FeedbackTracker.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
