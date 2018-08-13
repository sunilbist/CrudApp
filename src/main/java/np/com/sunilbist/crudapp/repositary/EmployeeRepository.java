package np.com.sunilbist.crudapp.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import np.com.sunilbist.crudapp.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
