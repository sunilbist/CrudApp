package np.com.sunilbist.crudapp.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import np.com.sunilbist.crudapp.entity.Student;

@Repository
public interface StudentRepositary extends CrudRepository<Student, Integer> {

}
