package io.psychquest.app.infra.domain.model;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    Optional<User> findOneByCredentialsActivationKey(String activationKey);

    Optional<User> findOneByCredentialsPasswordResetKey(String resetKey);

    Optional<User> findOneByEmailIgnoreCase(String email);

    Set<User> findAllByCredentialsActivatedIsFalseAndCredentialsActivationKeyCreatedAtBefore(Instant createdBefore);
}
