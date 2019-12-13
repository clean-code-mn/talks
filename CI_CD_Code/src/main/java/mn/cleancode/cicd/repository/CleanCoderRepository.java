package mn.cleancode.cicd.repository;

import mn.cleancode.cicd.model.CleanCoder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository public interface CleanCoderRepository extends CrudRepository<CleanCoder, Long> {

}
