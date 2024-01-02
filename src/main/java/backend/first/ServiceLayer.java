package backend.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ServiceLayer {
    @Autowired
    private RepositoryLayer repositoryLayer;
    public String  addEmployee(Employee employee){
        String res = repositoryLayer.addEmployee(employee);
        return res;
    }
    public Employee getEmployee(String userId){
        Employee res = repositoryLayer.getEmployee(userId);
        return res;
    }
    public List getAllEmployees(){
        List temp = repositoryLayer.getAllEmployees();
        return temp;
    }

}
