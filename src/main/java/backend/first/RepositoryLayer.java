package backend.first;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RepositoryLayer {
    HashMap<String, Employee> employeeDb  = new HashMap<>();
    public String addEmployee(Employee employee){
        String userDbId = employee.getUserId();
        if(!employeeDb.containsKey(userDbId)){
            employeeDb.put(userDbId, employee);
            return "User has been added to DB!";
        }
        return "User Already exists with this Id";
    }
    public Employee getEmployee(String userId){
        Employee res = employeeDb.get(userId);
        return res;
    }
    public List getAllEmployees(){
        List<Employee> temp = new ArrayList<>();
// this is also correct but you can directly iterate in values so why not doing that
//        for(String emp : employeeDb.keySet()){
//            temp.add(employeeDb.get(emp));
//        }
        for(Employee employee : employeeDb.values()){
            temp.add(employee);
        }
        return temp;
    }

}
