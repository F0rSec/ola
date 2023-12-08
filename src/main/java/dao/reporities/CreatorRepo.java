package dao.reporities;

import dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepo extends JpaRepository<Creator,Long> {
}
