package by.paka.FeedbackTracker.service.impl;

import by.paka.FeedbackTracker.model.SystemUser;
import by.paka.FeedbackTracker.repository.UserRepository;
import by.paka.FeedbackTracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser user = userRepository.getById(username);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found in database");
        }
        Collection<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        user.setPassword(user.getPassword());
        return new User(user.getLogin(), user.getPassword(), authorities);
    }

    @Override
    public SystemUser saveUser(SystemUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
